<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css">
</head>


<body>
<%@ include file="../../inc/top.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">My Reservations</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Reservation ID</th>
            <th>Performance ID</th>
            <th>Reservation Date</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reservations}" var="reservation">
            <tr>
                <td>${reservation.id}</td>
                <td>${reservation.performance_id}</td>
                <td>${reservation.reg_date}</td>
                <td>

                    <a href="remove?id=${reservation.id}">
                        <button type="button" class="btn btn-secondary" onclick="window.history.back();">
                            취소
                        </button>
                    </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty reservations}">
        <p class="text-center">No reservations found.</p>
    </c:if>
</div>

<%@ include file="../../inc/foot.jsp" %>
</body>
</html>