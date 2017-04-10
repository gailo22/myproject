package myproject.java8.mixins;

import java.util.ArrayList;
import java.util.List;

public class AircraftCarrier implements Ship, Airport {

	List<Aircraft> aircrafts = new ArrayList<>();
	List<Cargo> cargoes = new ArrayList<>();

	@Override
	public List<Aircraft> getAircrafts() {
		return aircrafts;
	}

	@Override
	public List<Cargo> getCargoes() {
		return cargoes;
	}
	
	public static void main(String[] args) {
		AircraftCarrier carrier = new AircraftCarrier();
		
		Cargo c = new Cargo();
		Aircraft a = new Aircraft();
		
		carrier.addCargo(c);
		carrier.land(a);
	}

}
