<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="city" tagdir="/WEB-INF/tags/city" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<html>
<head>
    <title>City page</title>

    <link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>

<h1>
    <div class="col-md-4 text-center">
        <button type="button" class="btn btn-info btn-lg" onclick="getGetAndSubmitForm()">Get your forecast</button>
    </div>
</h1>

<form:form action="/cityApi" modelAttribute="geoForm" method="post" id="geoForm">
    <form:input id="latitude" path="latitude" type="hidden" value="${geoForm.latitude}"/>
    <form:input id="longitude" path="longitude" type="hidden" value="${geoForm.longitude}"/>
</form:form>

<div class="container">
    <city:city city="${city}"/>
</div>


<script>
    var x = document.getElementById("demo");
    let form = document.getElementById("geoForm");
    let latitude = document.getElementById("latitude");
    let longitude = document.getElementById("longitude");

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);
        } else {
            x.innerHTML = "Geolocation is not supported by this browser.";
        }
    }

    function showPosition(position) {
        console.log(position);
        x.innerHTML = "Latitude: " + position.coords.latitude +
            "<br>Longitude: " + position.coords.longitude;
    }

    function getGetAndSubmitForm() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(submitGeoFormInternally);
        } else {
            window.alert("Geolocation is not supported by this browser.")
        }
    }

    function submitGeoFormInternally(position) {
        console.log(position);
        latitude.value = position.coords.latitude;
        longitude.value = position.coords.longitude;
        form.submit();
    }
</script>
</body>
</html>