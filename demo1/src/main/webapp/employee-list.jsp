<%--
  Created by IntelliJ IDEA.
  User: 84349
  Date: 02/10/2025
  Time: 1:23 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>

<h1>Employees List</h1>
<a href="employees?action=CREATE" style="display: block">Add employee Page</a>
<a href="departments" style="display: block">Department List Page</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Department ID</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${employees}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.salary}</td>
            <td>${e.department.id}</td>
            <td>
                <a href="employees?action=EDIT&id=${e.id}">EDIT</a>

                <form action="employees" method="post">
                    <input type="hidden" name="action" value="DELETE">
                    <input type="hidden" name="id" value="${e.id}">
                    <button type="submit">DELETE</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
