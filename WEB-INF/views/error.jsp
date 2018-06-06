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
      <jsp:if
      If you think it shouldCreate a new issue and let us know
      <div class="buttons">
        <a class="button" href="${pageContext.request.contextPath}/issue/new">
          New Issue
        </a>
      </div>
    </div>



  </jsp:body>
</t:application>