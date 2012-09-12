package com.ii2d.dbase.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Name utils
 * @author Doni
 * @since 2012-9-12
 * @version $id$
 */
public class DNameUtils {
	
	public static final String EMPTY_STRING = "";
	
	/**
	 * Key name is two '_' and upper case all work name.
	 * @author Doni
	 * @since 2012-9-12
	 * @return Return key name like __KEY_NAME__
	 */
	public static String toKeyName(String name) {
		if(StringUtils.isBlank(name)) {
			return EMPTY_STRING;
		}
		StringBuilder sb = new StringBuilder("__");
		for(int i = 0; i < name.length(); ++i) {
			char c = name.charAt(i);
			if(Character.isUpperCase(c) && i > 0) {
				sb.append('_');
				sb.append(c);
			} else {
				sb.append(Character.toUpperCase(c));
			}
		}
		sb.append("__");
		return sb.toString();
	}
	
	/**
	 * Change the name to pascal name like "KeyName"
	 * @author Doni
	 * @since 2012-9-12
	 * @param name Name for change
	 * @return The pascal style name
	 */
	public static String toPascalName(String name) {
		if(StringUtils.isBlank(name)) {
			return EMPTY_STRING;
		}
		StringBuilder sb = new StringBuilder(30);
		String tmpArr[] = name.toLowerCase().split("_");
		for(int i = 0; i < tmpArr.length; ++i) {
			if(StringUtils.isBlank(tmpArr[i])) continue;
			sb.append(Character.toUpperCase(tmpArr[i].charAt(0)));
			if(tmpArr[i].length() > 1)
				sb.append(tmpArr[i].substring(1));
		}
		return sb.toString();
	}
	
	/**
	 * Change the name to camel name like "keyName"
	 * @author Doni
	 * @since 2012-9-12
	 * @param name Name for change
	 * @return The camel name
	 */
	public static String toCamelName(String name) {
		if(StringUtils.isBlank(name)) {
			return EMPTY_STRING;
		}
		StringBuilder sb = new StringBuilder(30);
		String tmp = toPascalName(name);
		sb.append(Character.toLowerCase(tmp.charAt(0)));
		if(tmp.length() > 1)
			sb.append(tmp.substring(1));
		return sb.toString();
	}
}
