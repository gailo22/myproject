package myproject.graph2;

public class UndirectedGraph extends Graph {

	@Override
	public boolean addEdge(Node node1, Node node2) {
		addNode(node1);
		addNode(node2);
		boolean addEdgeSuccess = addEdgeFromTo(node1, node2) && addEdgeFromTo(node2, node1);
		if (addEdgeSuccess) {
			numEdges++;
		}
		return addEdgeSuccess;
	}

	@Override
	public boolean removeEdge(Node node1, Node node2) {
		if (!containsNode(node1) || !containsNode(node2)) {
			return false;
		}
		boolean removeEdgeSuccess = removeEdgeFromTo(node1, node2) && removeEdgeFromTo(node2, node1);
		if (removeEdgeSuccess) {
			numEdges--;
		}
		return removeEdgeSuccess;
	}

}
