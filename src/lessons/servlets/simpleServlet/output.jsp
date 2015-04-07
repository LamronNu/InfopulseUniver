<%@page contentType="text/html; ISO-8859-1" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>JSP page</title>
</head>
<body>
<%--JSP--%>
    <h1> Hello, <%=session.getAttribute("username")%></h1>
<%--expression language--%>
    <h1> Hello, ${param["username"]}</h1>
    <h1> Hello, ${param.username}</h1>
</body>
</html>