<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Employee Form</title>
</head>
<body>
<a href="employees" style="display: block">Add department Page</a>

<form action="employees" method="post">
    <input type="hidden" name="action" value="SAVE">
    <c:if test="${not empty employee}">
        <input type="hidden" name="id" value="${employee.id}">
    </c:if>


    <div>
        <label>Name:</label>
        <input name="name" value="${employee.name}">
    </div>

    <div>
        <label>Salary:</label>
        <input name="salary" value="${employee.salary}">
    </div>

    <div>
        <label>Department:</label>
        <select name="departmentId">
            <c:forEach items="${departments}" var="d">
                <option value="${d.id}">${d.name}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit">Save</button>
</form>

</body>
</html>

