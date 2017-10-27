<html>
<head>

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
.q{

margin-left:30px;
}
.w{
margin-left:15px;

}
.e{
margin-left:45px;

}
</style>

</head>
<body>
<div class="s">
<h3 align="center"> LOGIN PAGE</h3>

<form method="post"  action="servletReady">

User ID:  <input type ="text" placeholder="User ID" name="rollno" class="q">
<br/><br/>
Password:<input type ="password" placeholder="password" name="password" class="w">
<br/><br/>
Designation:<select name="Designation" class="e">
	<option>tpo</option>
	<option>student</option>
	<option>cell_members</option>

</select>
<br/><br/>
<input type="submit" value="submit" style="background-color:#4CAF50">
<br><br>
<a href="stats.jsp">Click Here To Check The Statistics</a>
</form>
</div>

</body>

</html>