<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>Export Spreadsheet</title>
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
<h1>The table has been exported to worksheet.xls</h1>
<form:form action="cancel" method="post">
<input type="submit" value="Home" />
</form:form>
</div>
</body>
</html>