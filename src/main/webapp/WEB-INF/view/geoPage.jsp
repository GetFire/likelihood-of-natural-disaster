<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>GeoPage</title>
</head>
<body>

<c:if test="${not empty geoForm.latitude}">
    <h1>latitude: ${geoForm.latitude}</h1>
    <h1>longitude:${geoForm.longitude}</h1>
</c:if>

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

<div>
    ${forecast}
    <div>${forecast.getTimezone}</div>
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
