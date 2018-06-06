<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:application>
    <jsp:attribute name="title">Maintenance</jsp:attribute>
    <jsp:body>

        <%-- Header --%>
        <div class="">
            <h1>New Maintenance Events</h1>
            <p class="">Enter in the data of the new Maintenance Event.</p>
        </div>

        <%-- Form --%>
        <jsp:include page="_form.jsp"/>

    </jsp:body>
</t:application>