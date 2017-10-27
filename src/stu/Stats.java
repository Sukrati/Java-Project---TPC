package stu;
import java.sql.*;
public class Stats {
	
 // it will display the placement statistics
    public double[] placementstats(){
        double n[]=new double[7];
        System.out.println("aaaaaa");
    try 
    {
    	System.out.println("asdfafs");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject", "tpc");
         String sql="select count(*) from Student where placementStatus=1";
         String sql1="select count(*) from Student";
         String sql2="select count(*) from Student where placementStatus=0";
         String sql3="select avg(salary) from Student where placementStatus=1";
         String sql4="select min(salary) from Student where placementStatus=1";
         String sql5="select max(salary) from Student where placementStatus=1";
         System.out.println("safcnjdsv");
         Statement stmt=con.createStatement();
         Statement stmt1=con.createStatement();
         Statement stmt2=con.createStatement();
         System.out.println("asdfasggas");
         Statement stmt3=con.createStatement();
         Statement stmt4=con.createStatement();
         Statement stmt5=con.createStatement();
         ResultSet res=stmt.executeQuery(sql1);
         ResultSet res1=stmt1.executeQuery(sql);
         ResultSet res2=stmt2.executeQuery(sql2);
         ResultSet res3=stmt3.executeQuery(sql3);
         ResultSet res4=stmt4.executeQuery(sql4);
         ResultSet res5=stmt5.executeQuery(sql5);
         System.out.println("aa");
         while(res.next()){
            n[0]=res.getDouble("count(*)");
            System.out.println(n[0]);
         }
         while(res1.next()){
                n[1]=res1.getDouble("count(*)");
             }
         while(res2.next()){
                n[2]=res2.getDouble("count(*)");
             }
         while(res3.next()){
                n[3]=res3.getDouble("avg(salary)");
             }
         while(res4.next()){
                n[4]=res4.getDouble("min(salary)");
             }
         while(res5.next()){
                n[5]=res5.getDouble("max(salary)");
             }
         n[6]=n[1]/n[0];
         return n;
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }
    System.out.println(n[0]);
    return n;
    }
    
}