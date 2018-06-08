<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:application>
    <jsp:attribute name="title">Maintenance</jsp:attribute>
    <jsp:body>

        <%-- Header --%>
        <div class="wrapper">
            <h1>Edit Maintenance Events</h1>
            <p class="">Enter data to edit this Maintenance Event.</p>
        </div>



        <%-- Form --%>
        <div class="column-wrapper">


            <form action="${pageContext.request.contextPath}/maintenance/${event.id}" method="POST"
                  accept-charset="UTF-8">
                <input name="utf8" value="✓" type="hidden"/>

                <c:if test="${requestScope.errors != null}">
                    <div class="error">
                        <p>The following errors prevented this issue from being saved.</p>
                        <ul>
                            <c:forEach items="${requestScope.errors}" var="error">
                                <li><c:out value="${error}" /></li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>

                    <%-- Event Name --%>
                <div class="field">
                    <label for="eventName">Event Name</label><br/>
                    <input type="text" id="eventName" name="eventName" spellcheck="false"
                           class="wide" value="${event.title}"
                           placeholder="e.g. Site Wide Maintenance" autofocus/>
                </div>

                    <%-- Event Summary
                    <div class="field">
                        <label for="eventSummary">Event Summary</label><br/>
                        <input type="text" id="eventSummary" name="eventSummary" spellcheck="false" class="wide"
                               placeholder="e.g. Event Details..." autofocus/>
                    </div>--%>

                    <%-- Event Date --%>
                <div class="field">
                    <label for="eventDate">Event Start</label><br/>
                    <input type="date" id="eventDate" name="eventDate" class="wide"
                           value = "${event.startAt}" autofocus/>
                </div>
                    <%-- Event End --%>
                <div class="field">
                    <label for="eventEnd">Event End</label><br/>
                    <input type="date" id="eventEnd" name="eventEnd" class="wide"
                           value = "${event.finishAt}" autofocus/>
                </div>

                <hr/>


                <div class="buttons">
                        <%-- Submit --%>
                    <input type="submit" value="Submit" class="button">

                        <%-- Cancel --%>
                    <a href="${pageContext.request.contextPath}/maintenance"
                       class="button-tertiary">Cancel</a>
                </div>

            </form>
        </div>
    </jsp:body>
</t:application>

