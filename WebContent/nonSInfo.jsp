<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*" %>
    <%@ page import="stu.NonTechstud" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Non Tech Student</title>
<style type="text/css">

.s{
    border: 3px solid #808080;
    background-color: #f2f2f2;
    text-align:center;
    
    margin-left:100px;
    margin-right:100px;
    padding:20px;
}

.a{

width:300px;
height:50px;

}
</style>
</head>
<body>
<h1>STUDENT INFORMATION:</h1>
<div class="s">
<%
	//out.println(session.getAttribute("s"));
	NonTechstud stu =(NonTechstud)session.getAttribute("t");
	out.println("ROLL NUMBER OF STUDENT : " +stu.getSid());
	out.println("</br>");
	out.println("</br>");
	out.println("NAME OF STUDENT : "+stu.getSname());
	out.println("</br>");
	out.println("</br>");
	out.println("CPI OF STUDENT : "+stu.getCpi());
	out.println("</br>");
	out.println("</br>");
	out.println("EMAIL ID OF STUDENT : "+stu.getsEmailId());
	out.println("</br>");
	out.println("</br>");	
	out.println("PLACEMENT STATUS OF STUDENT :"+stu.getPlacementStatus());
	out.println("</br>");
	out.println("</br>");
	out.println("PLACED COMPANY : "+stu.getCompany());
	out.println("</br>");
	out.println("</br>");
	out.println("STUDENT SALARY : "+stu.getSalary());
	out.println("</br>");
	out.println("</br>");
	out.println("Interest : "+stu.getInterest());
	//student s=new student();
		//	s.getdata("15ucs017");
	//		out.println(s.sid);
%>
</div>
<br><br>
<br><br>
<br><br>
<div class="s">
<form action="changePassword.jsp">
    <input type="submit" value="Change Existing Password" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="CompanyVisit.jsp">
    <input type="submit" value="Companies Visiting" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form method="get" action="selectionServlet">
    <input type="submit" value="ELIGIBLE FOR COMPANIES" style="background-color:#4CAF50" class="a" />
</form>
</div>


</body>
</html>