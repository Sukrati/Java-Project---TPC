package stu;


import java.sql.*;

import Company.NonTechCompany;


public class NonTechstud extends student{
	private String interest;
		
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	//it will display the details of non technical students
	public int getDetails(String id){
		Connection con=null;
		int n=0;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
			
			Statement stmt=con.createStatement();
			Statement stmt2=con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from Student");
			ResultSet rs1 = stmt2.executeQuery("select * from NonTechStudent");

			while(rs.next()){
				if(rs.getString("sid").equals(id))
				{
					setSid(rs.getString("sid"));
					setSname(rs.getString("sname"));
					setSpassword(rs.getString("spassword"));
					setsEmailId(rs.getString("semailId"));
					setCompany(rs.getString("placedCompany"));
					setCpi(rs.getDouble("cpi"));
					setSalary(rs.getDouble("salary"));
					setPlacementStatus(rs.getInt("placementStatus"));
					
					
				}
			}
			while (rs1.next()) {
			if (rs1.getString("sid").equals(id))
				interest = rs1.getString("interest");
		}
			n=1;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			n=0;
		}
		return n;
		
	}
	
	
 //it will select the non technical companies which a student is eligible for
	public NonTechCompany[] checkCompany(){
		Connection con=null;
		int count=0;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
			
			Statement stmt=con.createStatement();
			Statement stmt1=con.createStatement();
			
			ResultSet rs1=stmt1.executeQuery("select count(*) from Company");
			//int count=rs1.getInt("count(*)");
			while(rs1.next()){
				count=rs1.getInt("count(*)");
				}
			System.out.println("count ="+count);
			
			NonTechCompany t[]=new NonTechCompany[count];
			
			ResultSet rs = stmt.executeQuery("select * from Company c,NonTechCompany n where c.cIN=n.cIN and requirements='"+this.interest+
					"' and cpiCriteria<='"+this.getCpi()+"'");
			int i=0;
			
			try{
			while(rs.next()){
				t[i]=new NonTechCompany();
				t[i].setId(rs.getInt("cIN"));
				t[i].setName(rs.getString("cname"));
				
				i++;
			}
			return t;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
}

