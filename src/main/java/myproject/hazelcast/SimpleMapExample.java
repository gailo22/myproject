package myproject.hazelcast;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class SimpleMapExample {

	public static void main(String[] args) {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		Map<String, String> capitals = hz.getMap("capitals");
		capitals.put("GB", "London");
		capitals.put("FR", "Paris");
		capitals.put("US", "Washington DC");
		capitals.put("AU", "Canberra");
		System.err.println("Known capital cities: " + capitals.size());
		System.err.println("Capital city of GB: " + capitals.get("GB"));
	}

}
