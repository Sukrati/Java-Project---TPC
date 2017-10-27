<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Non Tech Company</title>
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
</head>
<body>
<div class="s">
<h1> EDIT DETAILS </h1>
<form method="get" action="NonTechCompanyServlet">
	
	CIN:  <input type ="text" placeholder="CIN" name="cIN">
	<br/><br/>
	Select What You Wan't to edit:<select name="edit">
		<option>cname</option>
		<option>cpiCriteria</option>
		<option>city</option>
		<option>visitDate</option>
		<option>salary</option>
		<option>cEmailId</option>
		<option>requirements</option>
	</select>
	<br/><br/>
	
	VALUE:  <input type ="text" placeholder="VALUE" name="value">
	<br/><br/>
	<input type="submit" value="submit" style="background-color:#4CAF50">
</form>
</div>
</body>
</html>