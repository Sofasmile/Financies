<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST"
           action="${pageContext.request.contextPath}/indicate" modelAttribute="indicate">
    <table>
        <tr>
            <td><form:label path="data1">Data1</form:label></td>
            <td><form:input path="data1"/></td>
        </tr>
        <tr>
            <td><form:label path="data2">Data2</form:label></td>
            <td><form:input path="data2"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
