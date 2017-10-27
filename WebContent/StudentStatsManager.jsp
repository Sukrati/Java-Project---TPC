<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change placement Status</title>
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
.q{
	margin-left:50px;
}
</style>
</head>
<body>
<div class="s">
<h1> EDIT DETAILS </h1>
<form method="post" action="placementServlet">
	
	Company Name:  <input type ="text" placeholder="Company Nmae" name="cname">
	<br/><br/>
	
	Student Id:  <input type ="text" placeholder="Id" name="sid" class="q">
	<br/><br/>
	<input type="submit" value="submit" style="background-color:#4CAF50">
</form>
</div>
</body>
</html>