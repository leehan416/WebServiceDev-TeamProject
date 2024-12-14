<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Confirmation</title>

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
        <c:choose>
            <%-- Success Edit --%>
            <c:when test="${performance != null}">
                <h2 class="text-success mb-3">Edit Successful!</h2>
                <p class="mb-4">The performance has been updated successfully. You can now return to the list or view the updated performance.</p>
                <div class="d-flex justify-content-center gap-3">
                    <a href="${pageContext.request.contextPath}/performance/list" class="btn btn-secondary">Back to List</a>
                    <a href="${pageContext.request.contextPath}/performance/view/${performance.id}" class="btn btn-primary">View Performance</a>
                </div>
            </c:when>
            <%-- Fail Edit --%>
            <c:otherwise>
                <h2 class="text-danger mb-3">Edit Failed!</h2>
                <p class="mb-4">There was an issue updating the performance. Please try again or contact support.</p>
                <div class="d-flex justify-content-center">
                    <a href="${pageContext.request.contextPath}/performance/list" class="btn btn-secondary">Back to List</a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</main>

<%@ include file="../inc/foot.jsp" %>

</body>

</html>