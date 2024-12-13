<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Performance Booking</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>

<body>

<%@ include file="inc/top.jsp" %>

<main class="container mt-5">
    <h1 class="text-center">Welcome to Performance Booking</h1>
    <p class="text-center">Choose an option below:</p>

    <div class="row justify-content-center mt-4">
        <!-- Performance List -->
        <div class="col-md-4 mb-3">
            <a href="${pageContext.request.contextPath}/performance/list" class="btn btn-success btn-lg w-100">View Performances</a>
        </div>

        <!-- User Reservations -->
        <div class="col-md-4 mb-3">
            <a href="${pageContext.request.contextPath}/user/reservations" class="btn btn-info btn-lg w-100">My Reservations</a>
        </div>
    </div>
</main>

<%@ include file="inc/foot.jsp" %>

</body>

</html>