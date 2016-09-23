package myproject.gson;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

public class GsonTest {

	public static void main(String[] args) {
		
		// (Serialization)
		Gson gson = new Gson();
		gson.toJson(1);            // prints 1
		gson.toJson("abcd");       // prints "abcd"
		gson.toJson(new Long(10)); // prints 10
		int[] values = { 1 };
		gson.toJson(values);       // prints [1]
		
		// (Deserialization)
		int one = gson.fromJson("1", int.class);
		Integer one1 = gson.fromJson("1", Integer.class);
		Long one2 = gson.fromJson("1", Long.class);
		Boolean f = gson.fromJson("false", Boolean.class);
		String str = gson.fromJson("\"abc\"", String.class);
		//String anotherStr = gson.fromJson("[\"abc\"]", String.class);
		
		
		// (Serialization)
		BagOfPrimitives obj = new BagOfPrimitives();
		Gson gson1 = new Gson();
		String json1 = gson.toJson(obj);  // json is {"value1":1,"value2":"abc"}
		
		// (Deserialization)
		BagOfPrimitives obj2 = gson.fromJson(json1, BagOfPrimitives.class);  // obj == obj2
		
		
		
		ResumeInfo info1 = new ResumeInfo();
		info1.setName("info1");
		Summary summary1 = new Summary();
		summary1.setName("summary1");
		Summary summary2 = new Summary();
		summary2.setName("summary2");
		Occupation occupation1 = new Occupation();
		occupation1.setName("Occupation1");
		
		info1.setSummarys(Lists.newArrayList(summary1, summary2));
		info1.setOccupations(Lists.newArrayList(occupation1));
		
		ResumeInfo info2 = new ResumeInfo();
		info2.setName("info2");
		
		Resume resume = new Resume();
		resume.setName("resume1");
		resume.setResumeInfos(Lists.newArrayList(info1, info2));
		
		Gson gson2 = new Gson();
		System.out.println(gson2.toJson(resume));

	}

}
