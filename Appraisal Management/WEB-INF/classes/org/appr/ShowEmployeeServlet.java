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

import org.appr.Employee;

/**
 * Servlet implementation class ShowEmployeeServlet
 */
@WebServlet("/showemployee")
public class ShowEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEmployeeServlet() {
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
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
	
		String man_id=request.getParameter("manager_id");
		
		try {
			AppraisalDAO dao=new AppraisalDAO();
			ArrayList<Employee> e2=dao.getAllNames(man_id);
			if (e2==null)
			{
				
				response.sendError(300, "invalid");
				
			}
			else if(e2!=null)
			{
				
				//Object obj=request.getAttribute("FLIST");
				//ArrayList<Employee> flist=(ArrayList<Employee>)obj;
				request.setAttribute("FLIST",e2 );
				RequestDispatcher rd=request.getRequestDispatcher("emplist.jsp");
				rd.forward(request, response);
				
				/*Object obj=request.getAttribute("PLIST");
				
				out.println("<html><body>");
				//out.println("<h3> logged name : "+nm+"</h3>");
				out.println("<h4> Employyes under me </h4>");
				out.println("<table border='1'>");
				out.println("<tr><th>EMPLOYEE_ID</th><th>EMPLOYEE_NAME</th><th>HYPERLINKS</th></tr>");
				for(Employee p:e2)
				{
					out.println("<tr><td>"+p.getEid()+"</td>");
					out.println("<td>"+p.getName()+"</td></tr>");
				}
				out.println("</table>");
				out.println("</body></html>");
				out.close();	
			
		
			
				//RequestDispatcher rd=request.getRequestDispatcher("ManagerLogin.jsp");
				//rd.forward(request, response);
		/*		out.print("<h4>Hello EMPLOYEE!<h4>");
				out.println("<h5>NAME :" +e1.getName()+"</h5>");*/
				
				
			}
			
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("<h4>ERROR IN CLASS LOADING<h4>");
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("<h4>ERROR IN SQL : " +e.getMessage()+"</h4>");
		}
		out.println("</body></html>");
		out.close();
	}
}
