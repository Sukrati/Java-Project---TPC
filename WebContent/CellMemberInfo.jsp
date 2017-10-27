<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Cell_Member.CellMember" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

.s{
    border: 3px solid #808080;
    background-color: #f2f2f2;
    text-align:center;
    
    margin-left:100px;
    margin-right:100px;
    padding:20px;
}

.x{
    border: 3px solid #808080;
    background-color: #f4f4f4;
    text-align:center;
    margin-top:125px;
    margin-left:200px;
    margin-right:200px;
    padding: 20px;
}
.a{

width:300px;
height:50px;

}

</style>
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
<h1>STUDENT INFORMATION:</h1>
<div class="s">
<%
	//out.println(session.getAttribute("s"));
try{
	if(!session.getAttribute("t").equals("NULL")){
	CellMember c=(CellMember)session.getAttribute("t");
	out.println("ROLL NUMBER OF STUDENT : " +c.getId());
	out.println("</br>");
	out.println("</br>");
	out.println("NAME OF STUDENT : "+c.getName());
	out.println("</br>");
	out.println("</br>");
	out.println("EMAIL ID OF STUDENT : "+c.getEmailId());
	out.println("</br>");
	out.println("</br>");	
	out.println("CONTACT-NUMBER :"+c.getContactNumber());
	out.println("</br>");
	out.println("</br>");
	out.println("CATEGORY : "+c.getCategory());
	out.println("</br>");
	out.println("</br>");
	out.println("GENDER : "+c.getGender());
	out.println("</br>");
	out.println("</br>");
	out.println("YEAR : "+c.getBatch());
	
	//student s=new student();
		//	s.getdata("15ucs017");
	//		out.println(s.sid);
	}
	else{
		response.sendRedirect("form.jsp");
	}
}
catch(Exception e){
		
	
	
}
%>



</div>
<div class="x">
<form action="StudentStatsManager.jsp">
    <input type="submit" value="Edit Placement Status Of Student" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="CompanyVisit.jsp">
    <input type="submit" value="Companies visting" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="insertTechCompany.jsp">
    <input type="submit" value="Insert new Tech Company" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="nontechCompanyInsert.jsp">
    <input type="submit" value="Insert New Non Tech Company" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="editTechCompany.jsp">
    <input type="submit" value="Edit Exsting Tech Company" style="background-color:#4CAF50" class="a" />
</form>
<br><br>

<form action="editNonTechCompany.jsp">
    <input type="submit" value="Edit Existing Non Tech Company" style="background-color:#4CAF50" class="a" />
</form>
<br><br>

<form action="CellMemberDelete.html">
    <input type="submit" value="Delete Company" style="background-color:#4CAF50" class="a" />
</form>
<br><br>

<form action="placedCompanyName.jsp">
    <input type="submit" value="List Of Placed Student" style="background-color:#4CAF50" class="a" />
</form>
<br><br>

<form action="changePassword.jsp">
    <input type="submit" value="Change Existing Password" style="background-color:#4CAF50" class="a" />
</form>
<br><br>
<form action="logout.jsp">
	<input type="submit" value="Logout" style="background-color:#4CAF50" class="a" />
</form>
</div>
</body>
</html>