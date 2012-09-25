//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
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
		List<String> results = new ArrayList<String>();
		List<URL> urls = DResourceUtils.getResourceURLs(resourcePath);
		for(URL url: urls) {
			if ("file".equals(url.getProtocol())) {
				results.addAll(findInDir(url.getFile(), include, exclude));
			} else if ("jar".equals(url.getProtocol())) {
				List<String> tmpList = findInJar(DResourceUtils.urlToJarFilePath(url), include, exclude);
				for(int i = 0; i < tmpList.size(); ++i) {
					if(!tmpList.get(i).startsWith(resourcePath)) {
						tmpList.remove(i);
					}
				}
				results.addAll(tmpList);
			}
		}
		return results;
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
	public static List<String> findInJar(final String jarFilePath,
			final String[] include, final String[] exclude) throws IOException {
		List<String> files = new ArrayList<String>();
		ArchiveInputStream in = new JarArchiveInputStream(new FileInputStream(jarFilePath));
		new DArchiveEntryWalker<String>() {

			@Override
			protected void handleFile(ArchiveEntry entry,
					Collection<String> results) {
				String name = entry.getName();
				if(isThisOneYouWant(FilenameUtils.getName(name), include, exclude))
					results.add(DResourceUtils.CLASSPATH_URL_PREFIX + name);
			}
		}.walk(in, files);
		in.close();
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
	 * @throws IOException 
	 */
	public static List<String> findInDir(final String dir, final String[] include,
			final String[] exclude) throws IOException {
		List<String> files = new ArrayList<String>();
		File file = new File(dir);
		if(!file.exists()) {
			throw new IOException("File " + dir + " Not found.");
		}
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
		}.run(file, files);
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
