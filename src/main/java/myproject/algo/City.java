package myproject.algo;

public class City {

	public double x, y;
	public int update, choose;

	public City(double x, double y) {
		this.x = x;
		this.y = y;

		update = 0;
		choose = 0;

	}

	public double dist(City c) {
		double dx = this.x - c.x;
		double dy = this.y - c.y;

		return Math.sqrt(dx * dx + dy * dy);

	}

}