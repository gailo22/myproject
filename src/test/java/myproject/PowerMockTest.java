package myproject;

import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticClass.class)
public class PowerMockTest {
	
	@Test
	public void shouldMockStaticClass() {
		// Given
		mockStatic(StaticClass.class);
		Mockito.when(StaticClass.getMyName()).thenReturn("My name is static");
		
		// When
		
		// Then
		
	}

}
