<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Department List Page</title>
</head>
<body>

<h1>Departments List</h1>
<a href="department-form.jsp" style="display: block">Add department Page</a>
<a href="employees" style="display: block">Employee List Page</a>


<form method="get" action="departments">
    <label>Tìm phòng ban</label>
    <input name="name">
    <button type="submit">Search</button>
</form>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${departments}" var="d">
        <tr>
            <td>${d.id}</td>
            <td>${d.name}</td>
            <td>
                <a href="departments?action=EDIT&id=${d.id}">EDIT</a>
                <form action="departments" method="post">
                    <input type="hidden" name="action" value="DELETE">
                    <input type="hidden" name="id" value="${d.id}">
                    <button type="submit">DELETE</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
