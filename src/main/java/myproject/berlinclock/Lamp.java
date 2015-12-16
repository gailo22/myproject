package myproject.berlinclock;

import java.util.function.BiFunction;
import java.util.stream.IntStream;


public interface Lamp {
	
	int getSize();
	
	String getOnColor(int index);
	
    default int getDivision() {
    	return 5;
    }
    
    default BiFunction<Integer, Integer, Integer> getPartitioner() {
    	return getPartitioner();
    }
    
    default String getColors(Integer time) {
    	StringBuilder builder = new StringBuilder(getSize());
    	int onLamps = getPartitioner().apply(time, getDivision());
		IntStream.range(0, onLamps)
		         .forEach((i) -> builder.append(getOnColor(i)));
		
		IntStream.range(onLamps, getSize())
		         .forEach((i) -> builder.append(LampColor.getOffColor()));

		return builder.toString();
    }
}
