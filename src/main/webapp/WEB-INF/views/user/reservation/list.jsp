<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Reservations</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reservations}" var="reservation">
            <tr>
                <td>${reservation.id}</td>
                <td>${reservation.performanceId}</td>
                <td>${reservation.regDate}</td>
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