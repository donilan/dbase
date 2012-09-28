//~ generate by eclipse
package com.ii2d.dbase.util;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Doni
 * @since 2012-9-24
 * @version $id$
 * 
 */
public class DStringUtils {

	/**
	 * 利用map的key和value替换字符串
	 * @author Doni
	 * @since 2012-9-24
	 */
	public static final String replaceAll(String target, Map replaces) {
		Assert.hasLength(target);
		Assert.notNull(replaces);
		Iterator<Map.Entry<Object, Object>> it = replaces.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Object, Object> entry = it.next();
			if(entry.getKey() instanceof String && entry.getValue() instanceof String)
				target = target.replaceAll((String)entry.getKey(), (String)entry.getValue());
		}
		return target;
	}
	
}
