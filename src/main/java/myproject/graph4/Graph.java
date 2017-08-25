package myproject.graph4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
	
	private Map<Integer, Node> nodeLookup = new HashMap<>();
	
	private static class Node {
		private int id;
		private List<Node> adj = new LinkedList<>();
		
		Node(int id) {
			this.id = id;
		}
	}
	
	public Node getNode(int id) {
		Node node = nodeLookup.get(id);
		if (node == null) {
			Node newNode = new Node(id);
			nodeLookup.put(id, newNode);
			return newNode;
		}
		return node;
	}
	
	public void addEdge(int src, int dst) {
		Node s = getNode(src);
		Node d = getNode(dst);
		s.adj.add(d);
	}
	
	public void dfs(Node start) {
		Set<Integer> visited = new HashSet<>();
		dfs(start, visited);
	}
	
	private void dfs(Node start, Set<Integer> visited) {
		if (visited.contains(start.id)) {
			return;
		}
		
		visited.add(start.id);
		System.out.println("visit: " + start.id);
		for (Node node : start.adj) {
			dfs(node, visited);
		}
	}

	public void bfs(Node start) {
		LinkedList<Node> nextToVisit = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		nextToVisit.add(start);
		
		while (!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			
			if (visited.contains(node.id)) {
				continue;
			}
			
			visited.add(node.id);
			System.out.println("visit: " + node.id);
			
			for (Node child : node.adj) {
				nextToVisit.add(child);
			}
		}
	}
	
	public static void main(String[] args) {
		Graph G = new Graph();
		G.addEdge(1, 2);
		G.addEdge(1, 3);
		G.addEdge(2, 4);
		G.addEdge(3, 4);
		G.addEdge(4, 5);
		G.addEdge(5, 6);
		
		System.out.println("DFS: ");
		G.dfs(G.getNode(1));
		System.out.println();
		System.out.println("BFS: ");
		G.bfs(G.getNode(1));
	}

}
