<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="city" required="true" type="myproject.likelihoodofnaturaldisaster.dto.cityapi.CityApiDto" %>
<%@ taglib prefix="city" tagdir="/WEB-INF/tags/city" %>


<c:if test="${not empty city}">
    <div>
        <div class="row p-1">continentCode: ${city.continentCode}</div>
        <div class="row p-1">countryCode: ${city.countryCode}</div>
        <div class="row p-1">countryName: ${city.countryName}</div>
        <div class="row p-1">locality: ${city.locality}</div>
        <div class="row p-1">principalSubdivision: ${city.principalSubdivision}</div>
        <div class="row p-1">localityLanguageRequested: ${city.localityLanguageRequested}</div>
        <div class="row p-1">longitude: ${city.longitude}</div>
        <div class="row p-1">latitude: ${city.latitude}</div>

        <c:if test="${not empty city.localityInfo.administrative}">
            <c:forEach items="${city.localityInfo.administrative}" var="info">
                <city:localityProperty locality="${info}"/>
            </c:forEach>
        </c:if>

        <c:if test="${not empty city.localityInfo.informative}">
            <c:forEach items="${city.localityInfo.informative}" var="info">
                <city:localityProperty locality="${info}"/>
            </c:forEach>
        </c:if>
    </div>
</c:if>


