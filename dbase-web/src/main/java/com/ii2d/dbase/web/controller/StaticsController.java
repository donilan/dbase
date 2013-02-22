//~ generate by eclipse
package com.ii2d.dbase.web.controller;

import static com.ii2d.dbase.util.DFileNameUtils.removeBackPath;
import static com.ii2d.dbase.util.DFileNameUtils.removePath;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.dbase.util.WebUtils;

/**
 * @author Doni
 * @since 2012-9-18
 * @version $id$
 * 
 */
@Controller
@RequestMapping("/" + StaticsController.PREFIX)
public class StaticsController {

	public static final String PREFIX = "statics";
	public static final String BASE_CLASSPATH = "classpath:statics/";
	private static final Log LOG = LogFactory.getLog(StaticsController.class);

	@RequestMapping(value = "**", method = RequestMethod.GET)
	public void load(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		if (StringUtils.isNotBlank(uri)) {
			StringBuffer file = new StringBuffer(20);
			file.append(removeBackPath(removePath(uri, PREFIX)));
			if (LOG.isDebugEnabled()) {
				LOG.debug("Try to load resource: " + file.toString());
			}
			try {
				response.setHeader("content-type",
						WebUtils.mimeType(FilenameUtils.getExtension(uri)));
				InputStream in = _findInputStream(file.toString());
				IOUtils.copy(in,
						response.getOutputStream());
				in.close();
				response.flushBuffer();
			} catch (IOException e) {
				try {
					LOG.info("File " + file.toString() + " not found.");
					response.sendError(404, "Resource Not found.");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("resource")
	private InputStream _findInputStream(String path) throws IOException {
		InputStream in = null;
		try {
			in = new FileInputStream("statics/" + path);
		} catch (IOException e) {
			in = DResourceUtils.getResourceAsStream(BASE_CLASSPATH + path);
		}
		return in;
	}
}
