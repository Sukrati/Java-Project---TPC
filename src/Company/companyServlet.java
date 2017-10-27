package Company;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stu.*;
import stu.TechStudent.*;
import Company.TechCompany.*;
import Company.*;
/**
 * Servlet implementation class companyServlet
 */
@WebServlet("/companyServlet")
public class companyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public companyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String field=request.getParameter("field");
		if(field.equals("tech")){
			TechCompany c= new TechCompany();
			TechStudent t[]=new TechStudent[10];
			t=c.selectedTech(name);
			for(int i=0;i<10;i++){
				try{
					System.out.println(t[i].getSid()+"  "+t[i].getSname());
				}
				catch(Exception e){}
			}
		}
		
		if(field.equals("non-tech")){
			NonTechCompany c= new NonTechCompany();
			NonTechstud t[]=new NonTechstud[10];
			t=c.selectedTech(name);
			
			for(int i=0;i<10;i++){
				try{
					System.out.println(t[i].getSid()+"  "+t[i].getSname());
				}
				catch(Exception e){}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String field=request.getParameter("field");
		//System.out.println(sdate+edate+field);
		DateCheck q=new DateCheck();
		int z=q.dateCheck(sdate, edate);
		if(z==1){
		if(field.equals("tech")){
			
			
		TechCompany c= new TechCompany();
		TechCompany d[] = new TechCompany[10];
		d=c.CompanyVisit(sdate,edate);
		HttpSession session=request.getSession();
		session.setAttribute("d", d);
		response.sendRedirect("displayCompanies.jsp");
	}
		
		if(field.equals("non-tech")){
			NonTechCompany c= new NonTechCompany();
			NonTechCompany d[] = new NonTechCompany[10];
			d=c.CompanyVisit(sdate,edate);
			HttpSession session=request.getSession();
			session.setAttribute("d", d);
			response.sendRedirect("displayNonCompanies.jsp");
		}
		}
		else
			response.sendRedirect("invalidDate.html");
}
}
