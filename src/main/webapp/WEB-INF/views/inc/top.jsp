<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="${pageContext.request.contextPath}/list"
           class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
            <!-- <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg> -->
            <span class="fs-4">HisTicket</span>
        </a>

        <ul class="nav nav-pills">
            <li class="nav-item"><a href="${pageContext.request.contextPath}/list" class="nav-link" aria-current="page">Performance List</a></li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/write" class="nav-link">Add New</a></li>
            <li class="nav-item"><a href="${pageContext.request.contextPath}/login" class="nav-link">Login</a></li>
            <li class="nav-item">
                <form role="search" class="d-flex" action="${pageContext.request.contextPath}/search">
                    <%
                        String text = request.getParameter("text");
                        if(text == null) text = "";
                    %>
                    <input value="<%= text %>" name="text" type="search" class="form-control me-2" placeholder="Search..." aria-label="Search" style="width: 200px; height: 30px">
                    <button class="btn btn-primary me-2" type="submit" style="border-radius: 4px; height: 30px; margin-top: 5px; padding-top: 2px">
                        Search
                    </button>
                </form>
            </li>
        </ul>
    </header>
</div>