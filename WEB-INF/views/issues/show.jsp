<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:application>
  <jsp:attribute name="title"><c:out value="${issue.title}" /></jsp:attribute>
  <jsp:body>

    <div class="wrapper">
      <h1 class="issue-title"><c:out value="${issue.title}" /></h1>
      <div class="issue-description">
        <span class="badge"><c:out value="${issue.state.replaceAll('_', ' ')}" /></span>
        <span>Opened by <c:out value="${issue.getAuthor().getFullName()}" /></span>
      </div>
    </div>

    <div class="column-wrapper">

      <div class="column">

        <%-- Issue description --%>
        <div class="issue-body">
          <p><c:out value="${issue.body}" /></p>
          <div class="badges">
            <span class="badge"><c:out value="${issue.category.replaceAll('_', ' ')}" /></span>
            <span class="badge"><c:out value="${issue.subCategory.replaceAll('_', ' ')}" /></span>
          </div>
        </div>

        <%-- All comments --%>
        <div class="issue-comments">
          <c:choose>
            <c:when test="true"></c:when>
            <c:otherwise>

            </c:otherwise>
          </c:choose>
        </div>

        <%-- Comment box --%>
        <form action="${pageContext.request.contextPath}/comments/${issue.getId()}" class="comment-box" method="POST">
          <input name="utf8" value="✓" type="hidden" />

          <div class="field">
            <label>Comment</label>
            <textarea placeholder="Hello"></textarea>
          </div>

          <div class="buttons">
            <input type="submit" value="Comment" class="button">
          </div>

        </form>

      </div>

    </div>

  </jsp:body>
</t:application>