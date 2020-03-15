<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>NVP</title>
    <style>
        .wrapper {
            text-align: center;
        }

        .box {
            display: inline-block;
            padding: 20px;
        }
    </style>
</head>
<body>
<h1>Hello everyone!</h1>
<div class="wrapper">
    <div class="box">
        <p style="background-color:Tomato;"><strong>${message1} </strong></p>
        <jsp:include page="income.jsp"/>
    </div>
    <div class="box">
        <p style="background-color:Tomato;"><strong> ${message2} </strong></p>
        <jsp:include page="spending.jsp"/>
    </div>
</div>
<div align="center">
    <h2>Calculate NVP</h2>
    <p style="background-color:Tomato;"><strong> ${message3} </strong></p>
    <form action="${pageContext.request.contextPath}/price" method="post">
        <label>Write discount rate:</label>
        <input value="${discountRate}" name="discountRate"/>
        <button type="submit">Calculate</button>
        <br>
    </form>
    <p><strong> Result: ${message} </strong></p>
</div>

<div class="wrapper">
    <div class="box">
        <p><strong>Your incomes:</strong></p>
        <table border="2">
            <tr>
                <th>Date</th>
                <th>Money</th>
            </tr>
            <c:forEach var="income" items="${incomes}">
                <tr>
                    <td> ${income.localDate}</td>
                    <td> ${income.money}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="box">
        <p><strong>Your spending:</strong></p>
        <table border="2">
            <tr>
                <th>Date</th>
                <th>Money</th>
            </tr>
            <c:forEach var="spend" items="${spending}">
                <tr>
                    <td> ${spend.localDate}</td>
                    <td> ${spend.money}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
