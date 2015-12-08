package myproject.json;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonJacksonTest {

	public static void main(String[] args) throws Exception {
		
		Path jsonPath = Paths.get(Thread.currentThread()
				                        .getContextClassLoader()
				                        .getResource("hello.json")
				                        .toURI());
		
		ObjectMapper mapper = new ObjectMapper();
		Hello hello = mapper.readValue(jsonPath.toFile(), Hello.class);

		System.out.println("jsonPath: " + jsonPath);
		System.out.println("hello: " + hello);
		
		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(hello);
		System.out.println("jsonString: " + jsonString);
	}

}
