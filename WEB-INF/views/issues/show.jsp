<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:application>
  <jsp:attribute name="title"><c:out value="${issue.title}"/></jsp:attribute>
  <jsp:body>

    <c:set var="author" value="${issue.getAuthor()}"/>

    <div class="wrapper issue-header">
      <div>

          <%-- Title --%>
        <h1 class="issue-title">
          <c:if test="${issue.isLocked()}">
            <i class="material-icons">lock</i>
          </c:if>
          <span><c:out value="${issue.title}"/></span>
        </h1>

          <%-- Description --%>
        <div class="issue-description">
          <span class="badge"><c:out value="${issue.state.replaceAll('_', ' ')}"/></span>
          <span>Opened by <c:out value="${author.getFullName()}"/> &middot;
            Last updated: <fmt:formatDate pattern="h:mma MMM dd, yyyy"
                                          value="${issue.getUpdatedAt()}"/></span>
        </div>

      </div>

      <c:if test="${requestScope.currentUser.getId() == author.getId()}">
        <div class="buttons">
          <a href="${pageContext.request.contextPath}/issues/${issue.id}/edit"
             class="button-secondary">
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
          <p><c:out value="${issue.body}"/></p>
          <div class="badges">
            <span class="badge"><c:out value="${issue.category.replaceAll('_', ' ')}"/></span>
            <span class="badge"><c:out value="${issue.subCategory.replaceAll('_', ' ')}"/></span>
          </div>
        </div>

          <%-- All comments --%>
        <ul class="issue-comments">
          <c:set var="comments" value="${issue.getComments()}"/>
          <c:choose>
            <c:when test="${comments.isEmpty()}">
              <p class="empty-state">No one has commented on this issue yet. Be the first to join
                the discussion below.</p>
            </c:when>
            <c:otherwise>
              <c:forEach items="${comments}" var="comment">
                <c:set var="author" value="${comment.getAuthor()}"/>
                <li class='comment ${comment.getId() == issue.getAnswerId() ? "answer":""}'>
                  <div class="content">

                      <%-- Add staff response header if necessary --%>
                    <c:if test="${author.getRole() == 'IT_STAFF'}">
                      <p class="staff-title">
                        <i class="material-icons">verified_user</i>
                        <span>Staff Response</span>
                      </p>
                    </c:if>

                      <%-- Print body --%>
                    <p>
                      <c:choose>
                        <c:when test="${comment.getId() == issue.getAnswerId()}">
                          <i class="material-icons">
                            check
                          </i>
                          <div>
                            <c:out value="${comment.body}"/>
                          </div>
                         </c:when>
                         <c:otherwise>
                           <c:out value="${comment.body}"/>
                         </c:otherwise>
                      </c:choose>
                    </p>


                    <p class="footer">
                      <span>By <c:out value="${author.getFullName()}"/></span>
                      <span>at <fmt:formatDate pattern="h:mma MMM dd, yyyy"
                                               value="${issue.getUpdatedAt()}"/></span>
                      <c:if
                          test="${author.getRole() == 'IT_STAFF' && requestScope.currentUser.getRole() == 'USER' && !issue.isLocked()}">
                        <span>
                          &middot; <a
                            href="${pageContext.request.contextPath}/issues/${issue.getId()}/approval"
                            data-params='{"commentId": "${comment.getId()}"}' data-method="POST"
                            class="resolve-link">This resolved my problem</a>
                        </span>
                      </c:if>
                    </p>
                  </div>
                </li>
              </c:forEach>
            </c:otherwise>
          </c:choose>
        </ul>

        <c:choose>
          <c:when test="${issue.isLocked()}">
            <p class="empty-state" style="margin-top: 2rem;">Sorry, this issue is locked.</p>
          </c:when>
          <c:otherwise>
            <%-- Comment box --%>
            <form action="${pageContext.request.contextPath}/comments/${issue.getId()}"
                  class="comment-box" method="POST">
              <input name="utf8" value="✓" type="hidden"/>

              <div class="field">
                <label>Comment</label><br/>
                <textarea autofocus name="comment"></textarea>
              </div>

              <div class="buttons">
                <input type="submit" value="Comment" class="button">
              </div>

            </form>
          </c:otherwise>
        </c:choose>

      </div>

      <div class="column">
        <c:if test="${requestScope.errors != null}">
          <div class="errors">
            <p>The following errors prevented you from completing this action.</p>
            <ul>
              <c:forEach var="error" items="${requestScope.errors}">
                <li><p><c:out value="${error}" /></p></li>
              </c:forEach>
            </ul>
          </div>
        </c:if>

        <c:choose>
          <c:when test='${requestScope.currentUser.getRole() == "IT_STAFF" && !issue.getState().equals("COMPLETED")}'>
            <%-- Mark as completed --%>
            <div class="buttons">
              <a href="${pageContext.request.contextPath}/issues/${issue.getId()}/mark-complete" data-method="POST" class="button wide">
                <i class="material-icons">check</i>
                <span>Mark as complete</span>
              </a>
            </div>
          </c:when>
          <c:when test='${requestScope.currentUser.getRole() == "IT_STAFF" && issue.getState().equals("COMPLETED")}'>
            <div class="buttons">
              <c:choose>
                <c:when test="${issue.getAnswerId() != null}">
                  <%-- Publish --%>
                  <a href="${pageContext.request.contextPath}/articles" data-method="POST" data-params='{"issueId": "${issue.getId()}"}' class="button wide">
                    <i class="material-icons">save_alt</i>
                    <span>Publish to Knowledgebase</span>
                  </a>
                </c:when>
                <c:otherwise>
                  <p class="empty-state" style="margin: 0.5rem;">You cannot publish this issue to the knowledgebase because it doesn't have an accepted answer.</p>
                </c:otherwise>
              </c:choose>

              <a href="${pageContext.request.contextPath}/issues/${issue.getId()}/unmark-complete" data-method="POST" class="button-secondary wide">
                <i class="material-icons">lock_open</i>
                <span>Reopen this issue</span>
              </a>
            </div>
          </c:when>
        </c:choose>
      </div>

    </div>

  </jsp:body>
</t:application>