<div class="container">
    <header class="d-flex flex-wrap justify-content-between align-items-center py-3 mb-4 border-bottom">
        <!-- Logo -->
        <a href="${pageContext.request.contextPath}"
           class="d-flex align-items-center mb-3 mb-md-0 text-dark text-decoration-none">
            <span class="fs-4 fw-bold">HisTicket</span>
        </a>

        <!-- Navigation Links -->
        <ul class="nav nav-pills">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}" class="nav-link">List</a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/performance/write" class="nav-link">Add New</a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/reservations/mypage" class="nav-link">MyPage</a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/login" class="nav-link">Login</a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/login/logout" class="nav-link">Logout</a>
            </li>
            <li>
                <form role="search" class="d-flex" action="${pageContext.request.contextPath}/performance/search">
                    <%
                        String text = request.getParameter("text");
                        if (text == null) text = "";
                    %>
                    <input value="<%= text %>" name="text" type="search" class="form-control me-2"
                           placeholder="Search..." aria-label="Search" style="width: 200px; height: 30px">
                    <button class="btn btn-primary me-2" type="submit"
                            style="border-radius: 4px; height: 30px; margin-top: 5px; padding-top: 2px">
                        Search
                    </button>
                </form>
            </li>
            </ui>
    </header>
</div>