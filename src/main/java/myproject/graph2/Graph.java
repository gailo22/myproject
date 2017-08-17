package myproject.graph2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class Graph {

	protected Map<Node, Set<Edge>> adj;
	protected int numNodes;
	protected int numEdges;
	protected Map<String, Node> elementToNode;
	
	public Graph() {
		this.adj = new HashMap<>();
		this.elementToNode = new HashMap<>();
		this.numNodes = 0;
		this.numEdges = 0;
	}
	
	public abstract boolean addEdge(Node node1, Node node2);
	public abstract boolean removeEdge(Node node1, Node node2);
	
	public boolean addNode(Node newNode) {
		if (newNode == null || containsNode(newNode)) {
			return false;
		}
		Set<Edge> newAdj = new HashSet<>();
		adj.put(newNode, newAdj);
		elementToNode.put(newNode.getElement(), newNode);
		numNodes++;
		return true;
	}
	
	public Set<Node> getNodeNeighbors(Node node) {
		if (!containsNode(node)) {
			return null;
		}
		Set<Edge> nodeEdges = adj.get(node);
		Set<Node> nodeNeighbors = new HashSet<>();
		for (Edge e : nodeEdges) {
			Node neighbor = e.getDestination();
			nodeNeighbors.add(neighbor);
		}
		return nodeNeighbors;
	}
	
	protected boolean addEdgeFromTo(Node source, Node destination) {
		Edge newEdge = new Edge(source, destination);
		Set<Edge> sourceEdges = adj.get(source);
		if (!sourceEdges.contains(newEdge)) {
			sourceEdges.add(newEdge);
			return true;
		}
		return false;
	}
	
	protected boolean removeEdgeFromTo(Node source, Node destination) {
		Edge toRemove = new Edge(source, destination);
		Set<Edge> sourceEdges = adj.get(source);
		if (!sourceEdges.contains(toRemove)) {
			sourceEdges.remove(toRemove);
			return true;
		}
		return false;
	}
	
	public int getNumNodes() {
		return numNodes;
	}
	
	public int getNumEdges() {
		return numEdges;
	}
	
	public Node getStartingNode() {
		Iterator<Node> iterator = adj.keySet().iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		}
		return null;
	}
	
	public Set<Node> getAllNodes() {
		return adj.keySet();
	}
	
	public Set<Edge> getNodeEdges(Node node) {
		if (!containsNode(node)) {
			return null;
		}
		return adj.get(node);
	}
	
	public Node getNode(String element) {
		if (!elementToNode.containsKey(element)) {
			Node newNode = new Node(element);
			elementToNode.put(element, newNode);
			return newNode;
		}
		return elementToNode.get(element);
	}
	
	public boolean containsNode(Node node) {
		return adj.containsKey(node);
	}
	
	public boolean containsElement(String element) {
		return elementToNode.containsKey(element);
	}
}
