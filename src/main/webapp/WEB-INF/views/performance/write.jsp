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

<%@include file="../inc/top.jsp" %>

<!-- Performance Entry Form -->

<main class="container">
    <form action="${pageContext.request.contextPath}/write_ok" method="post" enctype="multipart/form-data">
        <!-- Title -->
        <div class="row mb-3">
            <label for="performanceTitle" class="col-sm-2 col-form-label">Title</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="performanceTitle" name="title" required>
            </div>
        </div>

        <!-- Current and Maximum Participants -->
        <div class="row mb-3">
            <label for="currentNum" class="col-sm-2 col-form-label">Current Participants</label>
            <div class="col-sm-10">
                <input class="form-control" type="number" id="currentNum" name="currentNum" required>
            </div>
        </div>
        <div class="row mb-3">
            <label for="maxNum" class="col-sm-2 col-form-label">Maximum Participants</label>
            <div class="col-sm-10">
                <input class="form-control" type="number" id="maxNum" name="maxNum" required>
            </div>
        </div>

        <!-- Performance Date -->
        <div class="row mb-3">
            <label for="performanceDate" class="col-sm-2 col-form-label">Date</label>
            <div class="col-sm-10">
                <input class="form-control" type="date" id="performanceDate" name="performanceDate" required>
            </div>
        </div>

        <!-- Poster -->
        <div class="row mb-3">
            <label for="posterFile" class="col-sm-2 col-form-label">Poster</label>
            <div class="col-sm-10">
                <input class="form-control" type="file" id="posterFile" name="posterFile" accept="image/*" required>
            </div>
        </div>

        <!-- Content -->
        <div class="row mb-3">
            <label for="content" class="col-sm-2 col-form-label">Content</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="content" name="content" rows="10" required></textarea>
            </div>
        </div>

        <!-- Buttons -->
        <div class="text-center py-4">
            <a href="${pageContext.request.contextPath}/list" class="btn btn-outline-secondary">Cancel</a>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</main>

<%@include file="../inc/foot.jsp" %>

</body>

</html>