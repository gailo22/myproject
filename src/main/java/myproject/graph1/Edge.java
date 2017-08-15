package myproject.graph1;

public class Edge implements Comparable<Edge> {
	
	private Vertex u, v;
	private int weight;

	public Edge(Vertex u, Vertex v, int weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge other) {
		return this.weight - other.weight;
	}
	
	@Override
	public String toString() {
		return "({" + u + ", " + v + "}, " + weight + ")";
	}

}
