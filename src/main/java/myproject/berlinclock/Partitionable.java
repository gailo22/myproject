package myproject.berlinclock;

import java.util.function.BiFunction;

public interface Partitionable {

	BiFunction<Integer, Integer, Integer> getPartitioner(); 
}
