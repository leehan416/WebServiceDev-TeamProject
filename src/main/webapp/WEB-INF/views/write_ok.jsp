<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submission Confirmation</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css">
</head>

<body class="confirmation">

<%@include file="inc/top.jsp" %>

<!-- Submission Confirmation -->

<main class="container">
    <div class="my-5 p-4 bg-body rounded shadow-sm text-center">
        <h2 class="text-success">Submission Successful</h2>
        <p>Your performance entry has been successfully saved. Thank you for submitting the information.</p>

        <div class="mt-4 d-flex justify-content-center gap-3">
            <a href="${pageContext.request.contextPath}/performance/write">
                <button class="btn btn-outline-primary">Submit Another Entry</button>
            </a>
            <a href="${pageContext.request.contextPath}/performance/list">
                <button class="btn btn-primary">Back to List</button>
            </a>
        </div>
    </div>
</main>

<%@include file="inc/foot.jsp" %>

</body>

</html>