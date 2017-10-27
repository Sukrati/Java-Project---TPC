<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="stu.Stats"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.s{
    border: 3px solid #808080;
    background-color: #f4f4f4;
    text-align:center;
    margin-top:125px;
    margin-left:200px;
    margin-right:200px;
    padding: 20px;
}
</style>

<title>Curret Year Placement Stats</title>
</head>
<body>
<div class="s">
<%
try{
double a[]=new double[7];
Stats S=new Stats();
a=S.placementstats();

    %>TOTAL STUDENTS :<%  out.println(a[0]+"<br><br>");
    %>PLACED STUDENTS :<%  out.println(a[1]+"<br><br>");
    %>UNPLACED STUDENTS :<%  out.println(a[2]+"<br><br>");
    %>AVERAGE PACKAGE :<%  out.println(a[3]+"<br><br>");
    %>MINIMUM PACKAGE :<%  out.println(a[4]+"<br><br>");
    %>MAXIMUM PACKAGE :<%  out.println(a[5]+"<br><br>");
    %>RATIO OF PLACED STUDENTS :<%  out.println(a[6]+"<br><br>");
}
catch(Exception e){
	
}
%>
</div>
</body>
</html>