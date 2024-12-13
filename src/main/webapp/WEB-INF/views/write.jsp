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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css">
</head>

<body class="writing">

<%@include file="inc/top.jsp" %>

<!-- 정보 입력 -->

<main class="container">
    <form action="${pageContext.request.contextPath}/write_ok" method="post">
        <input type="hidden" name="id">
        <!-- 정보 입력 -->
        <input type="hidden" name="id">

        <!-- title -->
        <div class="display-flex">
        <span class="block width20 ">
          <label for="booktitle">Title</label>

        </span>
            <span class="block width80 ">
                 <input class="form-control width100" type="text" id="booktitle" name="title" required>
            </span>
        </div>

        <!-- maximum number of person -->
        <div class="display-flex">
            <span class="block width20">
                <label for="price">maximum people</label>
            </span>
            <span class="block width80 ">
            <input class="form-control width100" type="number" id="price" name="price" required>
            </span>
        </div>




        <!-- date and num -->
        <div class="width100 display-flex">
        <span class="width20 block">
          <label>Date</label>
        </span>
            <span class="block width80 ">
            <input class="form-control full-size" type="date" id="reg_date" name="reg_date" required>

        </span>
        </div>

        <%-- file--%>
        <div class="width100 display-flex">
        <span class="width20 block">
          <label>Poster</label>
        </span>
            <span class="block width80 ">
          <input class="form-control full-size" type="file" id="file" name="file">
        </span>
        </div>

        <!-- content -->
        <textarea class="form-control full-size height20em" name="content" id="content" required></textarea>

        <!-- button -->
        <center>
            <div class="d-flex gap-2 justify-content-center py-5">
                <a href="${pageContext.request.contextPath}/list">
                    <button class="btn btn-outline-secondary d-inline-flex align-items-center" type="button">cancel
                    </button>
                </a>
                <button class="btn btn-primary d-inline-flex align-items-center"
                        type="submit"> confirm
                </button>

            </div>
        </center>
    </form>
</main>


<%@include file="inc/foot.jsp" %>


</body>

</html>