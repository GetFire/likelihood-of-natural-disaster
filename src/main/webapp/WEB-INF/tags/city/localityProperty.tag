<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="locality" required="true" type="myproject.likelihoodofnaturaldisaster.dto.cityapi.LocalityPropertyDto" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
    <div class="row px-4"><spring:message code="city.adminlevel" arguments="${locality.adminLevel}"/></div>
    <div class="row px-4"><spring:message code="city.order" arguments="${locality.order}"/></div>
    <div class="row px-4"><spring:message code="city.name" arguments="${locality.name}"/></div>
    <div class="row px-4"><spring:message code="city.description" arguments="${locality.description}"/></div>
    <div class="row px-4"><spring:message code="city.isoCode" arguments="${locality.isoCode}"/></div>
    <div class="row px-4"><spring:message code="city.isoName" arguments="${locality.isoName}"/></div>
</div>

