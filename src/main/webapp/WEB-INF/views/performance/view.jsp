<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Performance Details</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css">
</head>

<body>

<%@ include file="../inc/top.jsp" %>

<main class="container mt-5">
    <div class="row">
        <div class="col-md-4">
            <!-- Performance Poster -->
            <img src="${performance.posterFile}" alt="Performance Poster" class="img-fluid rounded shadow-sm">
        </div>
        <div class="col-md-8">
            <h1 class="mb-3">${performance.title}</h1>
            <p class="text-muted">Date: ${performance.performanceDate}</p>
            <p class="text-muted">Participants: ${performance.currentNum} / ${performance.maxNum}</p>
            <p>${performance.content}</p>
        </div>
    </div>

    <!-- Buttons -->
    <div class="mt-4 d-flex justify-content-end gap-3">
        <a href="${pageContext.request.contextPath}/performance/list" class="btn btn-secondary">Back to List</a>
        <a href="${pageContext.request.contextPath}/user/reservations/write/${performance.id}" class="btn btn-primary">Reserve</a>
    </div>
</main>

<%@ include file="../inc/foot.jsp" %>

</body>

</html>