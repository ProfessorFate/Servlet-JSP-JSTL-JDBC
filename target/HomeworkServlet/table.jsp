<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<table class="table1">
<form method="post" action="table">
    <div class="box2">
        <h1>Библиотека</h1>
    </div>
        <td>ID</td>
        <td><input type="number" name="id"/></td>

        <td>AuthorName</td>
        <td><input type="text" name="AuthorName"/></td>

        <td>AuthorLastName</td>
        <td><input type="text" name="AuthorLastName"/></td>

         <td>BookName</td>
         <td><input type ="text" name="BookName"/></td>

       <td> <input type="submit" value="Submit"/></td>
</form>
    </table>
<div>
    <table>
    <tr>
        <th>Id</th>
        <th>AuthorName</th>
        <th>AuthorLastName</th>
        <th>BookName</th>
    </tr>
    <c:forEach items="${usersFromServer}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.authorName}</td>
            <td>${user.authorLastName}</td>
            <td>${user.bookName}</td>
        </tr>
    </c:forEach>
</table>
</div>
<div class="box2">
<form action="logout">
    <input type="submit" value="Logout">
</form>
    </div>
</body>
</html>
