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
		assertThat(true, equalTo(true));
	}
}
