<%@ tag dynamic-attributes="dynAttr" body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="file" required="true" description="Css file name." type="java.lang.String" %>
<%@ attribute name="version" required="false" description="Css file version." type="java.lang.String" %>
<%@ attribute name="packaging" description="What package set."  type="java.lang.String" %>
<%@ attribute name="suffix" description="The suffix after js." type="java.lang.String" %>
<link rel="stylesheet" type="text/css"
		href="<spring:url value="/resources/css/${file}${empty version ? '': '-'}${version}${empty packaging ? '': '.'}${packaging }.css${suffix }" />">