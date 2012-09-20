package com.ii2d.dbase.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 文件路径和名字工具
 * @author Doni
 * @since 2012-9-20
 * @version $id$
 */
public class DFileNameUtils {
	
	public static final String BACK_PATH_REGEX = "\\.\\./";
	
	/**
	 * 去除后退路径，如 ../
	 * @author Doni
	 * @since 2012-9-20
	 */
	public static String removeBackPath(String toBeRemove) {
		if(StringUtils.isNotBlank(toBeRemove)) {
			return toBeRemove.replaceAll(BACK_PATH_REGEX, "");
		}
		return toBeRemove;
	}

	public static String removePath(String toBeRemove, String removeTarget) {
		if(StringUtils.isNotBlank(toBeRemove) && StringUtils.isNotBlank(removeTarget)) {
			toBeRemove = toBeRemove.replaceAll("\\\\", "/");
			removeTarget = removeTarget.replaceAll("\\\\", "/");
			int idx = toBeRemove.indexOf(removeTarget);
			if(idx > -1) {
				return toBeRemove.substring(idx + removeTarget.length()+1);
			}
		}
		return toBeRemove;
	}
	
	public static String removeFirstSeparator(String path) {
		if(StringUtils.isNotBlank(path)) {
			if(path.startsWith("/") || path.startsWith("\\")) {
				return path.substring(1);
			}
		}
		return path;
	}
}
