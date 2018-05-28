<%@tag description="Standard application layout" pageEncoding="UTF-8" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="bodyClass" fragment="true" %>
<!DOCTYPE html>
<html lang="en-AU">
<head>
  <title><jsp:invoke fragment="title" /> &middot; &#x1F5A5;</title>
  <meta charset="UTF-8"/>
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0, user-scalable=1, maximum-scale: 1.0"/>

  <!-- Fonts and Icons -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Rubik:700">

  <!-- Normalise browser defaults -->
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/static/styles/modern-normalize.css">
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/static/styles/app.min.css"/>
</head>
<body class="<jsp:invoke fragment="bodyClass" />">
  <jsp:doBody/>
</body>
</html>