<%@ include file="../include/taglibs.jsp"%>

<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="/">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
        </a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Pages</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Login Screens:</h6>
            <a class="dropdown-item" href="login.html">Login</a>
            <a class="dropdown-item" href="register.html">Register</a>
            <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Other Pages:</h6>
            <a class="dropdown-item" href="404.html">404 Page</a>
            <a class="dropdown-item" href="blank.html">Blank Page</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-table"></i>
            <span>manage</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="/manage/manager">manager</a>
            <a class="dropdown-item" href="/manage/menu">menu</a>
            <a class="dropdown-item" href="/manage/role">role</a>
        </div>
    </li>
    <c:forEach var="menu1" items="${menuRoot.children}">
        <c:choose>
            <c:when test = "${menu1.menuType eq 'menu'}">
                <a class="dropdown-item" href="${menu1.url}">${menu1.name}</a>
            </c:when>
            <c:otherwise>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>${menu1.name}</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <c:forEach var="menu2" items="${menu1.children}">
                            <c:choose>
                                <c:when test = "${menu2.menuType eq 'menu'}">
                                    <a class="dropdown-item" href="${menu2.url}">${menu2.name}</a>
                                </c:when>
                                <c:otherwise>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-fw fa-folder"></i>
                                            <span>${menu2.name}</span>
                                        </a>
                                        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                                            <c:forEach var="menu3" items="${menu2.children}">
                                                <c:choose>
                                                    <c:when test = "${menu3.menuType eq 'menu'}">
                                                        <a class="dropdown-item" href="${menu3.url}">${menu3.name}</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <li class="nav-item dropdown">
                                                            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                <i class="fas fa-fw fa-folder"></i>
                                                                <span>${menu3.name}</span>
                                                            </a>
                                                            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                                                            </div>
                                                        </li>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </div>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                </li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</ul>