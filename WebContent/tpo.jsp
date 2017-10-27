<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.s{
    border: 3px solid #808080;
    background-color: #f4f4f4;
    text-align:center;
    margin-top:25px;
    margin-left:200px;
    margin-right:200px;
    padding: 20px;
}
.a{

width:300px;
height:50px;

}
</style>
<title>tpo login</title>
</head>
<body>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("des")==null)
      response.sendRedirect("form.jsp");

  %> 
<div class="s">
<form action="sedit.jsp">
    <input type="submit" value="EDIT TECHNICAL STUDENT'S DETAILS" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="TechStuInsert.jsp">
	<input type="submit" value="INSERT NEW TECHNICAL STUDENT" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="NonTechStudentInsert.jsp">
	<input type="submit" value="INSERT NEW NON-TECHNICAL STUDENT" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="NonTechEdit.jsp">
	<input type="submit" value="EDIT NON-TECHNICAL STUDENT" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="insertCellMember.jsp">
	<input type="submit" value="INSRET CELL MEMBER" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="editCellMember.jsp">
	<input type="submit" value="EDIT CELL MEMBER" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="TpoDelete.jsp">
	<input type="submit" value="DELETE STUDENT/CELL MEMBER" style="background-color:#4CAF50" class="a" />
</form>

<br><br>
<form action="changePassword.jsp">
	<input type="submit" value="CHANGE YOUR PASSWORD" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="logout.jsp">
	<input type="submit" value="LOGOUT" style="background-color:#4CAF50" class="a" />
</form>
</div>
</body>
</html>