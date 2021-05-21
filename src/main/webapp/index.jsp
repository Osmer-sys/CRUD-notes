<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD notes</title>
<style media="screen" type="text/css">
  html{
    height: 100%;
}
 h1{
    color: #4cc9f0;
    font-style: italic;
    font-size: 50px;
    }
a:link, a:visited{
    background-color: #b5179e;
    font-size:20px;
    color: white;
    padding: 15px 25px;
    text-align: center;
    text-decoration: none;
    display:block;
    border-radius: 10px 10px 10px 10px; 
    width: 50%;
}
/*cuando estamos dando click sobre el elemento*/
a:hover, a:active{
    background-color: #f72585;
}

.contenedor{
    margin:200px  auto;
    width: 400px;
    padding: 30px;
    background: rgba(0, 0, 0, .5);
    border-radius: 30px 30px 30px 30px; 
    text-decoration: none;
}
body{
	margin: 0;
    padding: 0;
    background: linear-gradient(#4cc9f0,#3f37c0);
}
 </style>
</head>
<body>
	
	<div class="contenedor" align="center">
		<h1 align="center">Welcome to Notes</h1>
		<a href="AdminNotes?action=login">Login</a>			
		<br/>
		<a href="AdminNotes?action=register">Who are you?</a>
		<br/>
		<a href="AdminNotes?action=about">About as</a>
	</div>
	
</body>
</html>