
import java.sql.*;

import Tpo.tpo;

public class vald {

	// this method check validation whether the user exists in database or not
	public int validate(String rollno, String pass, String des) {
		System.out.println(rollno + pass + des);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false", "tpcProject", "tpc");

			Statement stmt = con.createStatement();
			if (des.equals("student")) {
				ResultSet rs = stmt.executeQuery("select * from Student");

				while (rs.next()) {
					System.out.println("hello all" + rs.getInt("sid") + rs.getString("spassword"));
					if (rs.getString("sid").equals(rollno) & rs.getString("spassword").equals(pass)) {
						System.out.println("in here");
						return 1;
					}
				}
			}

			else if (des.equals("tpo")) {
				ResultSet rs = stmt.executeQuery("select * from TPO");
				while (rs.next()) {
					if (rs.getString("tname").equals(rollno) & rs.getString("tpassword").equals(pass)) {
						System.out.println("in here");
						return 1;
					}
				}

			}

			else if (des.equals("cell_members")) {
				System.out.println("cell");
				ResultSet rs = stmt.executeQuery("Select * from CellMember");
				while (rs.next()) {
					if (rs.getString("cid").equals(rollno) & rs.getString("cpassword").equals(pass)) {
						System.out.println("in here");
						return 1;
					}
				}
			}

			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

}
