<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:application>
  <jsp:attribute name="title"><c:out value="${issue.title}" /></jsp:attribute>
  <jsp:body>

    <div class="wrapper">
      <h1 class="issue-title"><c:out value="${issue.title}" /></h1>
    </div>

  </jsp:body>
</t:application>