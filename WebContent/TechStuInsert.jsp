<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tech Student Insert</title>
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

margin-left:50px;
}
.w{

margin-left:48px;
}
.e{
	margin-left:70px;
}
.r{

margin-left:25px;
}
.t{
margin-left:17px;
}
.y{

margin-left:25px;
}
</style>
</head>
<body>
<div class="s">
	<form method="post" action="tpoServlet">
		NAME:<input type ="text" placeholder="NAME" name="name" class="q">
		
		<br/><br>
		
		ROLL: <input type ="text" placeholder="Roll Number" name="rollno" class="w">
		<br><br>
		
		CPI:<input type ="text" placeholder="CPI" name="cpi" class="e">  
		<br><br>
		EMAIL-ID:<input type ="text" placeholder="EMAIL ID" name="emailID" class="r">
		<br><br>
		PASSWORD:<input type ="text" placeholder="Password" name="password">
		<br><br>
		INTEREST:<input type ="text" placeholder="Interest" name="interest" class="t">
		<br><br>
		BRANCH:<input type ="text" placeholder="Branch" name="branch" class="y">
		<br><br>		
		<input type="submit" value="submit" style="background-color:#4CAF50">
	</form>
</div>	
</body>
</html>