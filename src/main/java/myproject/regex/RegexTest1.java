package myproject.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest1 {

	public static void main(String[] args) {

		String str = "The world's of mine  and they are so lazy";
		
		List<String> tokens = getTokens(str, "(?i)\\w+'{0,1}\\w+");
		
		System.out.println(tokens);
		
		
		String ints = "1+2-3 * 10 / 24";
		tokens = getTokens(ints, "[0-9]+|[\\+\\-\\*/]");
		
		System.out.println(tokens);
		
	}
	
	static List<String> getTokens(String text, String pattern) {
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}

}
