package Company;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Cell_Member.CellMember;

/**
 * Servlet implementation class NonTechCompanyServlet
 */
@WebServlet("/NonTechCompanyServlet")
public class NonTechCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NonTechCompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int cIN=Integer.parseInt(request.getParameter("cIN"));
		String toEdit=request.getParameter("edit");
		String value=request.getParameter("value");
		//System.out.println(userid);
		CellMember c= new CellMember();
		if (toEdit.equals("visitDate"))
		{
			int y=Integer.parseInt(value.substring(0,4));
			int m=Integer.parseInt(value.substring(5,7));
			int d=Integer.parseInt(value.substring(8,10));
			DateCheck dt=new DateCheck();
			int k=dt.validDate(y,m,d);
			if(k==1){
				int n=c.editNonTechCompany(toEdit, cIN, value);
				if(n==1)
				{
					response.sendRedirect("updateSuccessful.html");
				}
				else if(n==0)
				{
					response.sendRedirect("unupdate.html");
				}}
			else	
			{
				response.sendRedirect("unupdate.html");
			}
			}
		else	{
			response.sendRedirect("unupdate.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String cname=request.getParameter("cname");
		String emailID=request.getParameter("cEmailID");
		String visitdate=request.getParameter("visitDate");
		String requirements=request.getParameter("requirements");
		String city=request.getParameter("city");
		double salary= Double.parseDouble(request.getParameter("salary"));
		int cIN=Integer.parseInt(request.getParameter("cIN"));
		double cpi= Double.parseDouble(request.getParameter("cpiCriteria"));
		CellMember c= new CellMember();
		int y=Integer.parseInt(visitdate.substring(0,4));
		int m=Integer.parseInt(visitdate.substring(5,7));
		int d=Integer.parseInt(visitdate.substring(8,10));
		DateCheck dt=new DateCheck();
		int k=dt.validDate(y,m,d);
		if(k==1){
		int n=c.insertNonTechCompany(cIN,cname,emailID,cpi,city,visitdate,salary,requirements);
		if(n==1)
		{
			response.sendRedirect("successful.html");
		}
		else if(n==0)
		{
			response.sendRedirect("unInsert.html");
		}}
		else if(k==0)
		{
			response.sendRedirect("unInsert.html");
		}
	}

}
