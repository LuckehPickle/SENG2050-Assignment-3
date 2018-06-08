<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:application>
    <jsp:attribute name="title"><c:out value="${article.title}" /></jsp:attribute>
    <jsp:body>

        <div class="wrapper">

            <%-- Header --%>
            <div class="article-header">
                <h1 class="title"><c:out value="${article.title}"/></h1>
                <span class="badge"><c:out value="${article.category.replaceAll('_',' ')}"/></span>
                <span class="badge"><c:out value="${article.subCategory.replaceAll('_',' ')}"/></span>
                <%--<h3 class="date"><c:out value="${article.lastUpdated}"/></h3>--%>
            </div>

            <%-- Question / Answer --%>
            <div class="article-body">

                <div class="issue-body">
                    <p class="question"><c:out value="${article.body}"/></p>
                    <div class="footer">
                        <p>- Anonymous User</p>
                    </div>
                </div>

                <div class="issue-comments">
                    <p class="answer"><c:out value="${article.answer}"/></p>
                    <div class="footer">
                        <p>- <c:out value="${article.publisher}"/></p>
                    </div>
                </div>

            </div>

            <div class="buttons">

                <a href="${pageContext.request.contextPath}/articles" class="button">Return</a>
            </div>

        <div class="issue-comments">
          <p class="answer"><c:out value="${article.answer}"/></p>
          <div class="footer">
            <p><c:out value="${article.publisher}"/></p>
          </div>
        </div>

      </div>

        <%-- Helpfulness --%>
      <div class="article-helpful">
        <p id="help"><c:out value="${article.helpfulness}"/> found this article helpful.</p>
      </div>

      <div class="buttons">
        <div class="button js-help" data-article-id="${article.id}">This helped!</div>
        <a href="${pageContext.request.contextPath}/articles" class="button">Return</a>
      </div>

    </div>

    <script src="${pageContext.request.contextPath}/static/scripts/help.min.js"></script>
  </jsp:body>
</t:application>