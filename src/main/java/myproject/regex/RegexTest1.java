package myproject.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest1 {

	public static void main(String[] args) {

		String str = "The world's of mine  and they are so lazy";
		
		List<String> tokens = getTokens(str, "(?i)\\w+'{0,1}\\w+");
		
		System.out.println("Tokens: " + tokens);
		
		
		String ints = "1+2-3 * 10 / 24";
		tokens = getTokens(ints, "[0-9]+|[\\+\\-\\*/]");
		
		System.out.println("Arithmethics: " + tokens);
		
		String str2 = "E-revista de la transferencia directa Consumer Electronics";
		tokens = getTokens(str2, "\\b\\w+\\b");
		
		System.out.println("Words: " + tokens);
		
		String str3 = "You can disable zooming capabilities on mobile devices by adding user-scalable=no to the viewport meta tag. "
				+ "This disables zooming, meaning users are only able to scroll, and results in your site feeling a bit more like a "
				+ "native application. Overall, we don't recommend this on every site, so use caution!";
		tokens = getTokens(str3, "[^.!?]+");
		
		System.out.println("Sentences: " + tokens);
		
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
