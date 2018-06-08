<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:application>
    <jsp:attribute name="title">Edit Issue</jsp:attribute>
    <jsp:body>

        <%-- Header --%>
        <div class="wrapper">
            <h1 class="has-subtitle">Edit Issue</h1>
        </div>

        <div class="column-wrapper">

            <form action="${pageContext.request.contextPath}/issues/${issue.id}" method="POST" accept-charset="UTF-8" class="issue-form">
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
                    <input type="text" name="title" required id="issue-title" autofocus="autofocus" placeholder="e.g. I can't find my keys" value="${issue.title}"/>
                </div>

                    <%-- Category --%>
                <div class="field">
                    <label for="issue-category">Category</label><br/>
                    <select id="issue-category" name="category" class="category-select">
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("NETWORK")}'>
                                <option selected value="NETWORK">Network</option>
                            </c:when>
                            <c:otherwise>
                                <option value="NETWORK">Network</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("SOFTWARE")}'>
                                <option selected value="SOFTWARE">Software</option>
                            </c:when>
                            <c:otherwise>
                                <option value="SOFTWARE">Software</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("HARDWARE")}'>
                                <option selected value="HARDWARE">Hardware</option>
                            </c:when>
                            <c:otherwise>
                                <option value="HARDWARE">Hardware</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("EMAIL")}'>
                                <option selected value="EMAIL">Email</option>
                            </c:when>
                            <c:otherwise>
                                <option value="EMAIL">Email</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("ACCOUNT")}'>
                                <option selected value="ACCOUNT">Account</option>
                            </c:when>
                            <c:otherwise>
                                <option value="ACCOUNT">Account</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("OTHER")}'>
                                <option selected value="OTHER">Other</option>
                            </c:when>
                            <c:otherwise>
                                <option value="OTHER">Other</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>

                    <%-- Subcategory --%>
                <div class="field subcategory-wrapper">
                    <label for="issue-subcategory">Subcategory</label><br/>

                        <%-- Network --%>
                    <select id="issue-subcategory" name="subCategory" class="network">
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("CANT_CONNECT")}'>
                                <option selected value="CANT_CONNECT">Can't connect</option>
                            </c:when>
                            <c:otherwise>
                                <option value="CANT_CONNECT">Can't connect</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("SPEED")}'>
                                <option selected value="SPEED">Speed</option>
                            </c:when>
                            <c:otherwise>
                                <option value="SPEED">Speed</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("CONSTANT_DROPOUTS")}'>
                                <option selected value="CONSTANT_DROPOUTS">Constant dropouts</option>
                            </c:when>
                            <c:otherwise>
                                <option value="CONSTANT_DROPOUTS">Constant dropouts</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("OTHER")}'>
                                <option selected value="OTHER">Other</option>
                            </c:when>
                            <c:otherwise>
                                <option value="OTHER">Other</option>
                            </c:otherwise>
                        </c:choose>
                    </select>

                        <%-- Software --%>
                    <select id="issue-subcategory" name="subCategory" class="software">
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("SLOW_TO_LOAD")}'>
                                <option selected value="SLOW_TO_LOAD">Slow to load</option>
                            </c:when>
                            <c:otherwise>
                                <option value="SLOW_TO_LOAD">Slow to load</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("WONT_LOAD")}'>
                                <option selected value="WONT_LOAD">Won't load</option>
                            </c:when>
                            <c:otherwise>
                                <option value="WONT_LOAD">Won't load</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("OTHER")}'>
                                <option selected value="OTHER">Other</option>
                            </c:when>
                            <c:otherwise>
                                <option value="OTHER">Other</option>
                            </c:otherwise>
                        </c:choose>
                    </select>

                        <%-- Hardware --%>
                    <select id="issue-subcategory" name="subCategory" class="hardware">
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("WONT_BOOT")}'>
                                <option selected value="WONT_BOOT">Computer won't turn on</option>
                            </c:when>
                            <c:otherwise>
                                <option value="WONT_BOOT">Computer won't turn on</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("BLUE_SCREEN")}'>
                                <option selected value="BLUE_SCREEN">Computer blue screens</option>
                            </c:when>
                            <c:otherwise>
                                <option value="BLUE_SCREEN">Computer blue screens</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("DISK_DRIVE")}'>
                                <option value="DISK_DRIVE">Disk drive</option>
                            </c:when>
                            <c:otherwise>
                                <option value="DISK_DRIVE">Disk drive</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("PERIPHERALS")}'>
                                <option selected value="PERIPHERALS">Peripherals</option>
                            </c:when>
                            <c:otherwise>
                                <option value="PERIPHERALS">Peripherals</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("OTHER")}'>
                                <option selected value="OTHER">Other</option>
                            </c:when>
                            <c:otherwise>
                                <option value="OTHER">Other</option>
                            </c:otherwise>
                        </c:choose>z
                    </select>

                        <%-- Email --%>
                    <select id="issue-subcategory" name="subCategory" class="email">
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("OTHER")}'>
                                <option selected value="CANT_SEND">Can't send</option>
                            </c:when>
                            <c:otherwise>
                                <option value="CANT_SEND">Can't send</option>
                            </c:otherwise>
                        </c:choose>z
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("CANT_RECEIVE")}'>
                                <option selected value="CANT_RECEIVE">Can't receive</option>
                            </c:when>
                            <c:otherwise>
                                <option value="CANT_RECEIVE">Can't receive</option>
                            </c:otherwise>
                        </c:choose>z
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("SPAM")}'>
                                <option selected value="SPAM">Spam/Phishing</option>
                            </c:when>
                            <c:otherwise>
                                <option value="SPAM">Spam/Phishing</option>
                            </c:otherwise>
                        </c:choose>z
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("OTHER")}'>
                                <option selected value="OTHER">Other</option>
                            </c:when>
                            <c:otherwise>
                                <option value="OTHER">Other</option>
                            </c:otherwise>
                        </c:choose>z
                    </select>

                        <%-- Account --%>
                    <select id="issue-subcategory" name="subCategory" class="account">
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("PASSWORD_RESET")}'>
                                <option selected value="PASSWORD_RESET">Password reset</option>
                            </c:when>
                            <c:otherwise>
                                <option value="PASSWORD_RESET">Password reset</option>
                            </c:otherwise>
                        </c:choose>z
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("WRONG_DETAILS")}'>
                                <option selected value="WRONG_DETAILS">Wrong details</option>
                            </c:when>
                            <c:otherwise>
                                <option value="WRONG_DETAILS">Wrong details</option>
                            </c:otherwise>
                        </c:choose>z
                        <c:choose>
                            <c:when test='${issue.getCategory().equals("OTHER")}'>
                                <option selected value="CANT_SEND">Can't send</option>
                            </c:when>
                            <c:otherwise>
                                <option value="CANT_SEND">Can't send</option>
                            </c:otherwise>
                        </c:choose>z
                    </select>

                </div>

                    <%-- Description --%>
                <div class="field">
                    <label for="issue-body">Full Description</label><br/>
                    <textarea id="issue-body" name="body" required placeholder="Please be as descriptive as possible">${issue.body}</textarea>
                </div>

                    <%-- Submit --%>
                <div class="buttons">
                    <input type="submit" value="Edit event" class="button" />
                    <a href="${pageContext.request.contextPath}/issues" class="button-tertiary">Cancel</a>
                </div>

            </form>
        </div>
    </jsp:body>
</t:application>