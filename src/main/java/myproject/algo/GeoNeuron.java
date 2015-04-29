package myproject.algo;

public class GeoNeuron {

	public double x, y;
	public double wx, wy;
	public int update, choose;

	public GeoNeuron(double x, double y) {
		this.x = x;
		this.y = y;

		this.wx = Math.random();
		this.wy = Math.random();

		update = 0;
		choose = 0;

	}

	public double dist(GeoNeuron c) {
		double dx = this.x - c.x;
		double dy = this.y - c.y;

		return Math.sqrt(dx * dx + dy * dy);

	}

	public double wdist(GeoNeuron c) {
		double dx = this.wx - c.wx;
		double dy = this.wy - c.wy;

		return Math.sqrt(dx * dx + dy * dy);

	}

}