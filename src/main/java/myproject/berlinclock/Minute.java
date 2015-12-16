package myproject.berlinclock;

import java.util.function.BiFunction;

public class Minute implements Lamp, Partitionable {
	
	enum Type {
		TOP("Top"),
		BOTTOM("Bottom");
		
		String name;
		
		Type(String name) {
			this.name = name;
		}
	}
	
	private BiFunction<Integer, Integer, Integer> partitioner;
	
	private Type type;
	
	public Minute(Type type, BiFunction<Integer, Integer, Integer> partitioner) {
		this.type = type;
		this.partitioner = partitioner;
	}

	@Override
	public int getSize() {
		return Type.TOP == type? 11 : 4;
	}

	@Override
	public String getOnColor(int index) {
		if (Type.TOP == type && ((index+1) % 3) == 0) {
			return "R";
		}
		return LampColor.MIN.getOnColor();
	}

	@Override
	public BiFunction<Integer, Integer, Integer> getPartitioner() {
		return partitioner;
	}

}
