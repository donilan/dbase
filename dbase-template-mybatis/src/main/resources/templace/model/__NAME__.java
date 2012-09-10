package com.ii2d.model;

/**
 * @author Genthemall project
 * @since ${new Date().toString()}
 */
public class ${source.name} {
	<% source.getProperties().each {%>
	private ${it.classType} ${it.name};<% } %>
	<% source.getProperties().each {%>
	
	public ${it.classType} get${it.upperCaseFirstName}() {
		return this.${it.name};
	}
	public void set${it.upperCaseFirstName}(${it.classType} ${it.name}) {
		this.${it.name} = ${it.name};
	}
	<% } %>
	
	<%
	def toString = "" 
	source.getProperties().each {
		toString += """${it.name} + " - " + """
	}
	if(toString != "") {
		toString = toString[0..-12] + ";"
	%>
	public String toString() {
		return ${toString}
	}
	<%}%>
	
	public ${source.name} clone() {
		${source.name} instance = new ${source.name}();
		<%source.getProperties().each {%>
		instance.set${it.upperCaseFirstName}(this.${it.name});<%}%>
		return instance;
	}
}