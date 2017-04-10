package myproject.java8.mixins;

import java.util.List;

public interface Ship {

	List<Cargo> getCargoes();
	
	default void addCargo(Cargo c) {
		getCargoes().add(c);
	}
	
	default void removeCargo(Cargo c) {
		getCargoes().remove(c);
	}
}
