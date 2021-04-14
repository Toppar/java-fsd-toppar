<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>User Edit</h2>


<form action="useredit" method="post">
  <label for="uid">User Id:</label><br>
  <input type="text" id="uid" name="uid" value="${user.id}"><br>
   <label for="email">Email:</label><br>
  <input type="text" id="email" name="email" value="${user.email}"><br>
  <label for="username">Name:</label><br>
  <input type="text" id="username" name="username" value="${user.name}"><br>
  <label for="password">Password:</label><br>
  <input type="text" id="password" name="password" value="${user.password}"><br>
  
  <br>
  <input type="submit" value="Submit">
</form> 


</body>
</html>