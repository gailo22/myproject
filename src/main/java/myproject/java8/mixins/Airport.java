package myproject.java8.mixins;

import java.util.List;

public interface Airport {

	List<Aircraft> getAircrafts();

	default void land(Aircraft aircraft) {
		getAircrafts().add(aircraft);
	}

	default void depart(Aircraft aircraft) {
		getAircrafts().remove(aircraft);
	}
}
