package myproject;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void shouldReturnTrue() {
		System.out.println("testtest");
		assertThat(true, equalTo(true));
		System.out.println(getString());
	}

	private String getString() {
		// TODO Auto-generated method stub
		return "string";
	}
	
	@Test
	public void shouldPassForTest2() {
		App app = new App();
		app.test2();
	}
}
