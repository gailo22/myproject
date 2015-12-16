package myproject.berlinclock;

import java.util.function.BiFunction;


public interface Lamp extends Partitionable {
	
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
		for (int i = 0; i < onLamps; i++) {
			builder.append(getOnColor(i));
		}

		for (int i = onLamps; i < getSize(); i++) {
			builder.append(LampColor.getOffColor());
		}

		return builder.toString();
    }
}
