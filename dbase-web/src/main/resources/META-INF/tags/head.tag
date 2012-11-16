<%@ tag dynamic-attributes="dynAttr" body-content="scriptless" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ii2d" uri="http://www.ii2d.com/tags" %>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<script type="text/javascript">
	var contextPath = '<spring:url value="/" />';
	contextPath = contextPath.replace(/;jsessionid.+/, '');
</script>
<jsp:doBody />
</head>