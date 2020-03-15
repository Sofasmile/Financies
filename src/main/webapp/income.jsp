<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head></head>
<body>
<h3>Insert your income!</h3>
<form action="${pageContext.request.contextPath}/income" method="post">
    <table>
        <tr>
            <td>Date:</td>
            <td><input value="${localDate}" name="localDate"/></td>
        </tr>
        <tr>
            <td>Money:</td>
            <td><input value="${money}" type="number" step="0.01" min="0" name="money"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">OK</button>
                <br>
                <br>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
