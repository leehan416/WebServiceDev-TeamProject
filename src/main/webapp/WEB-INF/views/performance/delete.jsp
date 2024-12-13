<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Performance</title>

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
    <div class="p-4 bg-light rounded shadow-sm text-center">
        <h2 class="text-danger mb-3">Confirm Deletion</h2>
        <p>Are you sure you want to delete the performance titled "<strong>${performance.title}</strong>"?</p>

        <form action="${pageContext.request.contextPath}/performance/delete_ok" method="post">
            <input type="hidden" name="id" value="${performance.id}">
            <div class="d-flex justify-content-center gap-3 mt-4">
                <a href="${pageContext.request.contextPath}/performance/list" class="btn btn-secondary">Cancel</a>
                <button type="submit" class="btn btn-danger">Delete</button>
            </div>
        </form>
    </div>
</main>

<%@ include file="../inc/foot.jsp" %>

</body>

</html>