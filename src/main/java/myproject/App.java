package myproject;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.collect.ArrayListMultimap;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-job.xml" });

		context.registerShutdownHook();
		
		TaskExecutorExample example = context.getBean(TaskExecutorExample.class);
		example.printMessages();
		
	}
	
	public void test2() {
		ArrayListMultimap<String, String> multiMap = ArrayListMultimap.create();
		multiMap.put("1", "a");
		multiMap.put("1", "aa");
		multiMap.put("2", "b");
		multiMap.put("3", "c");
		multiMap.put("3", "cc");
		multiMap.put("3", "ccc");
		multiMap.put("4", "d");
		System.out.println(multiMap.asMap());
	}
	
}
