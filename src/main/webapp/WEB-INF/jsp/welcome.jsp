<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter data</title>
</head>
<body>
<form action="welcome.jsp" method="GET">
    First: <input type="text" name="first">
    <br/>
    Second: <input type="text" name="second"/>
    <input type="submit" value="Submit"/>

    <p><button onclick="geoFindMe()">Show my location</button></p>
    <div id="out"></div>
</form>
</body>
</html>
