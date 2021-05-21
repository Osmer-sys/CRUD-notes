<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
   <style type="text/css">
   html{
    height: 100%;
}
body{
    margin: 0;
    padding: 0;
    background: linear-gradient(#4cc9f0,#3f37c0);
}
.contenedor{
    margin: 200px auto;
    width: 400px;
    padding: 30px;
    background: rgba(0, 0, 0, .5);
    border-radius: 10px; 
}
.contenedor h2{
    margin: 0 0 30px;
    padding: 0;
    font-size: 50px;
    color: #4cc9f0;
    text-align: center;
}
.contenedor .elemento label{
    color: white;
    font-size: 20px;
}
.contenedor .elemento input{
    width: 80%;
    padding: 10px 0;
    color: #fff;
    background: transparent;
    border: none;
    border-bottom: 1px solid #fff ;
    margin: 30px;
}
.contenedor .elemento input[type="submit"]{
    background: #b5179e;
    border: none;
    letter-spacing: 5px;
    text-transform: uppercase;
    cursor: pointer;
    padding: 15px;
    margin-top: 30px;
    border-radius: 10px 10px 10px 10px;
}
orm input[type="submit"]:hover{
	cursor:pointer;
   </style>
</head>
<body>
    <div class="contenedor">
        <h2>Login</h2>
        <form action="AdminNotes?action=validateUser" method="POST">
            <div class="elemento">
                <label for="email">Email</label>
                <input type="text" id="email" name="email" required="required"/>
            </div>
            <div class="elemento">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required="required"/>
            </div>
            <div class="elemento">
                <input type="submit" value="Send" accesskey="s"/>
            </div>
        </form>
    </div>
</body>
</html>