<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Notes</title>
<style type="text/css">
html{
    height: 100%;
}
body{
    margin: 200px;
    padding: 0;
    background: linear-gradient(#4cc9f0,#3f37c0);
}

form{
	width:400px;
	padding:16px;
	border-radius:10px;
	margin:auto;
	background-color:transparent;
	text-align: center;
}
form label{
	width:100px;
	font-weight:bold;
	color:white;
}
form input[type="text"]
{
	width:80%;
	padding:10px 10px;
	border:1px solid #f6f6f6;
	border-radius:3px;
	background-color:#f6f6f6;
	margin:8px 0;
	display:inline-block;
}

form input[type="submit"],form input[type="reset"]{
	width:50%;
	padding:8px 16px;
	margin-top:20px;
	border:none;
	border-radius:5px;
	display:inline-block;
	color:#fff;
	background-color:#b5179e;
	font-size: 15px;
	
} 

form input[type= "submit"],form input[type="reset"]:hover{
	cursor:pointer;
	
}

textarea{
	width:100%;
	height:100px;
	border:1px solid #f6f6f6;
	border-radius:3px;
	background-color:#f6f6f6;			
	margin:8px 0;
	font-size:15px;
	display:block;
}
fieldset {
  border-radius:10px;
  border-bottom-style: solid;
}
legend {
  background-color:#b5179e;
  color: white;
  padding: 5px 10px;
  border:none;
  border-radius:5px;
  font-size: 20px;
 }
 a:link, a:visited{
    background-color: #b5179e;
    font-size:15px;
    color: white;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    display:inline-block;
    border-radius: 5px 5px 5px 5px; 
    width: 40%;
}
a:hover, a:active{
    background-color: #f72585;
}
</style>
</head>
<body>
	<br />
	<form action="AdminNotes?action=update" method="POST" target="_self">
	<fieldset>
	   <legend>Note</legend>
		<label for="title">Id:</label>
		<input  type="text" id="id_note"
			name="id_note" readonly="readonly" value='<c:out value="${note.id_note}"></c:out>'></input><br /> 
			<label for="title">Title: </label>
		<input type="text" id="title"
			name="title" value='<c:out value="${note.title}"></c:out>'></input><br />
		<label for="title">Contents:</label>
		<input type="text" id="textWritten" 
			name="textWritten" value='<c:out value="${note.textWritten}"></c:out>'></input>
		<br/> <input type="submit" value="Update" accesskey="u"/>
		<a href="AdminNotes?action=showNotes">Cancel</a>
	</fieldset>
	</form>
</body>
</html>