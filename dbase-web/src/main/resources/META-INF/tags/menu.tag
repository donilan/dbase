<%@ tag dynamic-attributes="dynAttr" body-content="scriptless" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="id" required="true" description="Menu div id" type="java.lang.String" %>
<%@ attribute name="cssClass" description="Menu div class" type="java.lang.String" %>
<div id="${id}" class="ii2d-menu menu ${cssClass}">
<ul>
	<jsp:doBody />
</ul>
</div>
<script type="text/javascript">
ddsmoothmenu.init({
	mainmenuid: "${id}", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
});
</script>