<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

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

<body class="writing">

<%@include file="../../inc/top.jsp" %>

<main style="padding: 0 10%;" class="container">
    <!-- Action Buttons -->
    <div style="display: flex;">
        <div style="margin-left: auto;">
            <a href="${pageContext.request.contextPath}/edit/${performance.id}">
                <button class="btn btn-outline-secondary d-inline-flex align-items-center" type="button">edit</button>
            </a>
            <a href="${pageContext.request.contextPath}/delete?id=${performance.id}">
                <button class="btn btn-primary d-inline-flex align-items-center" type="button">delete</button>
            </a>
        </div>
    </div>

    <div style="margin-top: 1em;"></div>

    <!-- Date -->
    <h6>${fn:substring(performance.performanceDate, 0, 10)}</h6>

    <!-- Title -->
    <h1>${performance.title}</h1>

    <div class="sr">
        <!-- Number of Participants -->
        <h3>${performance.currentNum} / ${performance.maxNum}</h3>

        <!-- Club Name -->
        <h6 class="text-gray-dark">${performance.clubName}</h6>
    </div>
    <hr>

    <!-- Poster -->
    <div class="poster-container mb-4" style="width: 100%; max-width: 800px; margin: 0 auto;">
        <img src="${performance.posterFile}"
             alt="Club Poster"
             class="img-fluid rounded shadow-lg"
             style="width: 100%; height: 400px; object-fit: cover; object-position: center;">
    </div>

    <!-- Content -->
    <p class="full-size">
        ${performance.content}
    </p>

    <!-- Reservation Button -->
    <div class="text-center mt-4">
        <a href="${pageContext.request.contextPath}/reserve">
            <button class="btn btn-primary btn-lg d-inline-flex align-items-center" type="button">
                예약하기
            </button>
        </a>
    </div>

</main>

<%@include file="../../inc/foot.jsp" %>

</body>

</html>