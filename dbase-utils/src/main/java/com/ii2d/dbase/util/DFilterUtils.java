//~ generate by eclipse
package com.ii2d.dbase.util;

import java.util.regex.Pattern;

/**
 * @author Doni
 * @since 2012-9-28
 * @version $id$
 * 
 */
public class DFilterUtils {

	/**
	 * 查看这个字符串是不是想要的字符串
	 * @author Doni
	 * @since 2012-9-22
	 * @param fileName 文件名
	 * @param include 包含
	 * @param exclude 排除
	 * @return
	 */
	public static boolean isThisOneYouWant(String name, String[] include, String[] exclude) {
		if(include != null) {
			for(String in: include) {
				Pattern p = Pattern.compile(in);
				if(p.matcher(name).matches())
					return true;
			}
			return false;
		}
		if(exclude != null) {
			for(String excl: exclude)  {
				Pattern p = Pattern.compile(excl);
				if(p.matcher(name).matches())
					return false;
			}
		}
		return true;
	}
	
}
