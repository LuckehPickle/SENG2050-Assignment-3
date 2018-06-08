<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:application>
  <jsp:attribute name="title"><c:out value="${issue.title}" /></jsp:attribute>
  <jsp:body>

    <c:set var="author" value="${issue.getAuthor()}" />

    <div class="wrapper issue-header">
      <div>
        <h1 class="issue-title"><c:out value="${issue.title}" /></h1>
        <div class="issue-description">
          <span class="badge"><c:out value="${issue.state.replaceAll('_', ' ')}" /></span>
          <span>Opened by <c:out value="${author.getFullName()}" /> &middot;
            Last updated: <fmt:formatDate pattern="h:mma MMM dd, yyyy" value="${issue.getUpdatedAt()}" /></span>
        </div>
      </div>

      <c:if test="${requestScope.currentUser.getId() == author.getId()}">
        <div class="buttons">
          <a href="${pageContext.request.contextPath}/issues/${issue.id}/edit" class="button-secondary">
            <i class="material-icons">edit</i>
            <span>Edit Issue</span>
          </a>
        </div>
      </c:if>
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
        <ul class="issue-comments">
          <c:set var="comments" value="${issue.getComments()}" />
          <c:choose>
            <c:when test="${comments.isEmpty()}">
              <p class="empty-state">No one has commented on this issue yet. Be the first to join the discussion below.</p>
            </c:when>
            <c:otherwise>
              <c:forEach items="${comments}" var="comment">
                <c:set var="author" value="${comment.getAuthor()}" />
                <li class="comment ${author.getRole() == 'IT_STAFF' ? 'staff' : ''}">
                  <div class="content">
                    <c:if test="${author.getRole() == 'IT_STAFF'}">
                      <p class="staff-title">
                        <i class="material-icons">verified_user</i>
                        <span>Staff response:</span>
                      </p>
                    </c:if>
                    <p><c:out value="${comment.body}" /></p>
                    <p class="footer">
                      By <c:out value="${author.getFullName()}" /> at <fmt:formatDate pattern="h:mma MMM dd, yyyy" value="${issue.getUpdatedAt()}" />
                    </p>
                  </div>
                </li>
              </c:forEach>
            </c:otherwise>
          </c:choose>
        </ul>

        <%-- Comment box --%>
        <form action="${pageContext.request.contextPath}/comments/${issue.getId()}" class="comment-box" method="POST">
          <input name="utf8" value="✓" type="hidden" />

          <div class="field">
            <label>Comment</label><br />
            <textarea autofocus name="comment"></textarea>
          </div>

          <div class="buttons">
            <input type="submit" value="Comment" class="button">
          </div>

        </form>

      </div>

    </div>

  </jsp:body>
</t:application>