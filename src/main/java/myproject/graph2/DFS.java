package myproject.graph2;

import java.util.HashSet;
import java.util.Set;

public class DFS {
	
	protected Set<Node> marked;
	protected Graph graph;
	
	public DFS(Set<Node> marked, Graph graphToSearch) {
		this.marked = new HashSet<>();
		this.graph = graphToSearch;
	}
	
	public boolean dfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
			return false;
		}
		if (start.getElement().equals(elementToFind)) {
			return true;
		} else {
			marked.add(start);
			for (Node neighbor : graph.getNodeNeighbors(start)) {
				if (!marked.contains(neighbor) && dfs(neighbor, elementToFind)) {
					return true;
				}
			}
			return false;
		}
	}

}
