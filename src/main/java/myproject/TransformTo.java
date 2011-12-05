package myproject;

import java.util.LinkedHashMap;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class TransformTo implements Function<LinkedHashMap<String,String>, String> {
	@Override
    public String apply(final LinkedHashMap<String,String> input){
		List<String> list = Lists.newArrayList();
		for (String key : input.keySet()) {
			StringBuilder builder = new StringBuilder();
			builder.append("\"");
			builder.append(key);
			builder.append("\"");
			builder.append(" : ");
			builder.append("\"");
			builder.append(input.get(key));
			builder.append("\"");
			list.add(builder.toString()); 
		}
		return Joiner.on(",").join(list);
    }

}