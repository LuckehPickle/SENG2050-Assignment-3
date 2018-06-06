<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:application>
  <jsp:attribute name="title">Error <c:out value="${pageContext.response.getStatus()}" /></jsp:attribute>
  <jsp:body>
    <div class="wrapper">
      <h1>Support Portal</h1>
      <h2><c:out value="${pageContext.response.getStatus()}" /></h2>
      <c:out value="${requestScope.message}" /><br/>
      <c:choose>
        <c:when test="${pageContext.response.getStatus() == 404}">
          If you think it should, create a new issue and let us know.
          <div class="buttons">
            <a class="button" href="${pageContext.request.contextPath}/">
            Home
            </a>
            <a class="button-secondary" href="${pageContext.request.contextPath}/issues/new">
              New Issue
            </a>
          </div>
        </c:when>
        <c:otherwise>
          <div class="buttons">
            <a class="button" href="${pageContext.request.contextPath}/">
              Home
            </a>
          </div>
        </c:otherwise>
      </c:choose>
    </div>



  </jsp:body>
</t:application>