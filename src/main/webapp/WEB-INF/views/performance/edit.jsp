<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Performance</title>

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
    <h1 class="text-center mb-4">Edit Performance</h1>
    <form action="${pageContext.request.contextPath}/performance/edit_ok" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${performance.id}">

        <!-- Title -->
        <div class="row mb-3">
            <label for="performanceTitle" class="col-sm-2 col-form-label">Title</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="performanceTitle" name="title" value="${performance.title}" required>
            </div>
        </div>

        <!-- Current and Maximum Participants -->
        <div class="row mb-3">
            <label for="currentNum" class="col-sm-2 col-form-label">Current Participants</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="currentNum" name="currentNum" value="${performance.currentNum}" required>
            </div>
        </div>
        <div class="row mb-3">
            <label for="maxNum" class="col-sm-2 col-form-label">Maximum Participants</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="maxNum" name="maxNum" value="${performance.maxNum}" required>
            </div>
        </div>

        <!-- Performance Date -->
        <div class="row mb-3">
            <label for="performanceDate" class="col-sm-2 col-form-label">Date</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="performanceDate" name="performanceDate" value="${performance.performanceDate}" required>
            </div>
        </div>

        <!-- Poster -->
        <div class="row mb-3">
            <label for="posterFile" class="col-sm-2 col-form-label">Poster</label>
            <div class="col-sm-10">
                <input type="file" class="form-control" id="posterFile" name="posterFile" accept="image/*">
            </div>
        </div>

        <!-- Content -->
        <div class="row mb-3">
            <label for="content" class="col-sm-2 col-form-label">Content</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="content" name="content" rows="6" required>${performance.content}</textarea>
            </div>
        </div>

        <!-- Buttons -->
        <div class="text-center">
            <a href="${pageContext.request.contextPath}/performance/list" class="btn btn-outline-secondary me-2">Cancel</a>
            <button type="submit" class="btn btn-primary">Save Changes</button>
        </div>
    </form>
</main>

<%@ include file="../inc/foot.jsp" %>

</body>

</html>
