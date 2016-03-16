package myproject.lombok;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
	
	private Integer id;
    private String firstName;
    
    public static void main(String[] args) {
    	CustomerBuilder builder = new CustomerBuilder();
    	builder.id(123).firstName("Hello");
    	
    	System.out.println(builder.build()); 
    }

}
