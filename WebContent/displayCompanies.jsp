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
<title>Companies Visiting</title>
</head>
<body>

<div class="s">

<h1>Companies Visiting between Your Specified Dates are:-</h1>
<%
TechCompany d[] =(TechCompany[])session.getAttribute("d");
int count=1;

for(int i=0;i<10;i++){
	try{
		
		out.println("<b>"+count +"</b>"+" Name Of The Company:"+d[i].getName()+"  <br><br>   "+"Visiting Date Of The Company:"+d[i].getVisitdate()+"<br><br>");
		count=count+1;
	}
	catch(Exception e){
		
	}
}
if(count==1){
	out.println("no companies visiting between your entered dates "+"<br>"+"<b>"+"<a href="+"CompanyVisit.jsp"+">please try with some other dates</a>"+"</b>");
}
%>
</div>
</body>
</html>