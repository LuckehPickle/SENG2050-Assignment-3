<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:application>
  <jsp:attribute name="title">Error <c:out value="${pageContext.response.getStatus()}" /></jsp:attribute>
  <jsp:body>
    <c:out value="${requestScope.message}" />
  </jsp:body>
</t:application>