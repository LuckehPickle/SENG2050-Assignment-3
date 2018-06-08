<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
            <p class="empty-state">There are no articles in this category.
              <i class="material-icons">
                sentiment_very_dissatisfied
              </i>
            </p>
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
                      <p>Rating: <c:out value="${article.helpfulness}"/> &middot;
                        Last updated:
                        <fmt:formatDate pattern="dd/MM/yyyy" value="${article.updatedAt}"/></p>
                      <span class="badge"><c:out
                          value="${article.category.replaceAll('_',' ')}"/></span>
                      <span class="badge"><c:out
                          value="${article.subCategory.replaceAll('_',' ')}"/></span>
                    </div>
                  </a>
                </li>
              </c:forEach>
            </ul>
          </c:otherwise>
        </c:choose>
      </div>
      <div class="column">
        <div class="accordion">
            <%-- Network --%>
          <div>
            <div class="category">
              <a href="${pageContext.request.contextPath}/articles?category=NETWORK">Network</a>
              <div class="accordion-dropdown">
                <i class="material-icons">arrow_drop_down</i>
              </div>
            </div>
            <ul class="sub-category">
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=NETWORK&subcategory=CANT_CONNECT">Can't
                Connect</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=NETWORK&subcategory=SPEED">Speed</a>
              </li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=NETWORK&subcategory=CONSTANT_DROPOUTS">Constant
                Dropouts</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=NETWORK&subcategory=OTHER">Other</a>
              </li>
            </ul>
          </div>
            <%-- Software --%>
          <div>
            <div class="category">
              <a href="${pageContext.request.contextPath}/articles?category=SOFTWARE">Software</a>
              <div class="accordion-dropdown">
                <i class="material-icons">arrow_drop_down</i>
              </div>
            </div>
            <ul class="sub-category">
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=SOFTWARE&subcategory=SLOW_TO_LOAD">Slow
                to Load</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=SOFTWARE&subcategory=WONT_LOAD">Won't
                Load At All</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=SOFTWARE&subcategory=OTHER">Other</a>
              </li>
            </ul>
          </div>
            <%-- Hardware--%>
          <div>
            <div class="category">
              <a href="${pageContext.request.contextPath}/articles?category=HARDWARE">Hardware</a>
              <div class="accordion-dropdown">
                <i class="material-icons">arrow_drop_down</i>
              </div>
            </div>
            <ul class="sub-category">
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=HARDWARE&subcategory=WONT_BOOT">Computer
                Won't Turn On</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=HARDWARE&subcategory=BLUE_SCREEN">Computer
                "Blue Screens"</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=HARDWARE&subcategory=DISK_DRIVE">Disk
                Drive</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=HARDWARE&subcategory=PERIPHERALS">Peripherals</a>
              </li>
              <li><a href="">Other</a></li>
            </ul>
          </div>
            <%-- Email --%>
          <div>
            <div class="category">
              <a href="${pageContext.request.contextPath}/articles?category=EMAIL">Email</a>
              <div class="accordion-dropdown">
                <i class="material-icons">arrow_drop_down</i>
              </div>
            </div>
            <ul class="sub-category">
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=EMAIL&subcategory=CANT_SEND">Can't
                Send</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=EMAIL&subcategory=CANT_RECEIVE">Can't
                Receive</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=EMAIL&subcategory=SPAM">SPAM/Phishing</a>
              </li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=EMAIL&subcategory=OTHER">Other</a>
              </li>
            </ul>
          </div>
            <%-- Account --%>
          <div>
            <div class="category">
              <a href="${pageContext.request.contextPath}/articles?category=ACCOUNT">Account</a>
              <div class="accordion-dropdown">
                <i class="material-icons">arrow_drop_down</i>
              </div>
            </div>
            <ul class="sub-category">
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=EMAIL&subcategory=PASSWORD_RESET">Password
                Reset</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=EMAIL&subcategory=WRONG_DETAILS">Wrong
                Details</a></li>
              <li><a
                  href="${pageContext.request.contextPath}/articles?category=EMAIL&subcategory=OTHER">Other</a>
              </li>
            </ul>
          </div>
            <%-- Other --%>
          <div>
            <div class="category">
              <a href="${pageContext.request.contextPath}/articles?category=OTHER">Other</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </jsp:body>
</t:application>