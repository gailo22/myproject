package myproject.berlinclock;

import java.util.function.BiFunction;


public class Hour implements Lamp, Partitionable {
	
	private BiFunction<Integer, Integer, Integer> partitioner;
	
	public Hour(BiFunction<Integer, Integer, Integer> partitioner) {
		this.partitioner = partitioner;
	}

	@Override
	public int getSize() {
		return 4;
	}

	@Override
	public String getOnColor(int index) {
		return LampColor.HOUR.getOnColor();
	}

	@Override
	public BiFunction<Integer, Integer, Integer> getPartitioner() {
		return partitioner;
	}

}
