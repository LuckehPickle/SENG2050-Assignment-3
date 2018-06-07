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



                    <%-- General Article Structure
                <a href="" class="article-container">
                    <div>

                        <span>Title</span>

                        <p>Question Preview...</p>
                    </div>
                </a>--%>

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
                                            <p>Posted by <c:out
                                                    value="${article.helpfulness}"/></p>
                                            <%--<p>Posted by <c:out
                                                    value="${article.published}"/></p>
                                            <p>Posted by <c:out
                                                    value="${article.updated}"/></p>--%>
                                        </div>

                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="buttons">
            <a href="" class="button">Previous Page</a>
            <a href="" class="button">Next Page</a>
        </div>
    </jsp:body>
</t:application>