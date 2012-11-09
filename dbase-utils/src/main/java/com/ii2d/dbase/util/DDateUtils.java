//~ generate by eclipse
package com.ii2d.dbase.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Doni
 * @since 2012-11-9
 * @version $id$
 * 
 */
public class DDateUtils {
	public static final SimpleDateFormat DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String dateFormat(Date d) {
		if(d == null) return "";
		return DATE.format(d);
	}
	
	public static String datetimeFormat(Date d) {
		if(d == null) return "";
		return DATETIME.format(d);
	}
	
	public static Date dateParse(String d) throws ParseException {
		if(StringUtils.isBlank(d)) return null;
		return DATE.parse(d);
	}
	
	public static Date datetimeParse(String d) throws ParseException {
		if(StringUtils.isBlank(d)) return null;
		return DATETIME.parse(d);
	}
	
	public static Date safeParse(String d) {
		try {
			return parse(d);
		} catch (ParseException e) {
			// Do not thing.
		}
		return null;
	}
	
	public static Date parse(String d) throws ParseException {
		if(StringUtils.isBlank(d)) return null;
		try {
			return DATETIME.parse(d);
		} catch (ParseException e) {
			return DATE.parse(d);
		}
	}
}
