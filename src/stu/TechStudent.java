package stu;
import java.text.SimpleDateFormat;

import Company.TechCompany;

import java.sql.*;

public class TechStudent extends student{
	private String interest;
	private String branch;
	
    public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
// this method will display the details of all technical students
	public int getDetails(String id) {
		Connection con = null;
		int n=0;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false", "tpcProject",
					"tpc");

			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from Student");
			ResultSet rs1 = stmt1.executeQuery("select * from TechStudent");

			while (rs.next()) {
				System.out.println("hello");
				if (rs.getString("sid").equals(id)) {
					System.out.println("hello");
					setSid(rs.getString("sid"));
					setSname(rs.getString("sname"));
					setSpassword(rs.getString("spassword"));
					setsEmailId(rs.getString("semailId"));
					setCompany(rs.getString("placedCompany"));
					setCpi(rs.getDouble("cpi"));
					setSalary( rs.getDouble("salary"));
					setPlacementStatus(rs.getInt("placementStatus"));

				}	
				}
			while (rs1.next()) {
				if (rs1.getString("sid").equals(id))
					interest = rs1.getString("interest");
					branch = rs1.getString("branch");
			}
			n=1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			n=0;
		}
		return n;

	}
	
	// it will select companies which satisfy the student requirements 
	public TechCompany[] checkCompany(){
		Connection con=null;
		int count = 0;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
			
			Statement stmt=con.createStatement();
			Statement stmt1=con.createStatement();
			
			ResultSet rs1=stmt1.executeQuery("select count(*) from Company");
			while(rs1.next()){
			count=rs1.getInt("count(*)");
			}
			System.out.println("count ="+count);
			
			TechCompany t[]=new TechCompany[count];
			
			ResultSet rs = stmt.executeQuery("select * from Company c,TechCompany n where c.cIN=n.cIN and requirements='"+this.interest+
					"' and cpiCriteria<='"+this.getCpi()+"' and branch='"+ this.branch+"'");
			int i=0;
			
			try{
			while(rs.next()){
				t[i]=new TechCompany();
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
	
	//it will display all the companies visiting in between the specified dates 
	public TechCompany[] visitingDate(String d1,String d2)
	{
		Connection con=null;
		
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
			Statement stmt1=con.createStatement();
			
			ResultSet rs1=stmt1.executeQuery("select count(*) from Company");
			int count=rs1.getInt("count(*)");
			System.out.println("count ="+count);
			
			TechCompany t[]=new TechCompany[count];
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			try{
				java.util.Date date1 = sdf1.parse(d1);
				java.util.Date date2 = sdf1.parse(d2);
				java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());
				java.sql.Date sqlStartDate2 = new java.sql.Date(date2.getTime());
				Statement stmt= con.createStatement();
				String sql="select * from Company c,TechCompany t where c.cIN=t.cIN and visitDate>'"+sqlStartDate1+ "' and visitDate < '"+sqlStartDate2+ "' ";
				ResultSet res= stmt.executeQuery(sql);
				int i=0;
				while(res.next())
				{
					t[i]=new TechCompany();
					t[i].setName(res.getString("cname"));
					t[i].setVisitdate(res.getDate("visitDate"));
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
		catch(SQLException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

}
