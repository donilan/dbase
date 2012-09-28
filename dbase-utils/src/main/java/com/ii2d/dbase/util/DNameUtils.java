package com.ii2d.dbase.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Name utils
 * 
 * @author Doni
 * @since 2012-9-12
 * @version $id$
 */
public class DNameUtils {

	public static final String EMPTY_STRING = "";

	/**
	 * Key name is two '_' and upper case all work name.
	 * 
	 * @author Doni
	 * @since 2012-9-12
	 * @return Return key name like __KEY_NAME__
	 */
	public static String toKeyName(String name) {
		if (StringUtils.isBlank(name)) {
			return EMPTY_STRING;
		}
		StringBuilder sb = new StringBuilder("__");
		for (int i = 0; i < name.length(); ++i) {
			char c = name.charAt(i);
			if (Character.isUpperCase(c) && i > 0) {
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
	 * Find all key and value in String type, then put them to a new map to
	 * return.
	 * 
	 * @author Doni
	 * @since 2012-9-28
	 * @param map
	 *            To be found
	 * @return A map that contains some replace strings
	 */
	public static Map<String, String> toReplaceMap(Map map) {
		Map<String, String> result = new HashMap<String, String>();
		Iterator<Map.Entry> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = it.next();
			if (entry.getKey() instanceof String
					&& entry.getValue() instanceof String) {
				result.put(toKeyName((String) entry.getKey()),
						(String) entry.getValue());
			}
		}
		return result;
	}

	/**
	 * Change the name to pascal name like "KeyName"
	 * 
	 * @author Doni
	 * @since 2012-9-12
	 * @param name
	 *            Name for change
	 * @return The pascal style name
	 */
	public static String toPascalName(String name) {
		if (StringUtils.isBlank(name)) {
			return EMPTY_STRING;
		}
		StringBuilder sb = new StringBuilder(30);
		String tmpArr[] = name.toLowerCase().split("_");
		for (int i = 0; i < tmpArr.length; ++i) {
			if (StringUtils.isBlank(tmpArr[i]))
				continue;
			sb.append(Character.toUpperCase(tmpArr[i].charAt(0)));
			if (tmpArr[i].length() > 1)
				sb.append(tmpArr[i].substring(1));
		}
		return sb.toString();
	}

	/**
	 * Change the name to camel name like "keyName"
	 * 
	 * @author Doni
	 * @since 2012-9-12
	 * @param name
	 *            Name for change
	 * @return The camel name
	 */
	public static String toCamelName(String name) {
		if (StringUtils.isBlank(name)) {
			return EMPTY_STRING;
		}
		StringBuilder sb = new StringBuilder(30);
		String tmp = toPascalName(name);
		sb.append(Character.toLowerCase(tmp.charAt(0)));
		if (tmp.length() > 1)
			sb.append(tmp.substring(1));
		return sb.toString();
	}
}
