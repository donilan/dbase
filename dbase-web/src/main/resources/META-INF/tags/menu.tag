<%@ tag dynamic-attributes="dynAttr" body-content="scriptless" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="id" required="true" description="Menu div id" type="java.lang.String" %>
<%@ attribute name="cssClass" description="Menu div class" type="java.lang.String" %>
<%@ attribute name="backgroundColor" description="Menu background color" type="java.lang.String" %>
<%@ attribute name="hoverBackgroundColor" description="Menu hover background color" type="java.lang.String" %>
<div id="${id}" class="ii2d-menu menu ${cssClass}" >
<ul>
	<jsp:doBody />
</ul>
</div>
<script type="text/javascript">
ddsmoothmenu.init({
	mainmenuid: "${id}", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	customtheme: ["${empty backgroundColor ? '#1c5a80': backgroundColor}", "${empty hoverBackgroundColor? '#18374a': hoverBackgroundColor}"], //["normal_background", "hover_background"]
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
});
</script>