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

/**
 * Servlet implementation class HRLoginServlet
 */
@WebServlet("/hlogin")
public class HrLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrLoginServlet() {
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
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//out.println("Hello");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		try {
			AppraisalDAO dao=new AppraisalDAO();
			Employee e1=dao.validate(email, pass);
			if(e1==null){
				response.sendRedirect("invalid.jsp");
			}
			else if(e1!=null){
			String s1=e1.getEid();
			if(s1.startsWith("E")||s1.startsWith("M")){
				response.sendRedirect("InvalidUser.jsp");
				
			}
			String a=e1.getEmail();
			//if(a.equals(e1.getEmail())){
				//ArrayList<Employee> ale=dao.empScore();
				//System.out.println(ale);
				request.setAttribute("emp",e1);
				RequestDispatcher rd=request.getRequestDispatcher("hr.jsp");
				rd.forward(request, response);
			}
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(999,"err in class loading");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(998,"err in SQL "+e.getMessage()+"Error code "+e.getErrorCode());
		}
	}

}
