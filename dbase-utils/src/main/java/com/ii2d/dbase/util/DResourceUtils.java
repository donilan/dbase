//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
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

	/** URL protocol for a file in the file system: "file" */
	public static final String URL_PROTOCOL_FILE = "file";

	/** URL protocol for an entry from a jar file: "jar" */
	public static final String URL_PROTOCOL_JAR = "jar";

	/** URL protocol for an entry from a zip file: "zip" */
	public static final String URL_PROTOCOL_ZIP = "zip";

	/** URL protocol for an entry from a JBoss jar file: "vfszip" */
	public static final String URL_PROTOCOL_VFSZIP = "vfszip";

	/** URL protocol for a JBoss VFS resource: "vfs" */
	public static final String URL_PROTOCOL_VFS = "vfs";

	/** URL protocol for an entry from a WebSphere jar file: "wsjar" */
	public static final String URL_PROTOCOL_WSJAR = "wsjar";

	/** URL protocol for an entry from an OC4J jar file: "code-source" */
	public static final String URL_PROTOCOL_CODE_SOURCE = "code-source";

	/** Separator between JAR URL and file path within the JAR */
	public static final String JAR_URL_SEPARATOR = "!/";

	/**
	 * @see #getResourceURL(ClassLoader, String)
	 * @author Doni
	 * @since 2012-9-10
	 */
	public static URL getResourceURL(String resource) throws IOException {
		return getResourceURL(getDefaultClassLoad(), resource);
	}

	/**
	 * @see #getResourceURLs(ClassLoader, String)
	 * @author Doni
	 * @since 2012-9-22
	 */
	public static List<URL> getResourceURLs(String resource) throws IOException {
		return getResourceURLs(getDefaultClassLoad(), resource);
	}

	/**
	 * Find all urls for resource path
	 * 
	 * @author Doni
	 * @since 2012-9-22
	 * @param cl
	 *            The class loader used to load the resource urls
	 * @param resource
	 *            The resource to find
	 * @return A list that contain urls
	 * @throws IOException
	 *             if the resource cannot be found or read
	 */
	public static List<URL> getResourceURLs(ClassLoader cl, String resource)
			throws IOException {
		List<URL> urls = new ArrayList<URL>();
		String tmpResource = _removePrefix(resource, CLASSPATH_URL_PREFIX);
		if(tmpResource == null) 
			tmpResource = resource;
		Enumeration<URL> tmp = cl.getResources(tmpResource);
		while (tmp.hasMoreElements())
			urls.add(tmp.nextElement());
		return urls;
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
				if (tmp == null)
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

	public static ArchiveInputStream getResourceAsArchiveInputStream(
			String resource) throws IOException {
		return getResourceAsArchiveInputStream(getDefaultClassLoad(), resource);
	}

	public static ArchiveInputStream getResourceAsArchiveInputStream(
			ClassLoader cl, String resource) throws IOException {
		URL url = getResourceURL(cl, resource);
		if (url != null) {
			if (URL_PROTOCOL_JAR.equals(url.getProtocol())) {
				String urlStr = url.getPath();
				if (urlStr.startsWith(FILE_URL_PREFIX)) {
					String file = urlStr.substring(FILE_URL_PREFIX.length());
					file = file.substring(0, file.indexOf(JAR_URL_SEPARATOR));
					return new JarArchiveInputStream(new FileInputStream(file));
				}
			}
		}
		return null;
	}

	public static List<ArchiveInputStream> getResourceAsArchiveInputStreams(
			String resource) throws IOException {
		return getResourceAsArchiveInputStreams(getDefaultClassLoad(), resource);
	}

	public static List<ArchiveInputStream> getResourceAsArchiveInputStreams(
			ClassLoader cl, String resource) throws IOException {
		List<ArchiveInputStream> results = new ArrayList<ArchiveInputStream>();
		List<URL> urls = getResourceURLs(cl, resource);
		for (URL url : urls) {
			results.add(new JarArchiveInputStream(new FileInputStream(
					urlToJarFilePath(url))));
		}
		return results;
	}
	
	/**
	 * 把url中的jar路径提取出来
	 * @author Doni
	 * @since 2012-9-25
	 * @param url 
	 * @return 非合法url返回null
	 */
	public static String urlToJarFilePath(URL url) {
		if (URL_PROTOCOL_JAR.equals(url.getProtocol())) {
			String urlStr = url.getPath();
			if (urlStr.startsWith(FILE_URL_PREFIX)) {
				String file = urlStr.substring(FILE_URL_PREFIX.length());
				return file.substring(0, file.indexOf(JAR_URL_SEPARATOR));
			}
		}
		return null;
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
