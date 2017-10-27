package Tpo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import stu.*;



public class tpo {
	private String tid;
	
public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public static String designation="tpo";
	
	//this method is use to change password
	public int change(String id,String oldp,String newp ){
		int n=0;
		try
		{Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc","tpcProject", "tpc");
			Statement stmt=con.createStatement();
			ResultSet res;
			String pswd=null;
			String sql="select * from TPO where tname='"+id+ "' ";
			res=stmt.executeQuery(sql);
			while (res.next())
			{
				 pswd=res.getString("tpassword");
			}
			if(pswd.equals(oldp))
			{
				Statement stmt1=con.createStatement();
				String sql1="update TPO set tpassword='"+newp+ "' where tname='"+id+ "'";
				stmt1.executeUpdate(sql1);
				n=1;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			n=0;
		}
		return n;
	}
	
	//sets the details of technical student
	public TechStudent showTechStud(String id){
			TechStudent s=new TechStudent();
			s.getDetails(id);
			return s;
	}
	
	//sets the details of non technical student
	public NonTechstud showNonTechStud(String id){
		NonTechstud s=new NonTechstud();
		s.getDetails(id);
		return s;
	}
	
	//this method inserts the technical student 
	public int insertTechStud(String sid,String sname,String password,String email,double cpi,
			int status,String company,double salary,String branch,String interest){
		
		Connection con=null;
		int n=0;
			try
			{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
				
				String a="insert into Student(sid,sname,spassword,sEmailId,cpi,placementStatus,placedCompany,salary) "
						+ "values(?,?,?,?,?,?,?,?)";
				
				PreparedStatement preparedStmt = con.prepareStatement(a);
				  preparedStmt.setString (1,sid);
				  preparedStmt.setString (2,sname);
				  preparedStmt.setString (3, password);
				  preparedStmt.setString (4,email);
				  preparedStmt.setDouble(5, cpi);
				  preparedStmt.setInt(6, status);
				  preparedStmt.setString (7,company);
				  preparedStmt.setDouble (8,salary);
				  
				  String b="insert into TechStudent values(?,?,?)";
				  PreparedStatement stmt2 = con.prepareStatement(b);
				  stmt2.setString(1,sid);
				  stmt2.setString(2, interest);
				  stmt2.setString(3,branch);
				  
				  preparedStmt.execute();
				  stmt2.execute();
				  n=1;
				
			}
			catch(SQLException e){
				e.printStackTrace();
				n=0;
			}
			return n;
	}

//edit the technical student
	public int editTechStudent(String field,String id,String attribute)
	{
		System.out.println(field+id+attribute);
		Connection con=null;
		int n=0;
			try
			{
				String sql;
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
				PreparedStatement ps;
				Statement stm=con.createStatement();
				String s="select * from Student s,TechStudent t where s.sid='"+id+ "'and s.sid=t.sid";
				ResultSet rs=stm.executeQuery(s);
				while(rs.next()){
				if(field.equals("sname")){
					sql="UPDATE Student set sname= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("spassword")){
					sql="UPDATE Student set spassword= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("salary")){
					sql="UPDATE Student set salary= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("sEmailId")){
					sql="UPDATE Student set sEmailId= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("cpi")){
					sql="UPDATE Student set cpi= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("status")){
					sql="UPDATE Student set placementStatus= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("placedCompany")){
					sql="UPDATE Student set placedCompany= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("interest")){
					System.out.println("yoyo");
					sql="UPDATE TechStudent set interest= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("branch")){
					sql="UPDATE TechStudent set branch= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
			}}
			catch(SQLException e)
			{
				e.printStackTrace();
				n=0;
			}
			return n;
	}
	
	//insert non technical student
	public int insertNonTechStud(String sid,String sname,String password,String email,double cpi,
			int status,String company,double salary,String interest){
		
		Connection con=null;
		int n=0;
			try
			{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
				
				String a="insert into Student(sid,sname,spassword,sEmailId,cpi,placementStatus,placedCompany,salary) "
						+ "values(?,?,?,?,?,?,?,?)";
				
				PreparedStatement preparedStmt = con.prepareStatement(a);
				  preparedStmt.setString (1,sid);
				  preparedStmt.setString (2,sname);
				  preparedStmt.setString (3, password);
				  preparedStmt.setString (4,email);
				  preparedStmt.setDouble(5, cpi);
				  preparedStmt.setInt(6, status);
				  preparedStmt.setString (7,company);
				  preparedStmt.setDouble (8,salary);
				  
				  String b="insert into NonTechStudent values(?,?)";
				  PreparedStatement stmt2 = con.prepareStatement(b);
				  stmt2.setString(1,sid);
				  stmt2.setString(2, interest);
				  
				  preparedStmt.execute();
				  stmt2.execute();
				  n=1;
				
			}
			catch(SQLException e){
				e.printStackTrace();
				n=0;
			}
			return n;
	}


//edit non technical student
public int editNonTechStudent(String field,String id,String attribute)
{
	System.out.println(field+id+attribute);
	Connection con=null;
	int n=0;
		try
		{
			String sql;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
			PreparedStatement ps;
			Statement stm=con.createStatement();
			String s="select * from Student s,NonTechStudent t where s.sid='"+id+ "'and s.sid=t.sid";
			ResultSet rs=stm.executeQuery(s);
			while(rs.next()){ 
			if(field.equals("sname")){
				sql="UPDATE Student set sname= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
				n=1;
			}
			if(field.equals("spassword")){
				System.out.println("hello");
				sql="UPDATE Student set spassword= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
				n=1;
			}
			if(field.equals("salary")){
				sql="UPDATE Student set salary= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
				n=1;
			}
			if(field.equals("sEmailId")){
				sql="UPDATE Student set sEmailId= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
				n=1;
			}
			if(field.equals("cpi")){
				sql="UPDATE Student set cpi= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
				n=1;
			}
			if(field.equals("placementStatus")){
				sql="UPDATE Student set placementStatus= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
				n=1;
			}
			if(field.equals("placedCompany")){
				sql="UPDATE Student set placedCompany= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
				n=1;
			}
			if(field.equals("interest")){
				System.out.println("yoyo");
				sql="UPDATE NonTechStudent set interest= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
				n=1;
			}
		}}
		catch(SQLException e)
		{
			e.printStackTrace();
			n=0;
		}
		System.out.println(n);
		return n;
	
}



//edit cell members
public int editCellMember(String field,String id,String attribute){
	Connection con=null;
	int n=0;
	try
	{
		String sql;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
		PreparedStatement ps;
		Statement stm=con.createStatement();
		String s="select * from CellMember c where c.cid='"+id+ "'";
		ResultSet rs=stm.executeQuery(s);
		while(rs.next()){
		if(field.equals("cname")){
			//System.out.println("i m sukki");
			sql="UPDATE CellMember set cname= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
			n=1;
		}
		if(field.equals("cpassword")){
			sql="UPDATE CellMember set cpassword= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
			n=1;
		}
		if(field.equals("ContactNumber")){
			sql="UPDATE CellMember set ContactNumber= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
			n=1;
		}
		if(field.equals("cEmailId")){
			sql="UPDATE CellMember set cEmailId= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
			n=1;
		}
		if(field.equals("year")){
			sql="UPDATE CellMember set year= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
			n=1;
		}
		if(field.equals("gender")){
			sql="UPDATE CellMember set gender= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
			n=1;
		}
		if(field.equals("category")){
			sql="UPDATE CellMember set category= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
			n=1;
		}
	}}
	catch(SQLException e)
	{
		System.out.println("exception");
		n=0;
	}
	return n;

}

//insert cell members
public int insertCellMember(String cid,String cname,String password,String email,String contact,
		String year,String gender,String category){
	
	Connection con=null;
	int n=0;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
			
			String a="insert into CellMember values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(a);
			  preparedStmt.setString(1,cid);
			  preparedStmt.setString (2,cname);
			  preparedStmt.setString (3, password);
			  preparedStmt.setString (4,email);
			  preparedStmt.setString(5, contact);
			  preparedStmt.setString(6,year);
			  preparedStmt.setString(7,gender);
			  preparedStmt.setString(8,category);
			  preparedStmt.execute();
			  n=1;
		}
		catch(SQLException e){
			e.printStackTrace();
			n=0;
		}
		System.out.println(n);
		return n;
}

// delete students from database
 public int deleteStud(String sid)
	 {
		 int n=0;
		 
		 try {
			 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc","tpcProject","tpc");
			 Statement stmt=con.createStatement();
			 Statement stmt1=con.createStatement();
			 Statement stmt2=con.createStatement();
			 Statement s=con.createStatement();
			 String ss="select * from Student where sid='"+sid+ "'";
			 //System.out.println(ss);
			 ResultSet res=s.executeQuery(ss);
			 while(res.next()){
				 //System.out.println("hello");
			 String sql1="delete from TechStudent where sid='"+sid+ "'";
			 String sql2="delete from NonTechStudent where sid='"+sid+ "'";
			 String sql="delete from Student where sid='"+sid+ "' ";
			 stmt1.executeUpdate(sql1);
			 stmt2.executeUpdate(sql2);
//			 ResultSet res=stmt.executeQuery(sql);
//			 ResultSet res1=stmt.executeQuery(sql1);
//			 ResultSet res2=stmt.executeQuery(sql2);
			 stmt.executeUpdate(sql);
			 n=1;
			 }
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
			 n=0;
		 }
		 return n;
	 }
 
 
 //delete cell members from database
 public int deleteCellMember(String cid)
	 {
		 int n=0;
		 
		 try {
			 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc","tpcProject","tpc");
			 Statement stmt=con.createStatement();
			 Statement s=con.createStatement();
			 String ss="select * from CellMember where cid='"+cid+ "'";
			 ResultSet res=s.executeQuery(ss);
			 while(res.next()){
			 String sql="delete from CellMember where cid='"+cid+ "' ";
			 stmt.executeUpdate(sql);
			 n=1;
		 }}
		 catch(SQLException e)
		 {
			 e.printStackTrace();
			 n=0;
		 }
		 return n;
	 }


}

