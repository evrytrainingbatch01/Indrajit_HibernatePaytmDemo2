<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
<meta charset="ISO-8859-1">
<title>:: Login ::</title>
</head>
<body>
 </br> </br> </br>
 <h1>
  <div align="center">
   <% if(request.getAttribute("msg") != null) { %>
    <p style="color: red">
     <%= request.getAttribute("msg") %>
    </p>
   <% } %>
   <% if(request.getAttribute("msg2") != null) { %>
    <p style="color: green;">
     <%= request.getAttribute("msg2") %>
    </p>
   <% } %>

   <form action="login" method="POST">
    <label>Enter LoginId : </label> 
    <input type="text" name="loginId" required="required"> <br> <br> 
    <label>Enter Password : </label> 
    <input type="password" name="password" required="required"> <br> <br> 
    <input type="submit" value="Login">
   </form>
 </h1>
 </div>
</body>
</html>