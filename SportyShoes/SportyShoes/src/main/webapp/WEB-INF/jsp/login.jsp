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
<h2>Login</h2>

<p>${message}</p>

<form action="login" method="post">
  <label for="username">UserName:</label><br>
  <input type="text" id="username" name="username"><br>
  <label for="password">Password:</label><br>
  <input type="password" id="password" name="password"><br>
  <br>
  <input type="submit" value="Submit">
</form> 


</body>
</html>