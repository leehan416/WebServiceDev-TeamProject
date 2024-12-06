<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

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

    <link rel="stylesheet" href="css/my.css">
</head>

<body>


<%@include file="inc/top.jsp" %>

<main class="container">
    <div class="my-3 p-3 bg-body rounded shadow-sm">
        <h6 class="border-bottom pb-2 mb-0">서적 목록</h6>

        <!-- content list -->
<%--        <c:forEach items="${bookVos}" var="book">--%>
<%--            <div class="d-flex text-body-secondary pt-3">--%>
<%--                <a href="${pageContext.request.contextPath}/view/${book.id}" class="width100 pb-3 mb-0 small lh-sm border-bottom">--%>
<%--        <span class="d-block">--%>
<%--            <span class="display-flex">--%>
<%--                <strong class="content-title d-block text-gray-dark">--%>
<%--                        ${book.title}--%>
<%--                </strong>--%>
<%--                <span class="content-price">--%>
<%--                    ${book.price}원--%>
<%--                </span>--%>
<%--            </span>--%>
<%--            <span class="display-flex">--%>
<%--                <span class="sr right-margin-writer">--%>
<%--                    ${book.writer} 저--%>
<%--                </span>--%>
<%--                <span class="content-date text-gray">--%>
<%--                    ${fn:split(book.reg_date.toString(), " ")[0]}--%>
<%--                <div>--%>
<%--                    책 번호 : ${book.id}--%>
<%--                </div>--%>
<%--                </span>--%>
<%--            </span>--%>
<%--        </span>--%>
<%--                    <span class="content-summary phone">--%>
<%--                ${fn:substring(book.content, 0, 100)}...--%>
<%--            </span></a></div>--%>
<%--        </c:forEach>--%>

    </div>
</main>

<%@include file="inc/foot.jsp" %>

</body>

</html>