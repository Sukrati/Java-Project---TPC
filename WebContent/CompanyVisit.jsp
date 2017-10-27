<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check Visiting Company</title>
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
</head>
<body>
<div class="s">
<h1>CHECK VISITING COMPANIES</h1>
<br>
<div>
<form method="post" action="companyServlet">
<h4>Enter the start date :</h4>

<input type ="text" placeholder="yyyy-mm-dd" name="sdate">


<h4>Enter the end date :</h4>

<input type ="text" placeholder="yyyy-mm-dd" name="edate">

<br><br>

Field:<select name="field">
	<option>tech</option>
	<option>non-tech</option>

</select>
<br/><br/>
<input type="submit" value="submit" style="background-color:#4CAF50">
</form>
</div>
</div>
</body>
</html>