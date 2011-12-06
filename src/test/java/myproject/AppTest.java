package myproject;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private static final String STRING = "string";
	private QuartzTest quartzTest;

	@Test
	public void shouldReturnTrue() {
		System.out.println("testtest");
		assertThat(true, equalTo(true));
		assertThat(false, equalTo(false));
		assertThat(true, equalTo(true));
		Map<String,String> hashMap = new HashMap<String, String>();
		hashMap.containsKey("abc");
		System.out.println(getString());
		System.out.println(getString());
	}

	private String getString() {
		// TODO Auto-generated method stub
		assertEquals(true, true);
		assertEquals(false, false);
		assertEquals(true, true);
		assertTrue(true);
		assertFalse(false);
		assertEquals(true, true);
		return STRING;
	}
	
	@Test
	public void shouldPassForTest2() {
		App app = new App();
		app.test2();
		App app2 = new App();
		app2.test2();
		
		App app3 = new App();
		App app4 = new App();
		
		
		quartzTest = new QuartzTest();
		
		Map<Integer, String> hash = new HashMap<Integer, String>();
		Map<String,String> hashMap = new HashMap<String, String>();
		
		List<String> arrayList = new ArrayList<String>();
		
		Set<String> hashSet = new HashSet<String>();
		
	}
}
