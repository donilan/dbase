//~ generate by eclipse
package com.ii2d.dbase.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	
	/**
	 * 用“,”分割所有字符串参数，并放入到list返回
	 * @author Doni
	 * @since 2012-11-23
	 * @param strs
	 * @return
	 */
	public static List<List<String>> splitStrings(String... strs) {
		List<List<String>> results = new ArrayList<List<String>>();
		for(String str: strs) {
			List<String> r = new ArrayList<String>();
			if(StringUtils.isNotBlank(str)) {
				String[] strArr = str.split(",");
				for(String s: strArr) {
					r.add(s);
				}
			}
			results.add(r);
		}
		
		//对齐下标
		if(!results.isEmpty()){
			List<String> r1 = results.get(0);
			for(List<String> r: results) {
				if(r.size() < r1.size()) {
					int needAdd = r1.size() - r.size();
					for(int i = 0; i < needAdd; ++i) {
						r.add("");
					}
				}
			}
		}
		return results;
	}
	
}
