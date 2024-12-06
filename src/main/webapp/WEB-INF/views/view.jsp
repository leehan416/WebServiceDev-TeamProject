<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css">
</head>

<body class="writing">

<%@include file="inc/top.jsp" %>

<main style="padding: 0 10%;" class="container">
    <!-- button -->
    <div style="display: flex;">

        <div style="margin-left: auto;">
            <%-- TODO : edit path here--%>
            <a href="${pageContext.request.contextPath}/edit/1">
                <button class="btn btn-outline-secondary d-inline-flex align-items-center" type="button">edit</button>
            </a>
            <%-- TODO : edit path here--%>
            <a href="${pageContext.request.contextPath}/delete?id=1">
                <button class="btn btn-primary d-inline-flex align-items-center" type="button">delete
                </button>
            </a>
        </div>
    </div>


    <div style="margin-top: 1em;"></div>
    <!-- date -->
    <%-- TODO : date here --%>
    <h6>2024-12-15</h6>

    <%-- TODO : title here --%>
    <%--  title  --%>
    <h1>제목제목제목</h1>

    <div class="sr">
        <%-- TODO : the number of people --%>
        <h3>30 / 50</h3>

        <%-- title of club--%>
        <%-- TODO : title of club--%>
        <h6 class="text-gray-dark">동아리 이름</h6>
    </div>
    <hr>

    <%-- TODO : poster here --%>
    <%-- poster --%>
    <div class="poster-container mb-4" style="width: 100%; max-width: 800px; margin: 0 auto;">
        <img src="https://cdn.pixabay.com/photo/2016/11/22/23/45/acoustic-1851248_1280.jpg"
             alt="클럽 포스터"
             class="img-fluid rounded shadow-lg"
             style="width: 100%; height: 400px; object-fit: cover; object-position: center;">
    </div>


    <!-- content -->
    <p class="full-size">
        내용내용내용
    </p>

</main>

<%@include file="inc/foot.jsp" %>


</body>

</html>