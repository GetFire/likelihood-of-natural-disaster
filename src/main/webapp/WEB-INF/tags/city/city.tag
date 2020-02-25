<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="city" required="true" type="myproject.likelihoodofnaturaldisaster.dto.cityapi.CityApiDto" %>
<%@ taglib prefix="city" tagdir="/WEB-INF/tags/city" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<c:if test="${not empty city}">
    <div>
        <div class="row p-1"><spring:message code="city.continentCode" arguments="${city.continentCode}"/></div>
        <div class="row p-1"><spring:message code="city.countryCode" arguments="${city.countryCode}"/></div>
        <div class="row p-1"><spring:message code="city.countryName" arguments="${city.countryName}"/></div>
        <div class="row p-1"><spring:message code="city.locality" arguments="${city.locality}"/></div>
        <div class="row p-1"><spring:message code="city.principalSubdivision" arguments="${city.principalSubdivision}"/></div>
        <div class="row p-1"><spring:message code="city.localityLanguageRequested" arguments="${city.localityLanguageRequested}"/></div>
        <div class="row p-1"><spring:message code="city.longitude" arguments="${city.longitude}"/></div>
        <div class="row p-1"><spring:message code="city.latitude" arguments="${city.latitude}"/></div>

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


