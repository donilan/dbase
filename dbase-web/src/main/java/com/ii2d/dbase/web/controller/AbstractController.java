//~ generate by eclipse
package com.ii2d.dbase.web.controller;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ii2d.dbase.commons.service.CommonService;

/**
 * @author Doni
 * @since 2012-9-20
 * @version $id$
 * 
 */
public abstract class AbstractController {
	
	public static final String INSTANCE = "instance";

	@Resource
	protected CommonService commonService;
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public String find(@PathVariable java.lang.Integer id, ModelMap model) {
		model.addAttribute(INSTANCE, commonService.queryForById(id, getInstanceClass()));
		return String.format("admin/%s/show", getControllerName());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/editor/{id}")
	public String editor(@PathVariable(value = "id") int id, ModelMap model) {
		model.addAttribute(INSTANCE, commonService.queryForById(id, getInstanceClass()));
		return String.format("admin/%s/editor", getControllerName());
	}
	@RequestMapping(method = RequestMethod.GET, value = "/editor")
	public String editor() {
		return String.format("admin/%s/editor", getControllerName());
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public String delete(@PathVariable java.lang.Integer id, ModelMap model) {
		int count = commonService.delete(id, getInstanceClass());
		model.addAttribute(count);
		return String.format("admin/%s/delete", getControllerName());
	}
	
	public abstract Class<?> getInstanceClass();
	
	public abstract String getControllerName();
}
