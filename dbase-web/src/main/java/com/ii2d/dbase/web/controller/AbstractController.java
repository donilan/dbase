//~ generate by eclipse
package com.ii2d.dbase.web.controller;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
	public String edit(@PathVariable(value = "id") int id, ModelMap model) {
		model.addAttribute(INSTANCE, commonService.queryForById(id, getInstanceClass()));
		return String.format("admin/%s/edit", getControllerName());
	}
	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String create(ModelMap model) throws InstantiationException, IllegalAccessException {
		model.addAttribute(INSTANCE, getInstanceClass().newInstance());
		return String.format("admin/%s/create", getControllerName());
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public @ResponseBody String delete(@PathVariable java.lang.Integer id, ModelMap model) {
		int count = commonService.delete(id, getInstanceClass());
		model.addAttribute(count);
		return "success";
	}
	
	public abstract Class<?> getInstanceClass();
	
	public abstract String getControllerName();
}
