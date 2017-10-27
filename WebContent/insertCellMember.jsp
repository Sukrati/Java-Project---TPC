<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Cell Member</title>
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
.q{
	margin-left:105px;
}
.w{
	margin-left:80px;
}
.e{
	
	margin-left:75px;
}
.r{
	margin-left:60px;
}
.y{

	margin-left:60px;
}
.u{

	margin-left:85px;
}
.i{

	margin-left:110px;
}
</style>
</head>
<body>
<div class="s">
	<form method="post" action="CellMemberServlet">
		NAME:<input type ="text" placeholder="NAME" name="name" class="q">
		
		<br/><br>
		
		USER ID: <input type ="text" placeholder="User ID" name="userID" class="w">
		<br><br>

		EMAIL-ID:<input type ="text" placeholder="EMAIL ID" name="emailID" class="e">
		<br><br>
		CATEGORY: <input type ="text" placeholder="CATEGORY" name="category" class="r">
		<br><br>
		CONTACT-NUMBER: <input type ="text" placeholder="CONTACT NUMBER" name="contact class="">
		<br><br>
		PASSWORD:<input type ="text" placeholder="PASSWORD" name="password" class="y">
		<br><br>
		GENDER:<input type ="text" placeholder="GENDER" name="gender" class="u">
		<br><br>
		YEAR:<input type ="text" placeholder="YEAR" name="year" class="i">
		<br><br>		
		<input type="submit" value="submit" style="background-color:#4CAF50">
	</form>
</div>	
</body>
</html>



