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
        </ul>
    </header>
</div>