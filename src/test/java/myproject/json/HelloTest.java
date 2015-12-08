package myproject.json;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;


public class HelloTest {
	
	@Test
	public void shouldLoadJsonFileFromClasspath() throws Exception {
		// given
		Path jsonPath = Paths.get(this.getClass().getResource("/hello.json").toURI());
		
		// when
		ObjectMapper mapper = new ObjectMapper();
		Hello hello = mapper.readValue(jsonPath.toFile(), Hello.class);
		
		// then
		assertThat(hello.getHello(), is("World"));
		
	}

}
