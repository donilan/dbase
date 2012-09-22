//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FilenameUtils;

/**
 * @author Doni
 * @since 2012-9-22
 * @version $id$
 * 
 */
public class DResourceFinder {
	
	/**
	 * 任意资源地址查找文件
	 * @author Doni
	 * @since 2012-9-22
	 * @see #find(String, String[], String[])
	 */
	public static List<String> find(String resourcePath) throws IOException {
		return find(resourcePath, null, null);
	}

	/**
	 * 任意资源地址查找文件
	 * @author Doni
	 * @since 2012-9-22
	 * @param resourcePath 资源地址
	 * @param include 包含
	 * @param exclude 排除
	 * @see #findInDir(String, String[], String[])
	 * @see #findInJar(String, String[], String[])
	 */
	public static List<String> find(final String resourcePath, final String[] include,
			final String[] exclude) throws IOException {
		URL url = DResourceUtils.getResourceURL(resourcePath);
		if ("file".equals(url.getProtocol())) {
			return findInDir(url.getFile(), include, exclude);
		} else if ("jar".equals(url.getProtocol())) {
			return findInJar(resourcePath, include, exclude);
		}
		return new ArrayList<String>();
	}

	/**
	 * 在 classpath里面找文件
	 * @author Doni
	 * @since 2012-9-22
	 * @param resourcePath 资源地址classpath:xxx
	 * @param include 包含
	 * @param exclude 排除
	 * @return 返回带classpath前缀的路径
	 */
	public static List<String> findInJar(final String resourcePath,
			final String[] include, final String[] exclude) throws IOException {
		List<String> files = new ArrayList<String>();
		List<ArchiveInputStream> inputStreams = DResourceUtils
				.getResourceAsArchiveInputStreams(resourcePath);
		for(ArchiveInputStream in: inputStreams) {
			new DArchiveEntryWalker<String>() {
	
				@Override
				protected void handleFile(ArchiveEntry entry,
						Collection<String> results) {
					String name = entry.getName();
					String basePath = resourcePath.substring(DResourceUtils.CLASSPATH_URL_PREFIX.length());
					if(name.startsWith(basePath)) {
						if(isThisOneYouWant(FilenameUtils.getName(name), include, exclude))
							results.add(DResourceUtils.CLASSPATH_URL_PREFIX + name);
					}
				}
			}.walk(in, files);
			in.close();
		}
		return files;
	}

	/**
	 * 在文件夹里找文件
	 * @author Doni
	 * @since 2012-9-22
	 * @param dir 查找路径
	 * @param include 包含
	 * @param exclude 排除
	 * @return 全路径
	 */
	public static List<String> findInDir(final String dir, final String[] include,
			final String[] exclude) {
		List<String> files = new ArrayList<String>();
		new DirectoryWalker<String>() {
			public void run(File startDirectory, Collection<String> results) {
				try {
					walk(startDirectory, results);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			@Override
			protected void handleFile(File file, int depth,
					Collection<String> results) throws IOException {
				if(isThisOneYouWant(file.getName(), include, exclude))
					results.add(file.getAbsolutePath());
			}
		}.run(new File(dir), files);
		return files;
	}
	
	/**
	 * 查看这个文件是不是想要的文件
	 * @author Doni
	 * @since 2012-9-22
	 * @param fileName 文件名
	 * @param include 包含
	 * @param exclude 排除
	 * @return
	 */
	public static boolean isThisOneYouWant(String fileName, String[] include, String[] exclude) {
		if(include != null) {
			for(String in: include) {
				if(in.equals(fileName))
					return true;
			}
			return false;
		}
		if(exclude != null) {
			for(String excl: exclude)  {
				if(excl.equals(fileName))
					return false;
			}
		}
		return true;
	}
}
