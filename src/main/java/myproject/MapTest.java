package myproject;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;

public class MapTest {

	private String beautiful;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Map<String, String> map = buildMap();
		LinkedHashMap<String, String> map = Maps.newLinkedHashMap();
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		
		ImmutableMap<String,String> map2 =new ImmutableMap.Builder<String, String>().put("a", "a1").put("b", "b1").put("c", "c1").build();
		Builder<Integer, String> builder2 = new ImmutableMap.Builder<Integer, String>();
		Map<Integer,String> build = builder2.build();
		build.containsKey(map2);
		
		System.out.println(new TransformTo().apply(map));
		
		for (String key : map.keySet()) {
			System.out.println(key);
		}
		
		/*Map<String, String> transformed1 = Maps.transformValues(map, new Function<String, String>() {
			@Override
			public String apply(String input) {
				return "X" + input;
			}
			
		});
		
		System.out.println(transformed1);*/
		Map<String,String> transformed = Maps.transformEntries(map, new EntryTransformer<String, String, String>() {
			@Override
			public String transformEntry(String key, String value) {
				return "\"" + key +"\":\"" + value +"\"";
			}
		});
		
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append(Joiner.on(",").join(transformed.values()));
		builder.append("}");
		
		System.out.println(builder.toString());
	}
	
	private static Map<String, String> buildMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i < 10; i++) {
			map.put("" + i, "value " + i);
		}
		return Collections.unmodifiableMap(map);
	}
	
	private String doSomethingBeatiful(String beautiful) {
		this.beautiful = beautiful;
		MapTest mapTest = new MapTest();
		Map<String,String> hashMap = new HashMap<String, String>();
		App app = new App();
		Map<String,String> linkedHashMap = new LinkedHashMap<String, String>();
		return beautiful;
	}
	
}