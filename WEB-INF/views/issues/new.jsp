<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:application>
  <jsp:attribute name="title">New Issue</jsp:attribute>
  <jsp:body>

    <%-- Header --%>
    <div class="wrapper">
      <h1 class="has-subtitle">New Issue</h1>
      <p class="subtitle">Report an issue you've been experiencing. Be sure to explain your problem adequately.</p>
    </div>

    <div class="column-wrapper">

      <form action="${pageContext.request.contextPath}/issues" method="POST" accept-charset="UTF-8" class="issue-form">
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

        <%-- Title --%>
        <div class="field">
          <label for="issue-title">Short Title</label><br/>
          <input type="text" name="title" required id="issue-title" autofocus="autofocus" placeholder="e.g. I can't find my keys" />
        </div>

          <%-- Category --%>
        <div class="field">
          <label for="issue-category">Category</label><br/>
          <select id="issue-category" name="category" class="category-select">
            <option value="NETWORK">Network</option>
            <option value="SOFTWARE">Software</option>
            <option value="HARDWARE">Hardware</option>
            <option value="EMAIL">Email</option>
            <option value="ACCOUNT">Account</option>
            <option value="OTHER">Other</option>
          </select>
        </div>

          <%-- Subcategory --%>
        <div class="field subcategory-wrapper">
          <label for="issue-subcategory">Subcategory</label><br/>

            <%-- Network --%>
          <select id="issue-subcategory" name="subCategory" class="network">
            <option value="CANT_CONNECT">Can't connect</option>
            <option value="SPEED">Speed</option>
            <option value="CONSTANT_DROPOUTS">Constant dropouts</option>
            <option value="OTHER">Other</option>
          </select>

            <%-- Software --%>
          <select id="issue-subcategory" name="subCategory" class="software">
            <option value="SLOW_TO_LOAD">Slow to load</option>
            <option value="WONT_LOAD">Won't load</option>
            <option value="OTHER">Other</option>
          </select>

            <%-- Hardware --%>
          <select id="issue-subcategory" name="subCategory" class="hardware">
            <option value="WONT_BOOT">Computer won't turn on</option>
            <option value="BLUE_SCREEN">Computer blue screens</option>
            <option value="DISK_DRIVE">Disk drive</option>
            <option value="PERIPHERALS">Peripherals</option>
            <option value="OTHER">Other</option>
          </select>

            <%-- Email --%>
          <select id="issue-subcategory" name="subCategory" class="email">
            <option value="CANT_SEND">Can't send</option>
            <option value="CANT_RECEIVE">Can't receive</option>
            <option value="SPAM">Spam/Phishing</option>
            <option value="OTHER">Other</option>
          </select>

            <%-- Account --%>
          <select id="issue-subcategory" name="subCategory" class="account">
            <option value="PASSWORD_RESET">Password reset</option>
            <option value="WRONG_DETAILS">Wrong details</option>
            <option value="OTHER">Other</option>
          </select>

        </div>

        <%-- Description --%>
        <div class="field">
          <label for="issue-body">Full Description</label><br/>
          <textarea id="issue-body" name="body" required placeholder="Please be as descriptive as possible"></textarea>
        </div>

        <%-- Submit --%>
        <div class="buttons">
          <input type="submit" value="Create event" class="button" />
          <a href="${pageContext.request.contextPath}/issues" class="button-tertiary">Cancel</a>
        </div>

      </form>

    </div>
  </jsp:body>
</t:application>