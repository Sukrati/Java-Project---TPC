<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Company.TechCompany" %>
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
<title>Eligible For The Companies</title>
</head>
<body>
<div class="s">
<h1>Companies you are/were Eligible for:-</h1>

<%
TechCompany q[]=(TechCompany[])session.getAttribute("q");
int count=1;
for(int i=0;i<10;i++){
	try{
		
		out.println( "<b>"+count+"</b>" +" CIN OF THE COMPANY: "+q[i].getId()+" <br><br> "+"Name of the Company: "+q[i].getName()+" <br><br>");
		count=count+1;
	}
	catch(Exception e){
		
	}
	
}
if(count==1){
	out.println("your credentials don't satisfy the placement criteria for any company "+"<br>"+"<b>"+"<a href="+"form.jsp"+">back to login</a>"+"</b>");
}
%>
</div>
</body>
</html>