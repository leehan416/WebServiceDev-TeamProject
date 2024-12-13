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

<%@include file="inc/top.jsp" %>

<!-- Performance Entry Form -->

<main class="container">
    <form action="${pageContext.request.contextPath}/performance/write_ok" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">

        <!-- Performance Title -->
        <div class="display-flex mb-3">
            <span class="block width20">
                <label for="performanceTitle">Title</label>
            </span>
            <span class="block width80">
                <input class="form-control" type="text" id="performanceTitle" name="title" required>
            </span>
        </div>

        <!-- Current and Maximum Participants -->
        <div class="display-flex mb-3">
            <span class="block width20">
                <label for="currentNum">Current Participants</label>
            </span>
            <span class="block width80">
                <input class="form-control" type="number" id="currentNum" name="currentNum" required>
            </span>
        </div>
        <div class="display-flex mb-3">
            <span class="block width20">
                <label for="maxNum">Maximum Participants</label>
            </span>
            <span class="block width80">
                <input class="form-control" type="number" id="maxNum" name="maxNum" required>
            </span>
        </div>

        <!-- Performance Date -->
        <div class="display-flex mb-3">
            <span class="block width20">
                <label for="performanceDate">Date</label>
            </span>
            <span class="block width80">
                <input class="form-control" type="date" id="performanceDate" name="performanceDate" required>
            </span>
        </div>

        <!-- Poster Upload -->
        <div class="display-flex mb-3">
            <span class="block width20">
                <label for="posterFile">Poster</label>
            </span>
            <span class="block width80">
                <input class="form-control" type="file" id="posterFile" name="posterFile" required>
            </span>
        </div>

        <!-- Performance Content -->
        <div class="mb-3">
            <label for="content">Content</label>
            <textarea class="form-control" id="content" name="content" rows="10" required></textarea>
        </div>

        <!-- Submit Buttons -->
        <div class="text-center py-4">
            <a href="${pageContext.request.contextPath}/performance/list" class="btn btn-outline-secondary">Cancel</a>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</main>

<%@include file="inc/foot.jsp" %>

</body>

</html>