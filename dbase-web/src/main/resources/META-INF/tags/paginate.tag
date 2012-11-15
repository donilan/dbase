<%@ tag dynamic-attributes="dynAttr" body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="pageObject" description="Instance of com.ii2d.dbase.mybatis.Page" type="com.ii2d.dbase.mybatis.Page" %>
<%@ attribute name="currentPage" description="Current page" type="java.lang.Integer" %>
<%@ attribute name="count" description="all data count" type="java.lang.Integer" %>
<%@ attribute name="limit" description="limit pre page" type="java.lang.Integer" %>
<%@ attribute name="borderColor" required="false" description="Border color" type="java.lang.String" %>
<%@ attribute name="textColor" required="false" description="Text color" type="java.lang.String" %>
<%@ attribute name="backgroundColor" required="false" description="Background color" type="java.lang.String" %>
<%@ attribute name="borderHoverColor" required="false" description="Border hover color" type="java.lang.String" %>
<%@ attribute name="textHoverColor" required="false" description="Text hover color" type="java.lang.String" %>
<%@ attribute name="backgroundHoverColor" required="false" description="Background hover color" type="java.lang.String" %>
<%@ attribute name="border" required="false" description="Background color" type="java.lang.Boolean" %>
<c:choose>
	<c:when test="${pageObject != null}">
		<div id="ii2d-pagination" data-current-page="${pageObject.currentPage }" data-count="${pageObject.count }" data-limit="${pageObject.limit }"></div>
	</c:when>
	<c:otherwise>
		<div id="ii2d-pagination" data-current-page="${currentPage }" data-count="${count }" data-limit="${limit }"></div>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
jQuery(function(){
	var paginate = jQuery('#ii2d-pagination');
	var pData = paginate.data();
	if(pData.count <= pData.limit)
		return;
	var pages = parseInt((pData.count-1) / pData.limit) + 1;
	
	paginate.paginate({
		count: pages,
		start: pData.currentPage,
		display: pages > 10 ? 10: pages,
		border: ${border == 'false'? 'false': 'true'},
		border_color: "${empty borderColor ? '#BEF8B8': borderColor}",
		text_color: "${empty textColor ? '#68BA64': textColor}",
		background_color: "${empty backgroundColor ? '#E3F2E1': backgroundColor}",	
		border_hover_color: "${empty borderHoverColor ? '#68BA64': borderHoverColor}",
		text_hover_color: "${empty textHoverColor ? 'black' : textHoverColor}",
		background_hover_color: "${empty backgroundHoverColor ?'#CAE6C6' : backgroundHoverColor}", 
		rotate: false,
		images: true,
		mouse: 'press',
		onChange: function(p){
			$.insertParamAndGoTo('pagination[page]', p);
		}
	});
});
</script>