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
<h2>User Query</h2>


<form action="userquery" method="post">
  <label for="uid">User Id:</label><br>
  <input type="text" id="uid" name="uid"><br><br>
  <input type="submit" value="Submit">
</form> 


</body>
</html>