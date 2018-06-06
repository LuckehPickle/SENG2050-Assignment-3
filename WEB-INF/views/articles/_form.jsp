<%-- Search bar to search through knowledgebase articles --%>
<form action="${pageContext.request.contextPath}/articles" method="POST"
      accept-charset="UTF-8">
    <input name="utf8" value="✓" type="hidden"/>

    <%-- Category Dropdown Box --%>
    <div class="field">
        <select name="category">
            <option value="account">Account</option>
            <option value="hardware">Hardware</option>
            <option value="email">Email</option>
            <option value="network">Network</option>
            <option value="other">Other</option>
        </select>
    </div>

    <%-- Option Dropdown Box --%>
    <div class="field">
        <select name="option">
            <option value="###">###</option>
        </select>
    </div>

    <%-- Submit(Search) Button --%>
    <div class="buttons">
        <input type="submit" value="Submit" class="button">
    </div>

</form>