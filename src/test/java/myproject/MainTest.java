package myproject;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainTest {
	
	@Test
	public void uniqueChars() {
		
		assertTrue(isUniqueChars("abc"));
		assertFalse(isUniqueChars("abcab"));
		
	}

	private boolean isUniqueChars(String string) {
		if (string.length() > 256) return false;
		
		boolean[] charSet = new boolean[256];
		
		for (int i = 0; i < string.length(); i++) {
			int val = string.charAt(i);
			if (charSet[val]) return false;
			
			charSet[val] = true;
		}
		
		return true;
	}

}
