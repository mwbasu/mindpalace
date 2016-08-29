package org.appr;

public class EmployeeFeedback {
	
	private String emp_id, que_id, flag;

	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getQue_id() {
		return que_id;
	}
	public void setQue_id(String que_id) {
		this.que_id = que_id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public EmployeeFeedback(int self_f, int manager_f, String emp_id, String que_id, String flag) {
		super();
		
		this.emp_id = emp_id;
		this.que_id = que_id;
		this.flag = flag;
	}
	public EmployeeFeedback() {
		super();
	}
	
}
