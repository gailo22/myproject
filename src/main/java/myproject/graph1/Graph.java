package myproject.graph1;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {

	private HashMap<String, Vertex> vertices;
	private HashSet<Edge> edges;

	public Graph() {
		this.vertices = new HashMap<>();
		this.edges = new HashSet<>();
	}

	private void addEdge(Vertex u, Vertex v) {
		addEdge(u, v, 1);
	}
	
	public boolean addEdge(Vertex u, Vertex v, int weight) {
		if (u.equals(v)) return false;
		
		Edge e = new Edge(u, v, weight);
        if(edges.contains(e)) {
        	return false;
        } else if (u.containsNeighbor(e) || v.containsNeighbor(e)) {
        	return false;
        }
        
		edges.add(e);
		u.addNeighbor(e);
		v.addNeighbor(e);
		return true;
	}
	
	private boolean addVertex(Vertex v) {
        vertices.put(v.getLabel(), v);
        return true;
	}
	
	public boolean containsEdge(Edge e) {
		return edges.contains(e);
	}

	public boolean containsVertex(Vertex vertex) {
		return vertices.get(vertex.getLabel()) != null;
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph();

		Vertex[] vs = new Vertex[5];
		for (int i = 0; i < vs.length; i++) {
			vs[i] = new Vertex("" + i);
			graph.addVertex(vs[i]);
		}

		for (int i = 0; i < vs.length - 1; i++) {
			for (int j = i + 1; j < vs.length; j++) {
				graph.addEdge(vs[i], vs[j]);
				graph.addEdge(vs[i], vs[j]);
				graph.addEdge(vs[j], vs[i]);
			}
		}

		for (int i = 0; i < vs.length; i++) {
			System.out.println(vs[i]);

			for (int j = 0; j < vs[i].getNeighborCount(); j++) {
				System.out.println(vs[i].getNeighbor(j));
			}

			System.out.println();
		}
	}

}
