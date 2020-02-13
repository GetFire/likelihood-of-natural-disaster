<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Some weather</title>
    <link href="css/main.css" rel="stylesheet">
    <script src="js/main.js"></script>

</head>
<body>
<table>
    <c:forEach items="${weather}" var="item">
        <tr>
            <td><c:out value="${item}" /></td>
        </tr>
    </c:forEach>
</table>
<script src="../js/main.js"></script>
</body>
</html>