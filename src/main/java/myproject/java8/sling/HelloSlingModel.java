package myproject.java8.sling;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = SlingHttpServletRequest.class)
public class HelloSlingModel implements BaseSlingModel {
	
	@Inject
	private HelloSlingService service;
	
	@Inject
    protected SlingHttpServletRequest request;

    @Inject
    protected SlingHttpServletResponse response;
	
	@PostConstruct
    protected void init() {
		String name = request.getParameter("name");
		
		sayHello(name);
	}
	
	private String sayHello(String name) {
		String helloMsg = service.hello(name);
		
		return helloMsg;
	}

}
