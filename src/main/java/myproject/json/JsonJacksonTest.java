package myproject.json;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonJacksonTest {

	public static void main(String[] args) throws Exception {
		
		Path jsonPath = Paths.get(Thread.currentThread()
				.getContextClassLoader().getResource("hello.json").toURI());
		
		ObjectMapper mapper = new ObjectMapper();
		Hello hello = mapper.readValue(jsonPath.toFile(), Hello.class);

		System.out.println("jsonPath: " + jsonPath);
		System.out.println("hello: " + hello);
	}

}
