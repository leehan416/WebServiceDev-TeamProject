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

<%@include file="../inc/top.jsp" %>

<main class="container mt-5">
    <div class="p-4 bg-light rounded shadow-sm text-center">
        <h2 class="text-success mb-3">Submission Successful!</h2>
        <p class="mb-4">Your performance entry has been saved successfully. Here are the details:</p>

        <div class="table-responsive">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <th>Title</th>
                    <td>${performance.title}</td>
                </tr>
                <tr>
                    <th>Current Participants</th>
                    <td>${performance.currentNum}</td>
                </tr>
                <tr>
                    <th>Maximum Participants</th>
                    <td>${performance.maxNum}</td>
                </tr>
                <tr>
                    <th>Date</th>
                    <td>${performance.performanceDate}</td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td>${performance.content}</td>
                </tr>
                <tr>
                    <th>Poster</th>
                    <td>
                        <img src="${pageContext.request.contextPath}${performance.posterFile}" alt="Poster Image" class="img-thumbnail" style="max-width: 200px;">
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="d-flex justify-content-center gap-3 mt-4">
            <!-- Submit another entry -->
            <a href="${pageContext.request.contextPath}/performance/write" class="btn btn-outline-primary">Submit Another Entry</a>
            <!-- Back to list -->
            <a href="${pageContext.request.contextPath}/performance/list" class="btn btn-primary">Back to List</a>
        </div>
    </div>
</main>

<%@include file="../inc/foot.jsp" %>

</body>

</html>