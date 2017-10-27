<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="stu.student"%>
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
    margin-left:100px;
    margin-right:100px;
    padding: 20px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div class="s">

<h1>List Of Placed Students:</h1>
<%
student d[] =(student[])session.getAttribute("std");
int count=1;

for(int i=0;i<10;i++){
	try{
		
		out.println("<b>"+count +"</b>"+" Id Of Student:"+d[i].getSid()+"  <br><br>   "+"Name of the Student:"+d[i].getSname()+"<br><br>");
		count=count+1;
	}
	catch(Exception e){
		
	}
}
if(count==1){
	out.println("NO Students Are placed with your Specified Company Name"+"<br>"+"<b>"+"<a href="+"placedCompanyName.jsp"+">Click here to try for other Companies</a>"+"</b>");
}
%>
</div>
</body>
</html>