<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div align="center">
<h1 style="color: green;">  Welcome to EvryPay Bank  </h1>
<form action="CheckBalance" method="post">
<% 
Integer balance=0;
 balance=(Integer)request.getSession().getAttribute("customerBalance"); %>
<p>Check your Balance: <b><%= balance %></b></p>
<button type="submit">Check Balance</button>
</form><br>

<form action="AddMoney" method="post">
<p>How much Amount you want to Add :</p><input type="text" name="amount" />
<button type="submit">Add money</button>
</form><br>

<form action="SendMoney" method="post">
<p>Please Enter customer account Number:</p><input type="text" name="customerAccNum" />
<p>How much Amount you want to Transform :</p><input type="text" name="amountToTrans" />
<button type="submit">Transform money</button>
</form><br>

</div>
</body>
</html>