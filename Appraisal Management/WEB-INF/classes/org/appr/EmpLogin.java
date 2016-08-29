package org.appr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class EmpLogin
 */
@WebServlet("/elogin")
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		//out.println("<html><body>");
		try {
			AppraisalDAO dao=new AppraisalDAO();
			Employee e1=dao.validate(email, pass);
			if (e1==null)
			{
				
				response.sendRedirect("invalid.jsp");
				
			}
			else if(e1!=null)
			{
			String nm=e1.getEid();
			if(nm.startsWith("C"))
			{
				response.sendRedirect("emploginvalid.jsp");
			}
			//HttpSession session=request.getSession(true);
		//	session.setAttribute("name", e1);
			request.setAttribute("emp", e1);
			request.setAttribute("name", e1.getName());
		//	String nme=(String)session.getAttribute("name");
			//request.setAttribute("eid", e1.getEid());
			ArrayList<Feedback> al=dao.getAllQues(e1.getEid());
			request.setAttribute("flist", al);
			ArrayList<Feedback> ar1=dao.getAllQues(e1.getEid());
			Feedback f=ar1.get(0);
			String flag=f.getFlag();
			//ArrayList<Feedback> al=dao.getAllQues();
			
			
			RequestDispatcher rd=request.getRequestDispatcher("emplogin.jsp");		//03.08.16 prev:showproducts
		//	rd.set
			if(flag.equals("A")){
				rd.forward(request, response);
			}else{
				//out.print("<h4>You have already submitted the form!<h4>");
				response.sendRedirect("sub.jsp");
			}
		
			}
		}
	
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("<h4>ERROR IN CLASS LOADING<h4>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("<h4>ERROR IN SQL : " +e.getMessage()+"</h4>");
		}
		//out.println("</body></html>");
		out.close();
	}
}

