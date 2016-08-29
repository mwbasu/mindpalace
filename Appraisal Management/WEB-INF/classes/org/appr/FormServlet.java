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
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*try {
			AppraisalDAO dao=new AppraisalDAO();
			Employee e1=dao.empGenarate(eid);
			
			request.setAttribute("emp", e1);
			request.setAttribute("name", e1.getName());
			request.setAttribute("eid", e1.getEid());
			ArrayList<Feedback> al=dao.getAllQues(e1.getEid());
			//ArrayList<Feedback> al=dao.getAllQues();
			request.setAttribute("flist", al);
			
			RequestDispatcher rd=request.getRequestDispatcher("form.jsp");		//03.08.16 prev:showproducts
		//	rd.set
			rd.forward(request, response);
		
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
		out.close();*/
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String eid=request.getParameter("h1");//from html
		//String name=request.getParameter("h2");
		//out.println(eid);
		try {
			AppraisalDAO  dao1=new AppraisalDAO();
			Employee e2=dao1.empGenarate(eid);
			request.setAttribute("emp", e2);
			request.setAttribute("name", e2.getName());
			ArrayList<Feedback> alf=dao1.getAllQues(eid);
			request.setAttribute("flist", alf);
			RequestDispatcher rd=request.getRequestDispatcher("form.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
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
