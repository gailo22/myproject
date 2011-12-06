package myproject;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ExampleJob extends QuartzJobBean {

	  private int timeout;
	private String abc;
	private Object object;
	  
	  /**
	   * Setter called after the ExampleJob is instantiated
	   * with the value from the JobDetailBean (5)
	   */ 
	  public void setTimeout(int timeout, String abc, Object object) {
	    this.timeout = timeout;
		this.abc = abc;
		this.object = object;
	  }
	  
	  protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
	      // do the actual work
		  System.out.println("in executeInternal.....");
		  
		///
	  }
	}
