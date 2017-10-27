<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Non Tech Student</title>
<style type="text/css">
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

margin-left:18px;
}
.e{

margin-left:78px;
}
</style>
</head>
<body>
<div class="s">
<h1> EDIT DETAILS </h1>
<form method="get" action="tpoServletNonTech">
	
	ROLL NUMBER:  <input type ="text" placeholder="ROLL NUMBER" name="rollno" class="q">
	<br/><br/>
	WHAT YOU WAN'T TO EDIT : <select name="edit">
		<option>sname</option>
		<option>spassword</option>
		<option>cpi</option>
		<option>sEmailId</option>
		<option>interest</option>
	</select>
	<br/><br/>
	
	VALUE:  <input type ="text" placeholder="VALUE" name="value" class="e">
	<br/><br/>
	<input type="submit" value="submit" style="background-color:#4CAF50">
</form>
</div>
</body>
</html>