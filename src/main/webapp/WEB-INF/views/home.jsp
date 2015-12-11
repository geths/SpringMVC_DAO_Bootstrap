<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>Student Directory Home</title>
    </head>
    <body>
    <div id="main">
    	<nav class="navbar navbar-inverse">
  			<div class="container-fluid">
    			<div class="navbar-header">
      				<a class="navbar-brand" href="home">My University</a>
   			 	</div>
    			<div>
      				<ul class="nav navbar-nav">
       					<li class="active"><a href="home">Home</a></li>
        				<li><a href="newContact">Add Student</a></li> 
       					<li><a href="emailContact">Send Email</a></li>
        				<li><a href="createExcel">Export Contact</a></li> 
      				</ul>
    			</div>
  			</div>
		</nav>
    	<div align="center">
	        <h1>Student Directory</h1>
	       
			
	    </div>
	    <br><br>
	   
	    <div align = "center">
	        <table class="table table-hover">
   			 <thead>
	        	<th>No</th>
	        	<th>Full Name</th>
	        	<th>Email</th>
	        	<th>Address</th>
	        	<th>Telephone</th>
	        	<th>Edit</th>
	        	</thead>
				<c:forEach var="contact" items="${listContact}" varStatus="status">
				<tbody>
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.address}</td>
					<td>${contact.telephone}</td>
					<td>
						<a href="editContact?id=${contact.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;
						<a href="deleteContact?id=${contact.id}">Delete</a>
					</td>
				</tr>
				</c:forEach>
				</tbody>
		</table>
	</div>
	<br><br>
	</div>
	<div>
    	<form:form action="" method="post" modelAttribute="contact">
		<table>
			<form:hidden path="id"/>
		</table>
		</form:form>
    </div>
    	
    </body>
</html>
