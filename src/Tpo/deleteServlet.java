package Tpo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
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
		String rollno=request.getParameter("rollno");
		String des=request.getParameter("Designation");
		HttpSession session=request.getSession();
		tpo t=(tpo)session.getAttribute("t");
		if(des.equals("student")){
			int n=t.deleteStud(rollno);
			if(n==1){
				response.sendRedirect("deleteSuccess.html");
			}
			else 
				response.sendRedirect("deleteUnsuccessful.html");
		}
		else if(des.equals("cell_member")){
			
			int n=t.deleteCellMember(rollno);
			if(n==1){
				response.sendRedirect("deleteSuccess.html");
			}
			else 
				response.sendRedirect("deleteUnsuccessful.html");
		}
	}

}
