package myproject;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {
	
	private boolean abc;
	private boolean ddd;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("HelloJob exceute...");
		Map<String,String> hashMap1 = new HashMap<String, String>();
		hashMap1.put("abc", new String());
		Set<String> abchSet = new LinkedHashSet<String>();
		abchSet.clear();
		abchSet.add("acb");
		ddd = abchSet.contains("dddd");
		abc = abchSet.add("ddeedd");
		abchSet.isEmpty();
	}
	
}