<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:application>
    <jsp:attribute name="title">Maintenance</jsp:attribute>
    <jsp:body>

        <%-- Header --%>
        <div class="">
            <h1>Maintenance Events</h1>
            <p class="">Here you can create and edit maintenance events regarding your page.</p>
        </div>

        <%-- Main Content --%>
        <%-- Button/Link to Access create New Maintenance Event --%>
        <a href="${pageContext.request.contextPath}/maintenance/new" class="button">New maintenance event</a>

        <%-- Loads up each event in the database and displays event descriptor: Event(Button) Event Date(String/Date) Event Time(String/Time) --%>
        <p>Event Name</p>
        <p>Event Date</p>
        <p>Event Time</p>
    </jsp:body>
</t:application>