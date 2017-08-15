package myproject.graph1;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String label;
	private List<Edge> neighbors;

	public Vertex(String label) {
		this.label = label;
		this.neighbors = new ArrayList<>();
	}

	public void addNeighbor(Edge edge) {
		if (neighbors.contains(edge)) return;

		neighbors.add(edge);
	}

	public boolean containsNeighbor(Edge other) {
		return neighbors.contains(other);
	}

	public String getLabel() {
		return label;
	}

	public int getNeighborCount() {
		return neighbors.size();
	}

	public Edge getNeighbor(int index) {
		return neighbors.get(index);
	}

	@Override
	public String toString() {
		return "Vertex " + label;
	}
}
