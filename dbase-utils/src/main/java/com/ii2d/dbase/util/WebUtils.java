//~ generate by eclipse
package com.ii2d.dbase.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Doni
 * @since 2012-9-21
 * @version $id$
 * 
 */
public class WebUtils {
	
	public static final Map<String, String> MIME_TYPE_MAP;
	static {
		MIME_TYPE_MAP = new HashMap<String, String>();
		MIME_TYPE_MAP.put("html", "text/html");
		MIME_TYPE_MAP.put("htm", "text/html");
		MIME_TYPE_MAP.put("txt", "text/plain");
		MIME_TYPE_MAP.put("c", "text/plain");
		MIME_TYPE_MAP.put("c++", "text/plain");
		MIME_TYPE_MAP.put("pl", "text/plain");
		MIME_TYPE_MAP.put("cc", "text/plain");
		MIME_TYPE_MAP.put("h", "text/plain");
		MIME_TYPE_MAP.put("css", "text/css");
		MIME_TYPE_MAP.put("gif", "image/gif");
		MIME_TYPE_MAP.put("xbm", "image/x-xbitmap");
		MIME_TYPE_MAP.put("xpm", "image/x-xpixmap");
		MIME_TYPE_MAP.put("png", "image/png");
		MIME_TYPE_MAP.put("ief", "image/ief");
		MIME_TYPE_MAP.put("jpeg", "image/jpeg");
		MIME_TYPE_MAP.put("jpg", "image/jpeg");
		MIME_TYPE_MAP.put("jpe", "image/jpeg");
		MIME_TYPE_MAP.put("tiff", "image/tiff");
		MIME_TYPE_MAP.put("tif", "image/tiff");
		MIME_TYPE_MAP.put("rgb", "image/rgb");
		MIME_TYPE_MAP.put("g3f", "image/g3fax");
		MIME_TYPE_MAP.put("bmp", "image/x-ms-bmp");
		MIME_TYPE_MAP.put("wav", "audio/x-wav");
		MIME_TYPE_MAP.put("mpa", "audio/x-mpeg");
		MIME_TYPE_MAP.put("abs", "audio/x-mpeg");
		MIME_TYPE_MAP.put("mpega", "audio/x-mpeg");
		MIME_TYPE_MAP.put("mp2a", "audio/x-mpeg-2");
		MIME_TYPE_MAP.put("mpa2", "audio/x-mpeg-2");
		MIME_TYPE_MAP.put("mpeg", "video/mpeg");
		MIME_TYPE_MAP.put("mpg", "video/mpeg");
		MIME_TYPE_MAP.put("mpe", "video/mpeg");
		MIME_TYPE_MAP.put("qt", "video/quicktime");
		MIME_TYPE_MAP.put("mov", "video/quicktime");
		MIME_TYPE_MAP.put("avi", "video/x-msvideo");
		MIME_TYPE_MAP.put("pdf", "application/pdf");
		MIME_TYPE_MAP.put("js", "text/javascript");
	}
	
	public static String mimeType(String extension) {
		String mimeType = MIME_TYPE_MAP.get(extension);
		if(mimeType != null)
			return mimeType;
		return "text/plan";
	}
}
