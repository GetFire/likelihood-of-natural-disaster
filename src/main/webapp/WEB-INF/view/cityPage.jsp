<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>City page</title>
</head>
<body>

<h1>
    <button onclick="getGetAndSubmitForm()">Get your forecast</button>
</h1>

<form:form action="/cityApi" modelAttribute="geoForm" method="post" id="geoForm">
    <form:input id="latitude" path="latitude" type="hidden" value="${geoForm.latitude}"/>
    <form:input id="longitude" path="longitude" type="hidden" value="${geoForm.longitude}"/>
</form:form>

<c:if test="${not empty city}">
    <div>
            ${city}
<%--                    <div><spring:message code="timezone" arguments="${city.continentCode}"/> </div>--%>
<%--                    <div><spring:message code="time" arguments="${forecast.time}"/> </div>--%>
<%--                    <div><spring:message code="icon" arguments="${forecast.icon}"/> </div>--%>
<%--                    <div><spring:message code="summary" arguments="${forecast.summary}"/> </div>--%>
<%--                    <div><spring:message code="city" arguments="${forecast.city}"/> </div>--%>
                    <div>${city.continentCode}</div>
                    <div>${city.countryCode}</div>
                    <div>${city.countryName}</div>
                    <div>${city.locality}</div>
                    <div>${city.principalSubdivision}</div>
                    <div>${city.localityLanguageRequested}</div>
                    <div>${city.longitude}</div>
                    <div>${city.latitude}</div>
    </div>
</c:if>

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