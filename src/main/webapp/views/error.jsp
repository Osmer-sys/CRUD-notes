<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
<style type="text/css">
html{
height: 100%;
}
h1{
    color: #b5179e;
    font-style: italic;
    font-size: 40px;
    }
a:link, a:visited{
    background-color: #b5179e;
    font-size:20px;
    color: white;
    padding: 10px 10px;
    text-align: center;
    text-decoration: none;
    display:block;
    border-radius: 10px 10px 10px 10px; 
    width: 10%;
}
/*cuando estamos dando click sobre el elemento*/
a:hover, a:active{
    background-color: #f72585;
}
body{
	margin: 0;
    padding: 0;
    background: #4cc9f0;
}
img {
  border-radius: 20px;
  padding: 50px;
}
</style>
</head>
<body>
<div align="center"><img alt="error" src="views/error.jpg">
<h1 align="center">something is wrong!</h1>
<a href="index.jsp">Home</a>
</div>
</body>
</html>