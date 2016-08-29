package org.appr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppraisalDAO {
	
	private Connection con;
	
	private String sqlValidate="select EMP_ID, EMP_NAME, EMP_EMAIL, EMP_CONTACT, EMP_ADDRESS, DOJ, MANAGER_ID from EMPLOYEE where EMP_EMAIL=? and PASSWORD=?";
	private String sqlregister="UPDATE EMPLOYEE_FEEDBACK SET SELF_F=?, FLAG=? WHERE EMPID=? AND QUEID=?";
	private String sqlmngrregister="UPDATE EMPLOYEE_FEEDBACK SET MANAGER_F=?, FLAG=? WHERE EMPID=? AND QUEID=?";
	private String empfeedback="SELECT QUE_ID, QUE_TYPE, QUE_TEXT FROM FEEDBACK";
	private String sqlempgetfeedback="SELECT QUE_ID,QUE_TYPE,QUE_TEXT,SELF_F,FLAG FROM FEEDBACK,EMPLOYEE_FEEDBACK WHERE FEEDBACK.QUE_ID=EMPLOYEE_FEEDBACK.QUEID AND EMPLOYEE_FEEDBACK.EMPID=?";
	private String checking="select EMP_ID, EMP_NAME, EMP_EMAIL, EMP_CONTACT, EMP_ADDRESS, DOJ from EMPLOYEE WHERE MANAGER_ID=?";
	private String manemp="SELECT EMP_ID, EMP_NAME, EMP_EMAIL, EMP_CONTACT, EMP_ADDRESS, DOJ, MANAGER_ID from EMPLOYEE where EMP_ID=?";
	private String empscore="SELECT EMP_ID,EMP_NAME,MANAGER_F FROM EMPLOYEE,EMPLOYEE_FEEDBACK WHERE EMPLOYEE.EMP_ID=EMPLOYEE_FEEDBACK.EMPID AND EMPLOYEE_FEEDBACK.FLAG='C' ";
	
	private PreparedStatement pstmtValidate, pstmtmanemp;
	private PreparedStatement feedbackgenarate,pstmtchecking;
	private PreparedStatement pstmtregister,pstmtsqlempgetfeedback;
	private PreparedStatement pstmtempscore,pstmtmngrscore;
	
	public AppraisalDAO() throws SQLException, ClassNotFoundException{		//constructor
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		
		String dbuser="hr";
		String dbpass="hr123";
		
		
			Class.forName(driver);
			con=DriverManager.getConnection(url,dbuser,dbpass);
			
			pstmtValidate=con.prepareStatement(sqlValidate);
			feedbackgenarate=con.prepareStatement(empfeedback);
			pstmtregister=con.prepareStatement(sqlregister);
			pstmtsqlempgetfeedback=con.prepareStatement(sqlempgetfeedback);
			pstmtchecking=con.prepareStatement(checking);
			pstmtmanemp=con.prepareStatement(manemp);
			pstmtempscore=con.prepareStatement(empscore);
			pstmtmngrscore=con.prepareStatement(sqlmngrregister);
	}
	public Employee validate(String email, String pass) throws SQLException{
		pstmtValidate.setString(1, email);
		pstmtValidate.setString(2, pass);
		
		ResultSet rs=pstmtValidate.executeQuery();
		
		if(rs.next()){
			Employee e=new Employee(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), null);		//not using set
			return e;
		}else{
			return null;
		}
	}
	public ArrayList<Feedback> getAllQues(String empid) throws SQLException{
		pstmtsqlempgetfeedback.setString(1, empid);
		
		ResultSet rs=pstmtsqlempgetfeedback.executeQuery();
		ArrayList<Feedback> list=null;
		while(rs.next()){
			Feedback p=new Feedback(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getInt(4));
			//p.setSelf_f(rs.getInt(4));  sir
			if(list==null){
				list=new ArrayList<>();
			}
			list.add(p);
		}
		return list;
	}
	public void register(String emp_id,String flag, String que_id,int self_f)throws SQLException{
		
		pstmtregister.setInt(1, self_f);
		pstmtregister.setString(2, flag);
		pstmtregister.setString(3, emp_id);
		pstmtregister.setString(4, que_id);		
		pstmtregister.executeUpdate();
	}
	public void mngrscr(String emp_id,String flag, String que_id,int MANAGER_F)throws SQLException{
		
		pstmtmngrscore.setInt(1, MANAGER_F);
		pstmtmngrscore.setString(2, "C");
		pstmtmngrscore.setString(3, emp_id);
		pstmtmngrscore.setString(4, que_id);		
		pstmtmngrscore.executeUpdate();
	}
	public ArrayList<Employee> getAllNames(String man_id) throws SQLException
	{	
		pstmtchecking.setString(1, man_id);
		ResultSet rs=pstmtchecking.executeQuery();
		ArrayList<Employee> list=null;
		while(rs.next()){
			Employee p2=new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));	
			
			if(list==null){
				list=new ArrayList<>();
			}
			list.add(p2);
		}
		return list;
	
}
	public Employee empGenarate(String eid) throws SQLException{
		pstmtmanemp.setString(1, eid);
		//Employee e2=(Employee) pstmtmanemp.executeQuery();
		ResultSet rs=pstmtmanemp.executeQuery();
		
		if(rs.next()){
			Employee e=new Employee(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));		//not using set
			return e;
		}else{
			return null;
		}	
	}
	public ArrayList<Employee> empScore() throws SQLException{
		ResultSet rs2=pstmtempscore.executeQuery();
		//System.out.println(rs2);
		ArrayList<Employee> list=null;
		ArrayList<Employee> list2=null;
		while(rs2.next()){
			Employee p2=new Employee(rs2.getString(1),rs2.getString(2),rs2.getInt(3));
			if(list==null){
				list=new ArrayList<>();
				
			}
			list.add(p2);
		}
		int s=list.size();
		//System.out.println(s);
		Employee e3=list.get(0);
		String eid0 = e3.getEid();
		String e_name="X", eid="X";
		int i=0, x=0;
		//System.out.println(s1);
		//System.out.println(list);
		//System.out.println(eid0);
		for(Employee e:list){
			String s1=e.getEid();
			//System.out.println(s1+"---"+eid);
			//System.out.println("H");
			if(s1.equals(eid0)){
				i+=1;
				x+=e.getMan_r();
				//System.out.println(i+"---"+x);
				if(i==4){
					//System.out.println("H");
					x*=5;
					e_name=e.getName();
					Employee e1=new Employee(eid, e_name, x);
					x=0;
					i=0;
					if(list2==null){
						list2=new ArrayList<>();
					}
					list2.add(e1);
				}
				//System.out.println("H");
			}else{
				i+=1;
				x+=e.getMan_r();
				eid0=e.getEid();
			}
		}
		//System.out.println("hi");
		return list2;
	}
}
