<%@ tag dynamic-attributes="dynAttr" body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="name" required="true" description="Name of menu" type="java.lang.String" %>
<%@ attribute name="href" description="This attribute will use spring url tag." type="java.lang.String" %>
<spring:url value="${href }" var="hrefTmp" />
<li class="menu-item">
	<a href="${empty href ? '###': hrefTmp }" >${name }</a>
</li>