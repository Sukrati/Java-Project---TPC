package stu;

import java.sql.SQLException;
import java.sql.*;

public class student {
	private String sid;
	private String sname;
	private String spassword;
	private String sEmailId;
	private double cpi;
	private double salary;
	private String company;
	private int placementStatus;

	public String getSid() { // getters and setters
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public String getsEmailId() {
		return sEmailId;
	}

	public void setsEmailId(String sEmailId) {
		this.sEmailId = sEmailId;
	}

	public double getCpi() {
		return cpi;
	}

	public void setCpi(double cpi) {
		this.cpi = cpi;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPlacementStatus() {
		return placementStatus;
	}

	public void setPlacementStatus(int placementStatus) {
		this.placementStatus = placementStatus;
	}

	// it will check whether a student is a technical or non technical
	public int checkType(String id) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false",
					"tpcProject", "tpc");
			int temp = 4;
			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
			String sql = "select * from Student where sid='" + id + "'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("sid").equals(id)) {
					ResultSet rs1 = stmt1.executeQuery("select * from TechStudent where sid='" + id + "'");
					while (rs1.next()) {

						if (rs1.getString("sid").equals(id)) {
							temp = 1;
						}
					}
					ResultSet rs2 = stmt1.executeQuery("select * from NonTechStudent where sid='" + id + "'");
					while (rs2.next()) {

						if (rs2.getString("sid").equals(id)) {
							temp = 2;
						}
					}

				} else {
					temp = 0;
				}
			}
			return temp;

		}

		catch (SQLException e) {
			e.printStackTrace();
			return 0;

		}
	}

	// this method will change the password of student
	public int change(String id, String oldp, String newp) {
		int n = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc", "tpcProject", "tpc");
			Statement stmt = con.createStatement();
			ResultSet res;
			String pswd = null;
			String sql = "select * from Student where sid='" + id + "' ";
			res = stmt.executeQuery(sql);
			while (res.next()) {
				pswd = res.getString("spassword");
			}
			if (pswd.equals(oldp)) {
				Statement stmt1 = con.createStatement();
				String sql1 = "update Student set spassword='" + newp + "' where sid='" + id + "'";
				stmt1.executeUpdate(sql1);
				n = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
}
