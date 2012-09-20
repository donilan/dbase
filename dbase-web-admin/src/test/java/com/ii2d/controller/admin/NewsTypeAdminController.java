package com.ii2d.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ii2d.dbase.commons.service.CommonService;
import com.ii2d.model.NewsType;

@Controller
@RequestMapping("/admin/newsType")
public class NewsTypeAdminController {
	
	public static final String INSTANCE = "instance";
	
	@Resource
	private CommonService commonService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap model) {
		return "admin/newsType/index";
	}

	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public String findNewsType(@PathVariable java.lang.Integer id, ModelMap model) {
		model.addAttribute(INSTANCE, commonService.queryForById(id, NewsType.class));
		return "admin/newsType/show";
	}
	
	
}
