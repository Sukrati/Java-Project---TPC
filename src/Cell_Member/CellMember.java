package Cell_Member;

import java.util.Date;

import stu.student;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CellMember {
	private String id;
	private String name;
	private String password;
	private String EmailId;
	private String ContactNumber;
	private String category;
	private String gender;
	private String year;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.ContactNumber = contactNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBatch() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
//To show the details of cellMember using their id
	public int showDetails(String c1id) {
		int n = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc", "tpcProject", "tpc");

			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from CellMember");
			while (res.next()) {
				if (res.getString("cid").equals(c1id)) {
					id = res.getString("cid");
					name = res.getString("cname");
					password = res.getString("cpassword");
					EmailId = res.getString("cEmailId");
					ContactNumber = res.getString("ContactNumber");
					category = res.getString("category");
					gender = res.getString("gender");
					year = res.getString("year");
					n = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			n = 0;
		}
		return n;
	}
//Change status of Student if they get placed:set placement status=1 and set placementCompany and salary
	public int changeStatus(String company, String sid) {
		int n = 0;
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false", "tpcProject", "tpc");
			Statement stmt = con.createStatement();

			int cid;
			double slry = 0;

			String s1 = "select * from Student s,TechStudent t where s.sid=t.sid and s.sid='" + sid + "'";
			Statement stm1 = con.createStatement();
			ResultSet rs1 = stm1.executeQuery(s1);
			while (rs1.next()) {
				String sql = "select * from Company c,TechCompany t where c.cname='" + company + "'and t.cIN=c.cIN";
				ResultSet res = stmt.executeQuery(sql);
				while (res.next()) {
					cid = res.getInt("cIN");
					slry = res.getDouble("salary");
					Statement stmt1 = con.createStatement();
					Statement stmt2 = con.createStatement();
					Statement stmt3 = con.createStatement();
					String sql1 = "update Student set placementStatus=1 where sid='" + sid + "'";
					stmt1.executeUpdate(sql1);
					String sql2 = "update Student set salary='" + slry + "' where sid='" + sid + "'";
					stmt2.executeUpdate(sql2);
					String sql3 = "update Student set placedCompany='" + company + "' where sid='" + sid + "'";
					stmt3.executeUpdate(sql3);
					n = 1;
				}
			}

			String s2 = "select * from Student s,NonTechStudent t where s.sid=t.sid and s.sid='" + sid + "'";
			Statement stm2 = con.createStatement();
			ResultSet rs2 = stm2.executeQuery(s2);
			Statement stm12 = con.createStatement();
			while (rs2.next()) {
				String sql12 = "select * from Company c,NonTechCompany t where c.cname='" + company
						+ "'and t.cIN=c.cIN";
				ResultSet res4 = stm12.executeQuery(sql12);
				while (res4.next()) {
					cid = res4.getInt("cIN");
					slry = res4.getDouble("salary");
					Statement stmt1 = con.createStatement();
					Statement stmt2 = con.createStatement();
					Statement stmt3 = con.createStatement();
					String sql1 = "update Student set placementStatus=1 where sid='" + sid + "'";
					stmt1.executeUpdate(sql1);
					String sql2 = "update Student set salary='" + slry + "' where sid='" + sid + "'";
					stmt2.executeUpdate(sql2);
					String sql3 = "update Student set placedCompany='" + company + "' where sid='" + sid + "'";
					stmt3.executeUpdate(sql3);
					n = 1;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			n = 0;
		}
		return n;
	}
//To insert a new technical company and setting all their attributes
	public int insertTechCompany(int cIN, String cname, String cemailId, double cpi, String city, String visitdate,
			double salary, String requirements, String branch) {
		Connection con = null;
		int n = 0;
		System.out.println("id is =" + this.id);
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false",
					"tpcProject", "tpc");

			String a = "insert into Company values(?,?,?,?,?,?,?)";

			PreparedStatement preparedStmt = con.prepareStatement(a);
			preparedStmt.setInt(1, cIN);
			preparedStmt.setString(2, cname);
			preparedStmt.setString(3, cemailId);
			preparedStmt.setDouble(4, cpi);
			preparedStmt.setString(5, city);
			preparedStmt.setString(6, visitdate);
			preparedStmt.setDouble(7, salary);

			String b = "insert into TechCompany values(?,?,?)";
			PreparedStatement stmt2 = con.prepareStatement(b);
			stmt2.setInt(1, cIN);
			stmt2.setString(2, branch);
			stmt2.setString(3, requirements);
			preparedStmt.execute();
			stmt2.execute();
			n = 1;

		} catch (SQLException e) {
			n = 0;
			System.out.println("hello");
			e.printStackTrace();
			n = 0;
		}
		System.out.println(n);
		return n;
	}
	
//To edit any attribute of existing company
	public int editTechCompany(String field, int cIN, String attribute) {
		int n = 0;
		int count = 0;
		Connection con = null;
		try {
			String sql;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false",
					"tpcProject", "tpc");
			PreparedStatement ps;
			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery("select count(*) from Company where cIN='" + cIN + "'");
			// int count=rs1.getInt("count(*)");
			while (rs1.next()) {
				count = rs1.getInt("count(*)");
			}
			if (count > 0) {

				if (field.equals("cname")) {
					sql = "UPDATE Company c,TechCompany t set c.cname= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);
					ps.setString(1, attribute);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("cpiCriteria")) {
					sql = "UPDATE Company c,TechCompany t set c.cpiCriteria= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);
					double cpi = Double.parseDouble(attribute);
					System.out.println("hello cpi");
					ps.setDouble(1, cpi);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("salary")) {
					sql = "UPDATE Company c,TechCompany t set c.salary= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);
					double salary = Double.parseDouble(attribute);
					ps.setDouble(1, salary);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("cEmailId")) {
					sql = "UPDATE Company c, TechCompany t set c.cEmailId= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);
					ps.setString(1, attribute);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("city")) {
					sql = "UPDATE Company c,TechCompany t set c.city= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);
					ps.setString(1, attribute);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("visitDate")) {
					sql = "UPDATE Company c,TechCompany t set c.visitDate= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date1;
					try {
						date1 = sdf1.parse(attribute);
						java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());
						ps.setDate(1, sqlStartDate1);
						ps.setInt(2, cIN);
						ps.executeUpdate();
						n = 1;
					} catch (ParseException e) {
						e.printStackTrace();
						n = 0;
					}

				}
				if (field.equals("requirements")) {
					sql = "UPDATE TechCompany set requirements= ? where cIN=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, attribute);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("branch")) {
					sql = "UPDATE TechCompany set branch= ? where cIN=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, attribute);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			n = 0;
		}
		return n;
	}
	
// this method add new non technical company to our database.
	public int insertNonTechCompany(int cIN, String cname, String cemailId, double cpi, String city, String visitdate,
			double salary, String requirements) {
		Connection con = null;
		int n = 0;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false",
					"tpcProject", "tpc");

			String a = "insert into Company values(?,?,?,?,?,?,?)";

			PreparedStatement preparedStmt = con.prepareStatement(a);
			preparedStmt.setInt(1, cIN);
			preparedStmt.setString(2, cname);
			preparedStmt.setString(3, cemailId);
			preparedStmt.setDouble(4, cpi);
			preparedStmt.setString(5, city);
			preparedStmt.setString(6, visitdate);
			preparedStmt.setDouble(7, salary);

			String b = "insert into NonTechCompany values(?,?)";
			PreparedStatement stmt2 = con.prepareStatement(b);
			stmt2.setInt(1, cIN);
			stmt2.setString(2, requirements);
			preparedStmt.execute();
			stmt2.execute();
			n = 1;

		} catch (SQLException e) {
			e.printStackTrace();
			n = 0;
		}
		return n;
	}

	//this method edit the attributes of existing non technical company
	public int editNonTechCompany(String field, int cIN, String attribute) {
		System.out.println(field + id + attribute);
		Connection con = null;
		int n = 0;
		int count = 0;
		try {
			String sql;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false",
					"tpcProject", "tpc");
			PreparedStatement ps;
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery("select count(*) from Company where cIN='" + cIN + "'");
			// int count=rs1.getInt("count(*)");
			while (rs1.next()) {
				count = rs1.getInt("count(*)");
			}
			if (count > 0) {
				if (field.equals("cname")) {
					sql = "UPDATE Company c, NonTechCompany t set c.cname= ? where c.cIN=? and t.cIN=c.cIN";
					ps = con.prepareStatement(sql);
					ps.setString(1, attribute);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("cpiCriteria")) {
					sql = "UPDATE Company c, NonTechCompany t set c.cpiCriteria= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);
					double cpi = Double.parseDouble(attribute);
					ps.setDouble(1, cpi);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("salary")) {
					sql = "UPDATE Company c, NonTechCompany t set c.salary= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);

					double salary = Double.parseDouble(attribute);
					ps.setDouble(1, salary);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("cEmailId")) {
					sql = "UPDATE Company c, NonTechCompany t set c.cEmailId= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);
					ps.setString(1, attribute);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("city")) {
					sql = "UPDATE Company c, NonTechCompany t set c.city= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);
					ps.setString(1, attribute);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
				if (field.equals("visitDate")) {
					System.out.println("123");
					sql = "UPDATE Company c, NonTechCompany t set c.visitDate= ? where c.cIN=? and c.cIN=t.cIN";
					ps = con.prepareStatement(sql);
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date1;
					try {
						date1 = sdf1.parse(attribute);
						java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());
						ps.setDate(1, sqlStartDate1);
						ps.setInt(2, cIN);
						ps.executeUpdate();
						n = 1;
					} catch (ParseException e) {
						e.printStackTrace();
						n = 0;
					}
				}
				if (field.equals("requirements")) {
					sql = "UPDATE NonTechCompany set requirements= ? where cIN=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, attribute);
					ps.setInt(2, cIN);
					ps.executeUpdate();
					n = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			n = 0;
		}
		System.out.println(n);
		return n;
	}

	//this method provides cell members an option to change their password.
	public int change(String id, String oldp, String newp) {
		int n = 0;
		System.out.println(this.id);
		if (this.id.equals(id)) {
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc", "tpcProject", "tpc");
				Statement stmt = con.createStatement();
				ResultSet res;
				String pswd = null;
				String sql = "select * from CellMember where cid='" + id + "' ";
				res = stmt.executeQuery(sql);
				while (res.next()) {
					pswd = res.getString("cpassword");
				}
				if (pswd.equals(oldp)) {
					Statement stmt1 = con.createStatement();
					String sql1 = "update CellMember set cpassword='" + newp + "' where cid='" + id + "'";
					stmt1.executeUpdate(sql1);
					n = 1;
				}
			}

			catch (SQLException e) {
				n = 0;
				e.printStackTrace();
			}
		} else
			n = 0;
		System.out.println(n);
		return n;
	}

	//it will display the stats of students who are placed in given company
	public student[] placedStud(String comName) {
		{
			student c[] = new student[20];
			try {
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false", "tpcProject", "tpc");
				Statement stmt = con.createStatement();
				String sql = "select * from Student where placedCompany='" + comName + "'";
				ResultSet res = stmt.executeQuery(sql);
				int i = 0;
				while (res.next()) {
					c[i] = new student();
					c[i].setSid(res.getString("sid"));
					c[i].setSname(res.getString("sname"));
					i++;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return c;
		}
	}

	public int deleteCompany(String cname) {
		int n = 0;
		int cIN = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc", "tpcProject", "tpc");
			Statement sm = con.createStatement();
			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
			Statement stmt2 = con.createStatement();
			String s = "select * from Company where cname='" + cname + "' ";
			ResultSet res = sm.executeQuery(s);
			while (res.next()) {
				cIN = res.getInt("cIN");
				String sql = "delete from Company where cIN='" + cIN + "' ";
				String sql1 = "delete from TechCompany where cIN='" + cIN + "'";
				String sql2 = "delete from NonTechCompany where cIN='" + cIN + "'";
				stmt1.executeUpdate(sql1);
				stmt2.executeUpdate(sql2);
				stmt.executeUpdate(sql);

				n = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			n = 0;
		}
		return n;
	}

}
