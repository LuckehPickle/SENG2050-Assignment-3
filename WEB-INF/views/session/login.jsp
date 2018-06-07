<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:application>
  <jsp:attribute name="title">"Secure" Login</jsp:attribute>
  <jsp:attribute name="bodyClass">auth</jsp:attribute>
  <jsp:body>
    <div class="wrapper auth-wrapper">

      <%-- Header --%>
      <div class="form-header">
        <h1>Secure Login</h1>
        <p class="subtitle">Please enter your account details below.</p>
      </div>

      <%-- Login form --%>
      <form action="${pageContext.request.contextPath}/session" method="POST"
            accept-charset="UTF-8">
        <input name="utf8" value="✓" type="hidden"/>
        <c:if test="${requestScope.message != null}">
          <div class="error">
            <p><c:out value="${requestScope.message}"/></p>
          </div>
        </c:if>

        <%-- Username --%>
        <div class="field">
          <label for="username">Username</label><br/>
          <input type="text" id="username" name="username" spellcheck="false" class="wide"
                 placeholder="e.g. seanbailey" autofocus/>
        </div>

        <%-- Password --%>
        <div class="field">
          <label for="password">Password</label><br/>
          <input type="password" id="password" name="password" spellcheck="false" class="wide"/>
        </div>

        <hr/>

        <%-- Submit --%>
        <div class="buttons">
          <input type="submit" value="Login" class="button wide">
        </div>

      </form>

    </div>
  </jsp:body>
</t:application>