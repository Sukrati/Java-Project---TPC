package stu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Company.NonTechCompany;
import Company.TechCompany;

/**
 * Servlet implementation class selectionServlet
 */
@WebServlet("/selectionServlet")
public class selectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		NonTechstud stu =(NonTechstud)session.getAttribute("t");
		NonTechCompany t[]=stu.checkCompany();
		session.setAttribute("q",t);
		response.sendRedirect("selectionNonTech.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		TechStudent stu =(TechStudent)session.getAttribute("t");
		TechCompany t[]=stu.checkCompany();
		session.setAttribute("q",t);
		response.sendRedirect("selection.jsp");
	}

}
