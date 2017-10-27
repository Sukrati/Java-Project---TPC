<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
margin-left:150px;
}
.w{
margin-left:85px;
}
.e{
margin-left:75px;
}
.r{
margin-left:px;
}
</style>
</head>
<body>
<div class="s">
<form method="post" action="ChangePasswordServlet">
<h1>Change your Password</h1>
USER ID:<input type="text" placeholder="USER ID" name="userID" class="q">
<br><br>
OLD PASSWORD:<input type="password" placeholder="OLD PASSWORD" name="opass" class="w">
<br><br>
NEW PASSWORD :<input type="password" placeholder="NEW PASSWORD" name="npass" class="e">
<br><br>
CONFIRM NEW PASSWORD :<input type="password" placeholder="CONFIRM PASSWORD" name="cpass" class="r">
<br><br>
<input type="submit" value="Submit" style="background-color:#4CAF50" />
</form>
</div>
</body>
</html>