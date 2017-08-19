package myproject.graph3;

public class Edge {
	
	private final int u;
	private final int v;
	private final double weight;
	
	public Edge(int u, int v, double weight) {
	    this.u = u;
	    this.v = v;
	    this.weight = weight;
    }
	
	public int from() {
		return u;
	}
	
	public int to() {
		return v;
	}
	
	public double weigth() {
		return weight;
	}
	
	@Override
    public String toString() {
        return u + "->" + v + " " + String.format("%5.2f", weight);
    }

}
