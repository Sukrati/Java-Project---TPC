package Tpo;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tpoServletNonTech
 */
@WebServlet("/tpoServletNonTech")
public class tpoServletNonTech extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tpoServletNonTech() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String rollno=request.getParameter("rollno");
		String toEdit=request.getParameter("edit");
		String value=request.getParameter("value");
		System.out.println(rollno);
		tpo t=new tpo();
		int n=t.editNonTechStudent(toEdit, rollno, value);
		if(n==1)
			response.sendRedirect("updateSuccessful.html");
		else
			response.sendRedirect("unupdate.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String rollno=request.getParameter("rollno");
		String name=request.getParameter("name");
		String emailID=request.getParameter("emailID");
		String password=request.getParameter("password");
		String interest=request.getParameter("interest");
		double cpi= Double.parseDouble(request.getParameter("cpi"));
		//System.out.println(rollno+name);
		tpo t=new tpo();
		int n=t.insertNonTechStud(rollno,name,password,emailID,cpi,
				0,"NULL",0,interest);
		if(n==1)
		response.sendRedirect("successful.html");
		else 
			response.sendRedirect("unInsert.html");
	}

}
