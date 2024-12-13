<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Write Performance</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css">
</head>

<body class="writing">

<%@ include file="../inc/top.jsp" %>

<main class="container mt-5">
    <h1 class="text-center mb-4">Create a New Performance</h1>
    <form action="${pageContext.request.contextPath}/performance/write_ok" method="post" enctype="multipart/form-data" class="needs-validation" novalidate>
        <!-- Title -->
        <div class="row mb-3">
            <label for="performanceTitle" class="col-sm-2 col-form-label">Title</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="performanceTitle" name="title" placeholder="Enter performance title" required>
                <div class="invalid-feedback">
                    Please provide a performance title.
                </div>
            </div>
        </div>

        <!-- Current and Maximum Participants -->
        <div class="row mb-3">
            <label for="currentNum" class="col-sm-2 col-form-label">Current Participants</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="currentNum" name="currentNum" placeholder="0" required>
                <div class="invalid-feedback">
                    Please specify the current number of participants.
                </div>
            </div>
        </div>
        <div class="row mb-3">
            <label for="maxNum" class="col-sm-2 col-form-label">Maximum Participants</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="maxNum" name="maxNum" placeholder="Enter maximum participants" required>
                <div class="invalid-feedback">
                    Please provide the maximum number of participants.
                </div>
            </div>
        </div>

        <!-- Performance Date -->
        <div class="row mb-3">
            <label for="performanceDate" class="col-sm-2 col-form-label">Date</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="performanceDate" name="performanceDate" required>
                <div class="invalid-feedback">
                    Please select a date for the performance.
                </div>
            </div>
        </div>

        <!-- Poster -->
        <div class="row mb-3">
            <label for="posterFile" class="col-sm-2 col-form-label">Poster</label>
            <div class="col-sm-10">
                <input type="file" class="form-control" id="posterFile" name="posterFile" accept="image/*" required>
                <div class="invalid-feedback">
                    Please upload a poster image.
                </div>
            </div>
        </div>

        <!-- Content -->
        <div class="row mb-3">
            <label for="content" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="content" name="content" rows="6" placeholder="Enter performance details" required></textarea>
                <div class="invalid-feedback">
                    Please provide a description of the performance.
                </div>
            </div>
        </div>

        <!-- Buttons -->
        <div class="text-center">
            <a href="${pageContext.request.contextPath}/performance/list" class="btn btn-outline-secondary me-2">Cancel</a>
            <button type="submit" class="btn btn-primary">Create Performance</button>
        </div>
    </form>
</main>

<%@ include file="../inc/foot.jsp" %>

<script>
    // Bootstrap validation
    (function () {
        'use strict';
        const forms = document.querySelectorAll('.needs-validation');
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    })();
</script>

</body>

</html>