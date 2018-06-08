<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:application>
  <jsp:attribute name="title">KnowledgeBase</jsp:attribute>
  <jsp:body>

    <%-- Header --%>
    <div class="wrapper">
      <h1 class="has-subtitle">Knowledgebase</h1>
      <p class="subtitle">Here you can view Knowledgebase Articles.</p>
    </div>

    <%-- Search bar to search through knowledgebase articles --%>


    <%-- Main Content --%>
    <%--<jsp:include page="_form.jsp"/>--%>
    <div class="column-wrapper">

      <div class="column border">


        <c:choose>
          <c:when test="${articles.isEmpty()}">
            <%-- TODO Improve this empty state --%>
            There's nothing here!
          </c:when>
          <c:otherwise>
            <ul class="issue-list">
              <c:forEach items="${articles}" var="article">
                <li class="issue">
                  <a href="${pageContext.request.contextPath}/articles/${article.id}">

                      <%-- Title --%>
                    <p class="title">
                      <c:out value="${article.title}"/>
                    </p>

                    <p class="preview">
                      <c:out value="${fn:substring(article.body, 0, 64)}"/>
                    </p>

                    <div class="footer">
                      <p>Rating: <c:out
                          value="${article.helpfulness}"/></p>
                      <span class="badge"><c:out value="${article.category.replaceAll('_',' ')}"/></span>
                      <span class="badge"><c:out value="${article.subCategory.replaceAll('_',' ')}"/></span>
                    </div>

                  </a>
                </li>
              </c:forEach>
            </ul>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </jsp:body>
</t:application>