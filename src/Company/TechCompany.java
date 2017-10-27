package Company;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import stu.TechStudent;

public class TechCompany extends Company {
	private String req;
	private String branch;
	
	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	
	// this method displays the details of tech company visiting between specified dates
	 public TechCompany[] CompanyVisit(String d1,String d2)      
	 {
		 TechCompany t[]=new TechCompany[10];
		 

			try{
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject", "tpc");
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date1 = sdf1.parse(d1);
				java.util.Date date2 = sdf1.parse(d2);
				java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());
				java.sql.Date sqlStartDate2 = new java.sql.Date(date2.getTime());
				Statement stmt= con.createStatement();
				Statement stmt1= con.createStatement();
				String sql="select * from Company c,TechCompany t where visitDate>'"+sqlStartDate1+ "' and visitDate < '"+sqlStartDate2+ "' and t.cIN=c.cIN";
				ResultSet res= stmt.executeQuery(sql);
				int i=0;
				while(res.next())
				{
					t[i]=new TechCompany();
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
						t[i].branch=res1.getString("branch");
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
	
	 //this method select the students on the basis of criteria specified by given company
	 public TechStudent[] selectedTech(String company)
	 {
		 TechStudent t[]=new TechStudent[10];
		 TechCompany c=new TechCompany();
		 
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
			 String sql1="select * from TechCompany where cIN='"+c.getId()+ "'";
			 ResultSet res1=stmt1.executeQuery(sql1);
			 while(res1.next())
			 {
				 c.req=res1.getString("requirements");
				 c.branch=res1.getString("branch");
			 }
			 String sql2="select * from Student s, TechStudent t where t.sid=s.sid and s.cpi>='"+c.getCpi()+ "' and t.interest='"+c.req+ "' and t.branch='"+c.branch+ "'and s.placementStatus=0";
			 Statement stmt2=con.createStatement();
			 ResultSet res2=stmt2.executeQuery(sql2);
			 int i=0;
			 while(res2.next())
			 {
				 t[i]=new TechStudent();
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
