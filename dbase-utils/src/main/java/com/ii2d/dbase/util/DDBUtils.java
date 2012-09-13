//~ generate by eclipse
package com.ii2d.dbase.util;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Doni
 * @since 2012-9-13
 * @version $id$
 * 
 */
public class DDBUtils {
	public static final Map<Integer, String> TYPES = new HashMap<Integer, String>();
	static {
		List<String> names = DReflectUtils.getFinalNames(Types.class);
		for(String n: names) {
			try {
				TYPES.put((Integer)DReflectUtils.getFinalFieldValue(Types.class, n), n);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
