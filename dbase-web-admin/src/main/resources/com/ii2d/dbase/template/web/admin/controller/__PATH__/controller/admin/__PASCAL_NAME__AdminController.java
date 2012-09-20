package ${packageName}.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ii2d.dbase.commons.service.CommonService;
import ${packageName}.model.${pascalName};

@Controller
@RequestMapping("/admin/${camelName}")
public class ${pascalName}AdminController {
	
	public static final String INSTANCE = "instance";
	
	@Resource
	private CommonService commonService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap model) {
		return "admin/${camelName}/index";
	}

	<%if(idColumn) {%>
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public String find${pascalName}(@PathVariable ${idColumn.classType} id, ModelMap model) {
		model.addAttribute(INSTANCE, commonService.queryForById(id, ${pascalName}.class));
		return "admin/${camelName}/show";
	}
	<%}%>
	
}
