//~ generate by eclipse
package com.ii2d.dbase.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Doni
 * @since 2012-9-13
 * @version $id$
 * 
 */
public class DReflectUtils {

	/**
	 * 获取所有Final属性
	 * 
	 * @author Doni
	 * @since 2012-9-13
	 * @param clazz
	 *            目标对象
	 * @param type
	 *            筛选属性，null为获取所有
	 * @return 所有匹配的Final属性
	 */
	public static List<String> getFinalNames(Class<?> clazz, Class<?> type) {
		Assert.notNull(clazz);
		Field fields[] = clazz.getDeclaredFields();
		List<String> result = new ArrayList<String>();
		for (Field f : fields) {
			if (type != null) {
				if(!type.equals(f.getType())) continue;
			}
			int modifiers = f.getModifiers();
			if ((modifiers & Modifier.FINAL) > 0)
				result.add(f.getName());
		}
		return result;
	}
	
	/**
	 * @see #getFinalNames(Class, Class)
	 * @author Doni
	 * @since 2012-9-13
	 */
	public static List<String> getFinalNames(Class<?> clazz) {
		return getFinalNames(clazz, null);
	}
	
	/**
	 * 获取常量的值
	 * @author Doni
	 * @since 2012-9-13
	 * @param clazz 类
	 * @param fieldName 常量属性名称
	 * @return 常量值
	 */
	public static <T> T getFinalFieldValue(Class<?> clazz, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Assert.notNull(clazz);
		Assert.hasText(fieldName);
		Field f = clazz.getField(fieldName);
		if(f != null) {
			return (T)f.get(null);
		}
		return null;
	}
}
