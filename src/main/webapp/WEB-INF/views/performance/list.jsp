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

<%@ include file="../inc/top.jsp" %>

<main class="container">
    <div class="my-3 p-3 bg-body rounded shadow-sm">
        <h6 class="border-bottom pb-2 mb-0 d-flex justify-content-between align-items-center">
            Performance List
            <div>
                <a href="${pageContext.request.contextPath}/performance/list?sort=latest" class="btn btn-sm btn-primary">최신순</a>
                <a href="${pageContext.request.contextPath}/performance/list?sort=oldest" class="btn btn-sm btn-secondary">오래된순</a>
            </div>
        </h6>

        <!-- Performance list dynamically generated -->
        <c:forEach items="${performanceList}" var="performance">
            <div class="d-flex align-items-start pt-3">
                <!-- Performance Image -->
                <div class="image-container me-3" style="width: 100px; height: 100px;">
                    <a href="${pageContext.request.contextPath}/performance/view/${performance.id}">
                        <img src="${pageContext.request.contextPath}${performance.posterFile}"
                             alt="Performance Image"
                             class="img-fluid rounded"
                             style="width: 100%; height: 100%; object-fit: cover;">
                    </a>
                </div>
                <!-- Performance Details -->
                <div class="flex-grow-1">
                    <a href="${pageContext.request.contextPath}/performance/view/${performance.id}" class="text-decoration-none text-dark">
                        <h5 class="mb-1">${performance.title}</h5>
                    </a>
                    <p class="mb-1 text-muted">Participants: ${performance.currentNum} / ${performance.maxNum}</p>
                    <p class="mb-0 text-muted">Date: ${fn:substring(performance.performanceDate, 0, 10)}</p>
                </div>
            </div>
        </c:forEach>

        <!-- Fallback for empty list -->
        <c:if test="${fn:length(performanceList) == 0}">
            <p class="text-center mt-4">No performances available.</p>
        </c:if>
    </div>
</main>

<%@ include file="../inc/foot.jsp" %>

</body>

</html>

