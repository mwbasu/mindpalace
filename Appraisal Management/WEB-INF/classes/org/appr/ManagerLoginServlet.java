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
 * Servlet implementation class ManagerLoginServle
 */
@WebServlet("/mlogin")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		//out.println("<html><body>");
		try {
			AppraisalDAO dao=new AppraisalDAO();
			Employee e1=dao.validate(email, pass);
			//String man_id=null;
			//Employee e2=dao.check(man_id);
			if (e1==null)
			{
				
				response.sendRedirect("invalid.jsp");
				
			}
			else if(e1!=null)
			{
			String nm=e1.getEid();
			if(nm.startsWith("E"))
			{
				response.sendRedirect("mngrloginvalid.jsp");
			}
			request.setAttribute("emp", e1);
			request.setAttribute("name", e1.getName());
			request.setAttribute("email", e1.getEmail());
			//request.setAttribute("man_id", e2.getMan_id());
			ArrayList<Feedback> al=dao.getAllQues(nm);
			request.setAttribute("flist", al);
			
			String a=e1.getEmail();
			
				RequestDispatcher rd=request.getRequestDispatcher("employeelist.jsp");
				rd.forward(request, response);
		/*		out.print("<h4>Hello EMPLOYEE!<h4>");
				out.println("<h5>NAME :" +e1.getName()+"</h5>");*/
				
				
			}
			
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(999,"err in class loading");
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(998,"err in SQL "+e.getMessage()+"Error code "+e.getErrorCode());
		}
		//out.println("</body></html>");
		out.close();
	}
}


