<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Technical Company</title>
<style>
.s{
    border: 3px solid #808080;
    background-color: #f4f4f4;
    text-align:center;
    margin-top:75px;
    margin-left:200px;
    margin-right:200px;
    padding: 20px;
}
</style>
</head>
<body>
<div class="s">
	<form method="post" action="TechCompanyServlet">
		NAME:<input type ="text" placeholder="COMPANY NAME" name="cname">
		
		<br/><br>
		
		CIN: <input type ="text" placeholder="CIN" name="cIN">
		<br><br>

		EMAIL-ID:<input type ="text" placeholder="EMAIL ID" name="cEmailID">
		<br><br>
		REQUIRED CPI: <input type ="text" placeholder="CPI" name="cpiCriteria">
		<br><br>
		CITY: <input type ="text" placeholder="COMPANY CENTER" name="city">
		<br><br>
		VISITING DATE:<input type ="text" placeholder="VISITING DATE" name="visitDate">
		<br><br>
		SALARY:<input type ="text" placeholder="SALARY" name="salary">
		<br><br>
		BRANCH:<input type ="text" placeholder="BRANCH" name="branch">
		<br><br>
		REQUIREMENTS:<input type ="text" placeholder="REQUIREMENTS" name="requirements">
		<br><br>		
		<input type="submit" value="submit" style="background-color:#4CAF50">
	</form>
</div>	
</body>
</html>