


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Cell_Member.CellMember;
import Tpo.tpo;
import stu.student;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID=request.getParameter("userID");
		String opass=request.getParameter("opass");
		String npass=request.getParameter("npass");
		String cpass=request.getParameter("cpass");
		if(cpass.equals(npass)){
		HttpSession session=request.getSession();
		String des=(String)session.getAttribute("des");
		
		System.out.println(des);
		if(des.equals("tpo")){
			tpo t=(tpo)session.getAttribute("t");
			if(t.getTid().equals(userID)){
			int n=t.change(userID,opass, npass);
			if(n==1){
				response.sendRedirect("pUpdateSuccess.jsp");
			}
		}
			else
				response.sendRedirect("unupdate.html");
		}
		else if(des.equals("cell_members")){
			CellMember c=(CellMember)session.getAttribute("t");
			c.getId();
			int n=c.change(userID, opass, npass);
			//System.out.println(n);
			if(n==1){
				response.sendRedirect("pUpdateSuccess.jsp");
			}
			else
				response.sendRedirect("unupdate.html");
		}
		else if(des.equals("student")){
			//student s=new student();
			student t=(student)session.getAttribute("t");
			if(t.getSid().equals(userID)){
			int n=t.change(userID, opass, npass);
			if(n==1){
				response.sendRedirect("pUpdateSuccess.jsp");
			}
			}
			else
				response.sendRedirect("unupdate.html");
		}

	}
		else 
			response.sendRedirect("unupdate.html");
	}
	
}
