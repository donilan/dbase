//~ generate by eclipse
package com.ii2d.dbase.web.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ii2d.dbase.util.DResourceUtils;

/**
 * @author Doni
 * @since 2012-9-18
 * @version $id$
 * 
 */
@Controller
@RequestMapping("/resources")
public class ResourcesController {

	@RequestMapping(value = "js/{fileName}/{version}", method = RequestMethod.GET)
	public void js(
			@PathVariable("fileName") String fileName,
			@PathVariable("version") String version,
			@RequestParam(value = "isMin", defaultValue = "true") boolean isMin,
			HttpServletResponse response) {
		StringBuffer file = new StringBuffer(20);
		file.append("classpath:js/").append(fileName).append('-')
				.append(version).append('.');
		if (isMin)
			file.append("min").append('.');
		file.append("js");

		try {
			InputStream in = DResourceUtils.getResourceAsStream(file.toString());
			IOUtils.copy(in, response.getOutputStream());
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value = "css/{fileName}/{version}", method = RequestMethod.GET)
	public void css(
			@PathVariable("fileName") String fileName,
			@PathVariable("version") String version,
			@RequestParam(value = "isMin", defaultValue = "true") boolean isMin,
			HttpServletResponse response) {
		StringBuffer file = new StringBuffer(20);
		file.append("classpath:css/").append(fileName).append('-')
				.append(version).append('.');
		if (isMin)
			file.append("min").append('.');
		file.append("css");

		try {
			InputStream in = DResourceUtils.getResourceAsStream(file.toString());
			IOUtils.copy(in, response.getOutputStream());
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
