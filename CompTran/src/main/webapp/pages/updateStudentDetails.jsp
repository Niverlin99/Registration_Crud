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
<p class="font-weight-light">Training makes Prefect Target.</p>
<center>
<div class="shadow-lg p-3 mb-5 bg-white rounded">
 Hi ${student_name} lets begin update Your details below
 <div class="card shadow-lg p-3 mb-5 bg-white rounded">
  <div class="card-body">
  <h5 class="card-title">Address Detail</h5>
  <h6 class="card-subtitle mb-2 text-muted">Update your details(Name can't be Updated)</h6>
    <form action="updateStudentDetails" method="post">
  <div class="form-group">
    <label for="student_name">Name:</label>
    <input type="text" readonly class="form-control" value="${student.student_name}" id="student_name" placeholder="Enter name">
   
  </div>
  <div class="form-group">
    <label for="student_technology">Technology</label>
    <input type="text" value="${student.tech}" name="tech" class="form-control" id="student_technology" placeholder="Technology">
  </div>
   <div class="form-group">
    <label for="student_city">City name:</label>
    <input type="text" value="${address.city_name}" name="address.city_name" class="form-control" id="student_city" placeholder="City">
  </div>
  <div class="form-group">
    <label for="student_street">Street name:</label>
    <input type="text" value="${address.street_name }" name="address.street_name" class="form-control" id="student_street" placeholder="Street">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
  </div>
</div>
 </div></center>
</div>
</body>
</html>