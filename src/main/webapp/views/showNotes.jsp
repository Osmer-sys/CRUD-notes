<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My notes</title>
<style type="text/css">
html{
    height: 100%;
}
body{
    margin: 200px;
    padding: 0;
    background: linear-gradient(#4cc9f0,#3f37c0);
}
table{
    width: 100%;
   
}
table,th, td{
    border: none;
    padding: 10px;
    border-radius: 5px;
    font-size: 18px;
    }
caption{
    color: blue;
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    font-size: 20px;
    line-height:20px; 
}

td{
    text-align: center;

  }

th{
    color: #f1faee;
    text-align: center;
    background-color:#1d3557;
}

tr:nth-child(even){
    background-color:#f1faee ;
}
tr:nth-child(odd){
    background-color:#a8dadc ;
}
a:link, a:visited{
    background-color: none;
    font-size:18px;
    color: purple;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    display:inline-block;
    border-radius: 5px 5px 5px 5px; 
    width: 50%;
}
a:hover, a:active{
    background-color: none;
}
</style>
</head>
<body>

<table>
		<tr>
			<th>ID</th>
			<th>Title</th>	
		  <th>Contents</th>		 	 
		 <th colspan=2>Actions</th>
		</tr>
		
		<c:forEach var="notes" items="${lista}">
			<tr>
				<td><c:out value="${notes.id_note}"/></td>
				<td><c:out value="${notes.title}"/></td>
				<td><c:out value="${notes.textWritten}"/></td>
				<td><a href="AdminNotes?action=showUpdate&id_note=<c:out value="${notes.id_note}"/>">Update</a></td>
				<td><a href="AdminNotes?action=delete&id_note=<c:out value="${notes.id_note}"/>">Delete</a> </td>
			</tr>
		</c:forEach>
	</table>
	<div>
	<a href="AdminNotes?action=back">Back</a>
	</div>
		
</body>
</html>