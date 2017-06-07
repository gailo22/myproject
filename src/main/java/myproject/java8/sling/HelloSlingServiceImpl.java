package myproject.java8.sling;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(name = "myproject.java8.sling.HelloSlingService",immediate = true)
public class HelloSlingServiceImpl implements HelloSlingService {

	@Activate
    protected void activate(final Map<String, Object> config) {
		
	}
	
	@Override
	public String hello(String name) {
		
		return "Hello, " + name;
	}

}
