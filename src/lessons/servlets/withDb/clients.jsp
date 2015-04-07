<%@page contentType="text/html; ISO-8859-1" language="java"  pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Clients</title>
</head>
<body>
    <c: set var="myclients" value='${session.getAttribute("clients")}'/>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>SurName</th>
        </tr>
        <c:forEach var="client" items="myclients">
            <tr>
                <td>${client.id}</td>
                <td>${client.Name}</td>
                <td>${client.Surname}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>