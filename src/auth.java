

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Cell_Member.CellMember;
import Tpo.tpo;
import stu.NonTechstud;
import stu.TechStudent;
import stu.student;
/**
 * Servlet implementation class servlet
 */
@WebServlet(description = "first servelet", urlPatterns = { "/servletReady" })
public class auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter p= response.getWriter();
		response.setContentType("text/html");
		//System.out.println();
		//p.print("<h2>hello all</h2>");
		String rollno=request.getParameter("rollno");
		String pass=request.getParameter("password");
		String des=request.getParameter("Designation");
		p.println(rollno+pass+des);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter p= response.getWriter();
		response.setContentType("text/html");
		//System.out.println();
		//p.print("<h2>hello all</h2>");
		String rollno=request.getParameter("rollno");
		String pass=request.getParameter("password");
		String des=request.getParameter("Designation");
		
		HttpSession session=request.getSession();    
		//p.println(rollno+pass+des);
		session.setAttribute("des",des );
		vald v=new vald();
		int val;
		val=v.validate(rollno, pass,des);
		if(val==1  & des.equals("student")){
			//p.print("heeloo");
		student s=new student();
		
		int q=s.checkType(rollno);
		System.out.println(q);
			if(q==1){
				TechStudent t=new TechStudent();
				t.getDetails(rollno);
				session.setAttribute("t",t);
				response.sendRedirect("sinfo.jsp");
			}
			
			else if(q==2){
				NonTechstud t=new NonTechstud();
				System.out.println("yoyo");
				t.getDetails(rollno);
				System.out.println("yo");
				System.out.println(t.getCompany());
				session.setAttribute("t",t);
				response.sendRedirect("nonSInfo.jsp");
			}
			else 
				response.sendRedirect("invalid.html");
		
		
		}
		if(val==1 & des.equals("tpo")){
			tpo t=new tpo();
			t.setTid(rollno);
			session.setAttribute("t", t);
			response.sendRedirect("tpo.jsp");
		}
		if(val==1 & des.equals("cell_members")){
			CellMember t=new CellMember();
			
			t.showDetails(rollno);
			
			session.setAttribute("t",t);
			
			response.sendRedirect("CellMemberInfo.jsp");
		}
		if(val==0)
			response.sendRedirect("invalid.html");
		//p.print(val);
	}
	

}

