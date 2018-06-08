<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:application>
    <jsp:attribute name="title">Maintenance</jsp:attribute>
    <jsp:body>

        <%-- Header --%>
        <div class="wrapper">
            <h1 class="has-subtitle">Maintenance Events</h1>
            <p class="subtitle">Here you can create and edit maintenance events regarding your page.</p>
            <div class="buttons">
                <a href="${pageContext.request.contextPath}/maintenance/new" class="button">New maintenance event</a>
            </div>
        </div>


        <%-- Main Content --%>
        <%-- Button/Link to Access create New Maintenance Event --%>


            <div class="column-wrapper">

                <div class="column border">

                    <c:choose>
                        <c:when test="${events.isEmpty()}">
                            TODO Improve this empty state
                            There's nothing here!
                        </c:when>
                        <c:otherwise>
                            <ul class="issue-list">
                                <c:forEach items="${events}" var="event">
                                    <li class="issue">

                                    <div class="article-body">

                                            <div class="article-question">
                                                <p class="question"><c:out value="${event.title}"/></p>
                                            </div>

                                            <div class="footer">
                                                <p>Starts At: <c:out
                                                        value="${event.startAt}"/></p>
                                                <p>Finish At: <c:out value="${event.finishAt}"/></p>
                                            </div>


                                    </div>
                                    <div class="buttons">
                                        <a href="${pageContext.request.contextPath}/maintenance/${event.id}/edit" class="button">Edit Event</a>
                                    </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:otherwise>
                    </c:choose>
                </div>
            <div class="wrapper">
                <div class="buttons">
                    <a href="" class="button">Previous Page</a>
                    <a href="" class="button">Next Page</a>
                </div>
            </div>
    </jsp:body>
</t:application>