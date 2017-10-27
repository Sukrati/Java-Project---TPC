<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.s{
    border: 3px solid #808080;
    background-color: #f4f4f4;
    text-align:center;
    margin-top:125px;
    margin-left:200px;
    margin-right:200px;
    padding:20px;
}
</style>
<title>Company Name</title>
</head>
<body>
<div class="s">
<h1>ENTER THE COMPANY NAME:</h1>
<br>
<form method="post" action="placedStudentServlet">

<input type ="text" placeholder="Company Name" name="cname">

<br><br>

<input type="submit" value="submit" style="background-color:#4CAF50">
</form>
</div>
</body>
</html>