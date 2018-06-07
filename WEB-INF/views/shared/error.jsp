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
          <p>If you think this page should exist, create a new issue and let us know.</p>
          <div class="buttons">
            <a class="button" href="${pageContext.request.contextPath}/">
              <i class="material-icons">home</i>
              <span>Return Home</span>
            </a>
            <a class="button-secondary" href="${pageContext.request.contextPath}/issues/new">
              New Issue
            </a>
          </div>
        </c:when>
        <c:otherwise>
          <div class="buttons">
            <a class="button" href="${pageContext.request.contextPath}/">
              <i class="material-icons">home</i>
              <span>Return Home</span>
            </a>
          </div>
        </c:otherwise>
      </c:choose>
    </div>



  </jsp:body>
</t:application>