<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Department Form</title>
</head>
<body>
<a href="departments" style="display: block">Add department Page</a>

<form action="departments" method="post">
    <input type="hidden" name="action" value="SAVE">
    <c:if test="${not empty department}">
        <input type="hidden" name="id" value="${department.id}">
    </c:if>

    <label>Name:</label>
    <input name="name" value="${department.name}">
    <button type="submit">Save</button>


</form>

</body>
</html>

