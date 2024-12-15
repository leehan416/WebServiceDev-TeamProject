<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
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
        <!-- Performance Poster -->
        <div class="col-md-4">
            <img src="${pageContext.request.contextPath}${performance.posterFile}"
                 alt="Performance Poster" class="img-fluid rounded shadow-sm">
        </div>
        <!-- Performance Details -->
        <div class="col-md-8">
            <h1 class="mb-3">${performance.title}</h1>
            <p class="text-muted">
                <strong>Date:</strong> ${performance.performanceDate}
            </p>
            <p class="text-muted">
                <strong>Participants:</strong> ${performance.currentNum} / ${performance.maxNum}
            </p>
            <p class="mt-4">${performance.content}</p>
        </div>
    </div>

    <!-- Buttons -->
    <div class="mt-4 d-flex justify-content-end gap-3">
        <!-- Back to List -->
        <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Back to List</a>
        <!-- Reservation -->
        <a href="${pageContext.request.contextPath}/reservations/add?id=${performance.id}" class="btn btn-primary">Reserve</a>
        <!-- Edit and Delete Buttons -->
        <c:if test="${sessionScope.login != null}">
            <a href="${pageContext.request.contextPath}/performance/edit/${performance.id}" class="btn btn-warning">Edit</a>
            <form action="${pageContext.request.contextPath}/performance/delete/${performance.id}" method="post" style="display:inline;">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </c:if>
    </div>
</main>

<%@ include file="../inc/foot.jsp" %>

</body>

</html>