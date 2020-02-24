<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>GeoPage</title>
</head>
<body>

<h1>
    <button onclick="getGetAndSubmitForm()">Get your forecast</button>
</h1>

<p>Click the button to get your coordinates.</p>

<button onclick="getLocation()">Try It</button>

<p id="demo"></p>

<form:form action="/geo" modelAttribute="geoForm" method="post" id="geoForm">
    <form:input id="latitude" path="latitude" type="hidden" value="${geoForm.latitude}"/>
    <form:input id="longitude" path="longitude" type="hidden" value="${geoForm.longitude}"/>
</form:form>

<c:if test="${not empty forecast}">
    <div>
            ${forecast}
        <div><spring:message code="timezone" arguments="${forecast.timezone}"/> </div>
        <div><spring:message code="time" arguments="${forecast.time}"/> </div>
        <div><spring:message code="icon" arguments="${forecast.icon}"/> </div>
        <div><spring:message code="summary" arguments="${forecast.summary}"/> </div>
        <div>${forecast.cloudCover}</div>
        <div>${forecast.humidity}</div>
        <div>${forecast.nearestStormDistance}</div>
        <div>${forecast.windSpeed}</div>
    </div>
</c:if>


<div>
    ${forecast}
    <%--    <div>${forecast.getTimezone}</div>--%>
    <div>${forecast.timezone}</div>
    <div>${forecast.time}</div>
    <div>${forecast.icon}</div>
    <div>${forecast.summary}</div>
    <div>${forecast.sunriseTime}</div>
    <div>${forecast.sunsetTime}</div>
    <div>${forecast.temperatureMinTime}</div>
    <div>${forecast.temperatureMaxTime}</div>
    <div>${forecast.precipType}</div>
    <div>${forecast.apparentTemperatureMinTime}</div>
    <div>${forecast.apparentTemperatureMaxTime}</div>
    <div>${forecast.precipIntensity}</div>
    <div>${forecast.cloudCover}</div>
    <div>${forecast.humidity}</div>
    <div>${forecast.nearestStormDistance}</div>
    <div>${forecast.precipAccumulation}</div>
    <div>${forecast.pressure}</div>
    <div>${forecast.visibility}</div>
    <div>${forecast.windSpeed}</div>
        <div>${city.latitude()}</div>
        <div>${city.longitude()}</div>
        <div>${city.coordinates()}</div>
        <div>${city.hasAltitude()}</div>
        <div>${city.toString()}</div>
<%--        <div>${city2.cancelBatchCall()}</div>--%>
<%--        <div>${city2.cancelCall()}</div>--%>
<%--        <div>${city2.callFactory}</div>--%>


    <%--    <div>${city.toJson()}</div>--%>
<%--        <div>${city.altitude()}</div>--%>
<%--        <div>${city.coordinates()}</div>--%>
<%--        <div>${city.type()}</div>--%>
<%--        <div>${city2.}</div>--%>

<%--        <div>${city2}</div>--%>





</div>


<%--<button onclick="getGetAndSubmitForm()">get geo</button>--%>

<%--<button onclick="getLocation()">get geo 2</button>--%>

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
        if (navigator.geolocation){
            navigator.geolocation.getCurrentPosition(submitGeoFormInternally);
        } else {
            window.alert( "Geolocation is not supported by this browser.")
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