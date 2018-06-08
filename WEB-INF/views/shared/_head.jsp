<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${requestScope.currentUser != null}">
  <div class="header">
    <div class="wrapper">
      <nav>
        <a href="${pageContext.request.contextPath}/articles">Knowledgebase</a>
        <a href="${pageContext.request.contextPath}/issues">Issues</a>
        <c:if test='${requestScope.currentUser.getRole() == "IT_STAFF"}'>
          <a href="${pageContext.request.contextPath}/maintenance">Maintenance Events</a>
        </c:if>
        <a class="logout-link" href="${pageContext.request.contextPath}/session/logout" data-method="post" data-params="{}">
          <i class="material-icons">exit_to_app</i>
          <span>Logout</span>
        </a>
      </nav>
    </div>
  </div>
</c:if>