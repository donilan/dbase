//~ generate by eclipse
package com.ii2d.dbase.template;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.ii2d.dbase.template.token.BlockToken;
import com.ii2d.dbase.template.token.TextToken;
import com.ii2d.dbase.template.token.Token;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public class Lexer {
	
	private static final Pattern re = Pattern.compile("(\\{%[^%]*%})");

	public static List<Token> tokenize(String content) throws ParserException {
		if(StringUtils.isBlank(content)) {
			throw new ParserException("Content cannot be null or empty.");
		}
		List<Token> result = new ArrayList<Token>();
		Matcher m = re.matcher(content);
		int idx = 0;
		int lineNo = 0;
		while(m.find()) {
			String text = content.substring(idx, m.start());
			if(StringUtils.trimToEmpty(text).length() > 0) {
				lineNo = StringUtils.countMatches(content.substring(0, idx), "\n");
				result.add(new TextToken(text, lineNo));
			}
			text = content.substring(m.start(), m.end());
			lineNo = StringUtils.countMatches(content.substring(0, m.start()), "\n");
			result.add(new BlockToken(text, lineNo));
			idx = m.end();
			
		}
		String text = content.substring(idx);
		if(StringUtils.trimToEmpty(text).length() > 0)
			result.add(new TextToken(text, lineNo));
		return result;
	}
}
