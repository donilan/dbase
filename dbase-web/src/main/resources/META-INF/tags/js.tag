<%@ tag dynamic-attributes="dynAttr" body-content="empty"  pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="lib" required="true" description="Javascript lib name." type="java.lang.String" %>
<%@ attribute name="version" required="false" description="Javascript lib version." type="java.lang.String" %>
<%@ attribute name="packaging" description="What package set."  type="java.lang.String" %>
<%@ attribute name="suffix" description="The suffix after js." type="java.lang.String" %>
<script type="text/javascript"
		src="<spring:url value="/resources/js/${lib}${empty version ? '': '-'}${version}${empty packaging ? '': '.'}${packaging }.js${suffix }" />" ></script>