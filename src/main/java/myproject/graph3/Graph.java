package myproject.graph3;

import java.util.LinkedList;
import java.util.List;

public class Graph {

	private final int V;
	private int E;
	private List<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		this.adj = new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		if (u < 0 || u >= V) throw new IndexOutOfBoundsException("vertex " + u + " is not between 0 and " + (V - 1));
		if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V - 1));
		adj[u].add(v);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
		return adj[v];
	}

}
