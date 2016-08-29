package org.appr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MngrFeedbackServlet
 */
@WebServlet("/MngrFeedbackServlet")
public class MngrFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MngrFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//out.println("Heya");
		String eid=request.getParameter("id");		//from html
		//out.println(eid);
		Object obj=request.getAttribute("flist");		//from forward
		ArrayList<Feedback> fdlist=(ArrayList<Feedback>)obj;
		int q=0;
		String x=request.getParameter("c");
		
		
		int i=Integer.parseInt(x);
			for(int y=1;y<=i;y++){
				String fr="feedback_rating";
				String count=Integer.toString(q);
				String qid="qid";
				fr+=count;
				qid+=count;
			int man_f=Integer.parseInt(request.getParameter(fr));	
			//String s=request.getParameter("feedback_rating"+q);	
			try {
				AppraisalDAO ad=new AppraisalDAO();
				String qidf=request.getParameter(qid);
				if (man_f!=0){
					ad.mngrscr(eid, "C", qidf, man_f);
				}	
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				response.sendError(999,"ERR IN CLASS LOADING");
			} catch (SQLException e) {
				
				e.printStackTrace();
				response.sendError(998,"ERR IN SQL : "+e.getMessage()+"ERROR CODE : "+e.getErrorCode());
			}
				//out.println(s);
			q+=1;
		}
			response.sendRedirect("mngrupdate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
