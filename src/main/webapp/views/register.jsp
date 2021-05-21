<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
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
	display:inline-block;
}
form input[type="text"],
form input[type="email"],
form input[type="password"]{
	width:90%;
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

form input[type="submit"],form input[type="reset"]:hover{
	cursor:pointer;
}

textarea{
	width:100%;
	height:100px;
	border:1px solid #f6f6f6;
	border-radius:3px;
	background-color:#f6f6f6;			
	margin:8px 0;
	font-size:20px;
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
/*cuando estamos dando click sobre el elemento*/
a:hover, a:active{
    background-color: #f72585;
}
</style>
</head>
<body>
    
    <form  action="AdminNotes?action=registerUser" method="POST" target="_self">
        <fieldset>
            <legend>Personal information:</legend>
            
            <label for="name">Name: </label><br/>
            <input type="text" id="name" name="name" 
                placeholder="Escribe tu nombre" required="required"/><br/>

           <label for="email">Email:</label><br/>
            <input type="text" id="email" name="email" 
            placeholder="email@example.com"required="required"><br/>
   			
   			<label for="password">Password: </label><br/>
            <input type="password" id="password" name="password" 
                    required="required"/><br/>
   
            <input type="submit" value="Send" accesskey="s"/>
            <input type="reset" value="Restore" accesskey="r"/>
            <br/>
             <br/>
            <a type="text" href="index.jsp">Home</a>
        </fieldset>
    </form>
</body>
</html>