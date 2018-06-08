<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:application>
  <jsp:attribute name="title">Maintenance Events</jsp:attribute>
  <jsp:body>

    <%-- Header --%>
    <div class="wrapper">
      <h1 class="has-subtitle">Maintenance Events</h1>
      <p class="subtitle">Here you can create and edit maintenance events regarding your page.</p>
    </div>

    <div class="column-wrapper">

      <div class="column border">

        <c:choose>
          <c:when test="${!events.isEmpty()}">
            <ul class="event-list">
              <c:forEach items="${events}" var="event">
                <li class="event">
                  <a href="${pageContext.request.contextPath}/maintenance/${event.id}/edit">

                    <%-- Title --%>
                    <p class="preview">
                      <c:out value="${fn:substring(event.title, 0, 64)}"/>
                    </p>

                    <%-- Footer --%>
                    <div class="footer">
                      <p>
                        From
                        <fmt:formatDate pattern="h:mma MMM dd, yyyy" value="${event.startAt}" />
                        to
                        <fmt:formatDate pattern="h:mma MMM dd, yyyy" value="${event.finishAt}" />
                      </p>
                    </div>

                  </a>

                </li>
              </c:forEach>
            </ul>
          </c:when>
          <c:otherwise>
            <%--TODO Improve this empty state--%>
            <p>There's nothing here!</p>
          </c:otherwise>
        </c:choose>

      </div>
      <div class="column">

        <div class="buttons">
          <a href="${pageContext.request.contextPath}/maintenance/new" class="button wide">New Maintenance Event</a>
        </div>

      </div>

    </div>

  </jsp:body>
</t:application>