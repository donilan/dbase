//~ generate by eclipse
package com.ii2d.dbase.commons.jaxb;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Doni
 * @since 2012-9-17
 * @version $id$
 * 
 */
public class DateAdapter extends XmlAdapter<String, Date> {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public Date unmarshal(String v) throws Exception {
		return dateFormat.parse(v);
	}
	@Override
	public String marshal(Date v) throws Exception {
		 return dateFormat.format(v);
	}

	


}
