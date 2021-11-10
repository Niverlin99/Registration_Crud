<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<div class="container">
 <h1>CompTran</h1>
  <p class="font-weight-light">Training Makes Prefect Target.</p>
  <h2>Teacher Login</h2>
<form action="/action_page.php" method="post">
  <div class="form-group">
    <label for="email">Staff Id:</label>
    <input type="text" name="emp_id" class="form-control" placeholder="Enter Employee Id" id="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" name="passcode" class="form-control" placeholder="Enter password" id="pwd">
  </div>
 
  <button type="submit" class="btn btn-primary">Login</button>
</form>
</div>
</body>
</html>