(function($){
	$.extend({
		insertParam: function(paramStr, key, value) {
		    key = escape(key); 
		    value = escape(value);
		    if(paramStr.indexOf('?') == 0) {
		    	paramStr = paramStr.substr(1);
		    }
		    var kvp = paramStr.split('&');
		    var i=kvp.length; var x; while(i--){
		    	x = kvp[i].split('=');
		    	if (x[0]==key){
		    		x[1] = value;
		    		kvp[i] = x.join('=');
		    		break;
		    	}
		    }
		    if(i<0) {
		    	if(kvp.length > 0 && !kvp[0]) {
		    		kvp.splice(0,1);
		    	}
		    	kvp[kvp.length] = [key,value].join('=');
		    }
		    return kvp.join('&'); 
		},
		
		insertParamAndGoTo: function(key, value) {
			var param = $.insertParam(document.location.search, key, value);
			document.location.search = param;
		}
	});
	
})(jQuery);