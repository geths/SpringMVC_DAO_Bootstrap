<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>Add new student</title>
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
	<div>
		<h1>Create New Contact</h1>

		<form:form action="saveContact" method="post" modelAttribute="contact">
			<form:hidden path="id"/>
				<div class="form-group">
    			  <label class="control-label col-sm-1" for="name">Name</label>
    			  <label class="control-label col-sm-1" for="name">:</label>
     			  <div class="col-sm-10">
       				 <input type="text" class="form-control" name="name" id="name" placeholder="Enter Full Name">
       				 <br>
      			  </div>
    		    </div>
    		    <div class="form-group">
    			  <label class="control-label col-sm-1" for="email">Email ID</label>
    			  <label class="control-label col-sm-1" for="email">:</label>
     			  <div class="col-sm-10">
       				 <input type="text" class="form-control" name="email" id="email" placeholder="Enter Univerity ID">
       				 <br>
      			  </div>
    		    </div>
    		    <div class="form-group">
    			  <label class="control-label col-sm-1" for="address">Address</label>
    			  <label class="control-label col-sm-1" for="address">:</label>   			  
     			  <div class="col-sm-10">
       				 <input type="text" class="form-control" name="address" id="address" placeholder="Enter Full Address">
       				 <br>
      			  </div>
    		    </div>
    		    <div class="form-group">
    			  <label class="control-label col-sm-1" for="telephone">Telephone</label>
    			  <div>
    			  		<label class="control-label col-sm-1" for="telephone">:</label>
    			  </div>
     			  <div class="col-sm-10">
       				 <input type="text" class="form-control" name="telephone" id="telephone" placeholder="Enter Mobile Number">
       				 <br>
      			  </div>
    		    </div>
    			<div class="form-group">        
      				<div class="col-sm-offset-2 col-sm-10">
       					 <button type="submit" class="btn btn-default" value="save">Submit</button>
      				</div>
   				 </div>
			</form:form>
	
		
	</div>
</div>
</body>
</html>