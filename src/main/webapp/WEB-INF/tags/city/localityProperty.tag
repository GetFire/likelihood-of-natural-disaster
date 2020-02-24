<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="locality" required="true" type="myproject.likelihoodofnaturaldisaster.dto.cityapi.LocalityPropertyDto" %>

<div class="container">
    <div class="row px-4">admin level: ${locality.adminLevel}</div>
    <div class="row px-4">order: ${locality.order}</div>
    <div class="row px-4">name: ${locality.name}</div>
    <div class="row px-4">description: ${locality.description}</div>
    <div class="row px-4">isoCode: ${locality.isoCode}</div>
    <div class="row px-4">isoName: ${locality.isoName}</div>
</div>

