//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * Resource utils
 * 
 * @author Doni
 * @since 2012-9-10
 * @version $id$
 * 
 */
public class DResourceUtils {

	/** Pseudo URL prefix for loading from the class path: "classpath:" */
	public final static String CLASSPATH_URL_PREFIX = "classpath:";
	/** URL prefix for loading from the file system: "file:" */
	public final static String FILE_URL_PREFIX = "file:";

	/**
	 * @see #getResourceURL(ClassLoader, String)
	 * @author Doni
	 * @since 2012-9-10
	 */
	public static URL getResourceURL(String resource) throws IOException {
		return getResourceURL(getDefaultClassLoad(), resource);
	}

	/**
	 * Returns the URL of the resource on the classpath
	 * 
	 * @author Doni
	 * @since 2012-9-10
	 * @param cl
	 *            The class loader used to load the resource
	 * @param resource
	 *            The resource to find
	 * @return The resource
	 * @throws IOException
	 *             If the resource cannot be found or read
	 */
	public static URL getResourceURL(ClassLoader cl, String resource)
			throws IOException {
		URL url = null;
		if (StringUtils.isNotBlank(resource)) {
			String tmp = _removePrefix(resource, CLASSPATH_URL_PREFIX);
			if (tmp != null) {
				if (cl != null) {
					url = cl.getResource(tmp);
				}
				if (url == null) {
					url = ClassLoader.getSystemResource(tmp);
					if (url != null)
						return url;
				} else {
					return url;
				}
			} else {
				tmp = _removePrefix(resource, FILE_URL_PREFIX);
				if (tmp == null) {
					tmp = resource;
				}
				return new File(tmp).toURI().toURL();
			}
		}
		throw new IOException("Could not found resource " + resource);
	}

	private static String _removePrefix(String resource, String prefix) {
		resource = StringUtils.trimToEmpty(resource);
		if (resource.startsWith(prefix))
			return StringUtils.trimToNull(resource.substring(prefix.length()));
		return null;
	}

	/**
	 * Returns a resource on the class path as a Stream object
	 * 
	 * @author Doni
	 * @since 2012-9-10
	 * @param cl
	 *            The class loader used to load the resource
	 * @param resource
	 *            The resource to find
	 * @return The resource
	 * @throws IOException
	 *             If the resource cannot be found or read
	 */
	public static InputStream getResourceAsStream(ClassLoader cl,
			String resource) throws IOException {
		InputStream in = null;
		if (StringUtils.isNotBlank(resource)) {
			String tmp = _removePrefix(resource, CLASSPATH_URL_PREFIX);
			if (tmp != null) {
				if (cl != null) {
					in = cl.getResourceAsStream(tmp);
				}
				if (in == null) {
					in = ClassLoader.getSystemResourceAsStream(tmp);
					if (in != null)
						return in;
				} else {
					return in;
				}
			} else {
				tmp = _removePrefix(resource, FILE_URL_PREFIX);
				if (tmp != null)
					tmp = resource;
				return new FileInputStream(tmp);
			}
		}
		throw new IOException("Could not find resource " + resource);
	}

	/**
	 * @see #getResourceAsStream(ClassLoader, String)
	 * @author Doni
	 * @since 2012-9-10
	 */
	public static InputStream getResourceAsStream(String resource)
			throws IOException {
		return getResourceAsStream(getDefaultClassLoad(), resource);
	}

	/**
	 * @see #getResourceAsStream(ClassLoader, String)
	 * @author Doni
	 * @since 2012-9-10
	 */
	public static Properties getResourceAsProperties(ClassLoader cl,
			String resource) throws IOException {
		InputStream in = getResourceAsStream(cl, resource);
		Properties p = new Properties();
		p.load(in);
		in.close();
		return p;
	}

	/**
	 * @see #getResourceAsStream(ClassLoader, String)
	 * @author Doni
	 * @since 2012-9-10
	 */
	public static Properties getResourceAsProperties(String resource)
			throws IOException {
		return getResourceAsProperties(getDefaultClassLoad(), resource);
	}

	/**
	 * @see #getResourceAsStream(ClassLoader, String)
	 * @author Doni
	 * @since 2012-9-10
	 */
	public static Reader getResourceAsReader(ClassLoader cl, String resource)
			throws IOException {
		return new InputStreamReader(getResourceAsStream(cl, resource));
	}

	/**
	 * @see #getResourceAsStream(ClassLoader, String)
	 * @author Doni
	 * @since 2012-9-10
	 */
	public static Reader getResourceAsReader(String resource)
			throws IOException {
		return getResourceAsReader(getDefaultClassLoad(), resource);
	}

	/**
	 * @see #getResourceAsURL(ClassLoader, String)
	 * @author Doni
	 * @since 2012-9-10
	 */
	public static File getResourceAsFile(ClassLoader cl, String resource)
			throws IOException {
		return new File(getResourceURL(cl, resource).getFile());
	}

	/**
	 * @see #getResourceAsURL(ClassLoader, String)
	 * @author Doni
	 * @since 2012-9-10
	 */
	public static File getResourceAsFile(String resource) throws IOException {
		return getResourceAsFile(getDefaultClassLoad(), resource);
	}

	/**
	 * Get default class loader
	 * 
	 * @author Doni
	 * @since 2012-9-10
	 * @return
	 */
	private static ClassLoader getDefaultClassLoad() {
		return DResourceUtils.class.getClassLoader();
	}

}
