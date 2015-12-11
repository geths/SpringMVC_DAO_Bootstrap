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
        <title>eMail Student</title>
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

        <h1>Sending eMail to Student</h1>
        <form:form action="sendEmail" method="post" modelAttribute="contact">
            <table border="0" width="80%">
                <tr>
                    <td>To:</td>
                    <td><form:select path="country">
 						<form:option value="" label="Choose a Recipient" />
 						<form:options items="${countryList}"/>
 					</form:select>
                </td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td><input type="text" name="subject" size="50" /></td>
                </tr>
                <tr>
                    <td>Message:</td>
                    <td><textarea cols="50" rows="5" name="message"></textarea></td>
                </tr>        
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Send E-mail" />
                    </td>
                </tr>
                
            </table>
        </form:form>

</div>
</body>
</html>