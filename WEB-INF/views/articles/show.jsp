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
                <h2 class="category"><c:out value="${article.category}"/></h2>
                <%-- Subcategory --%>
                <h3 class="date"><c:out value="${article.lastUpdated}"/></h3>
            </div>

            <%-- Question / Answer --%>
            <div class="article-body">

                <div class="article-question">
                    <p class="question"><c:out value="${article.question}"/></p>
                </div>

                <div class="article-answer">
                    <p class="answer"><c:out value="${article.answer}"/></p>
                </div>

            </div>

            <%-- Helpfulness --%>
            <div class="article-helpful">
                <p class="help"><c:out value="${article.helpfulness}"/> found this article helpful.</p>
                <%-- halp button here --%>
            </div>

            <div class="buttons">
                <a href="${pageContext.request.contextPath}/articles" class="button wide">Return</a>
            </div>

        </div>

    </jsp:body>
</t:application>