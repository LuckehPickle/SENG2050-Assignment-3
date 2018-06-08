<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:application>
  <jsp:attribute name="title">Issues</jsp:attribute>
  <jsp:body>
    <%-- Header --%>
    <div class="wrapper">
      <h1 class="has-subtitle">Issues</h1>
      <p class="subtitle">Here you'll find all your reported issues.</p>
    </div>


    <div class="column-wrapper">

      <div class="column border">

        <c:choose>
          <c:when test="${issues.isEmpty()}">
            <%-- TODO Improve this empty state --%>
            There's nothing here!
          </c:when>
          <c:otherwise>
            <ul class="issue-list">
              <c:forEach items="${issues}" var="issue">
                <li class="issue">
                  <a href="${pageContext.request.contextPath}/issues/${issue.id}">

                    <%-- Title --%>
                    <p class="title">
                      <c:out value="${issue.title}"/>
                      <span class="state"><c:out value="${issue.state.replaceAll('_', ' ')}"/></span>
                    </p>

                    <p class="preview">
                      <c:out value="${fn:substring(issue.body, 0, 64)}"/>
                    </p>

                    <div class="footer">
                      <p>Posted by <c:out value="${issue.getAuthor().getFullName()}" /></p>
                      <span class="badge"><c:out value="${issue.category.replaceAll('_', ' ')}" /></span>
                      <span class="badge"><c:out value="${issue.subCategory.replaceAll('_', ' ')}" /></span>
                    </div>

                  </a>
                </li>
              </c:forEach>
            </ul>
          </c:otherwise>
        </c:choose>

      </div>

      <div class="column">

        <div class="buttons">
          <a href="${pageContext.request.contextPath}/issues/new" class="button wide">New Issue</a>
        </div>

      </div>

    </div>
  </jsp:body>
</t:application>