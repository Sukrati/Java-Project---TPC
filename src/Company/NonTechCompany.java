package Company;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import stu.NonTechstud;

public class NonTechCompany extends Company {                     

	private String req;
	
	public String getReq() {
		return req;
	}


	public void setReq(String req) {
		this.req = req;
	}

	//this method displays the details of non tech company visiting between specified dates
	 public NonTechCompany[] CompanyVisit(String d1,String d2)             
	 {
		 NonTechCompany t[]=new NonTechCompany[10];
		 try{
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc","tpcProject", "tpc");
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date1 = sdf1.parse(d1);
				java.util.Date date2 = sdf1.parse(d2);
				java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());
				java.sql.Date sqlStartDate2 = new java.sql.Date(date2.getTime());
				Statement stmt= con.createStatement();
				Statement stmt1= con.createStatement();
				String sql="select * from Company c, NonTechCompany t where visitDate>'"+sqlStartDate1+ "' and visitDate < '"+sqlStartDate2+ "' and t.cIN=c.cIN ";
				ResultSet res= stmt.executeQuery(sql);
				int i=0;
				while(res.next())
				{
					t[i]=new NonTechCompany();
					t[i].setName(res.getString("cname"));
					t[i].setVisitdate(res.getDate("visitDate"));
					t[i].setCpi(res.getDouble("cpiCriteria"));
					t[i].setId(res.getInt("cIN"));
					t[i].setSalary(res.getDouble("salary"));
					String sql1="select * from TechCompany where cIN='"+t[i].getId()+ "' ";
					ResultSet res1=stmt1.executeQuery(sql1);
					while(res1.next())
					{
						t[i].req=res1.getString("requirements");
					}
			    	i++;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		return t;
	 }
	
	//this method select the students who fulfill the criteria's specified by given company 
	 public NonTechstud[] selectedTech(String company)        
	 {
		 NonTechstud t[]=new NonTechstud[10];
		 NonTechCompany c=new NonTechCompany();
		 
		 try
		 {
			 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject", "tpc");
			 Statement stmt=con.createStatement();
			 Statement stmt1=con.createStatement();
			 String sql="select * from Company where cname='"+company+ "'";
			 ResultSet res=stmt.executeQuery(sql);
			 while(res.next())
			 {
				 c.setId(res.getInt("cIN"));
				 c.setName(res.getString("cname"));
				 c.setCpi(res.getDouble("cpiCriteria"));
			 }
			 String sql1="select * from NonTechCompany where cIN='"+c.getId()+ "'";
			 ResultSet res1=stmt1.executeQuery(sql1);
			 while(res1.next())
			 {
				 c.req=res1.getString("requirements");
				
			 }
			 String sql2="select * from Student s, NonTechStudent t where t.sid=s.sid and s.cpi>='"+c.getCpi()+ "' and t.interest='"+c.req+ "'and s.placementStatus=0";
			 Statement stmt2=con.createStatement();
			 ResultSet res2=stmt2.executeQuery(sql2);
			 int i=0;
			 while(res2.next())
			 {
				 t[i]=new NonTechstud();
				 t[i].setSid(res2.getString("sid"));
				 t[i].setSname(res2.getString("sname"));
				 i++;
			 }
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 
		 return t;
	 }

}
