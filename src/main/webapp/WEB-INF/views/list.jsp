<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Performance List</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css">
</head>

<body>

<%@include file="inc/top.jsp" %>

<main class="container">
    <div class="my-3 p-3 bg-body rounded shadow-sm">
        <h6 class="border-bottom pb-2 mb-0">공연 목록</h6>

        <!-- Performance list dynamically generated -->
        <c:forEach items="${performances}" var="performance">
            <div class="d-flex text-body-secondary pt-3">
                <div class="image-container" style="width: 100px; height: 100px; margin-right: 10px;">
                    <a href="${pageContext.request.contextPath}/view/${performance.id}">
                        <img src="${performance.imageUrl}"
                             alt="Event Image"
                             class="img-fluid rounded"
                             style="width: 100%; height: 100%; object-fit: cover;">
                    </a>
                </div>
                <div class="content-wrapper flex-grow-1">
                    <a href="${pageContext.request.contextPath}/view/${performance.id}"
                       class="width100 pb-3 mb-0 small lh-sm border-bottom">
                        <span class="d-block">
                            <span class="display-flex">
                                <strong class="content-title d-block text-gray-dark">
                                        ${performance.title}
                                </strong>
                                <span class="content-price">
                                    인원 : ${performance.currentPeople} / ${performance.maxPeople}
                                </span>
                            </span>
                            <span class="display-flex">
                                <span class="sr right-margin-writer">
                                        ${performance.clubName}
                                </span>
                                <span class="content-date text-gray">
                                        ${fn:substring(performance.date, 0, 10)}
                                </span>
                            </span>
                        </span>
                        <span class="content-summary phone">
                            ${fn:substring(performance.description, 0, 100)}...
                        </span>
                    </a>
                </div>
            </div>
        </c:forEach>

    </div>
</main>

<%@include file="inc/foot.jsp" %>

</body>

</html>