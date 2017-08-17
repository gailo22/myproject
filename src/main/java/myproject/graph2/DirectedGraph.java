package myproject.graph2;

public class DirectedGraph extends Graph {

	@Override
	public boolean addEdge(Node source, Node destination) {
		addNode(source);
		addNode(destination);
		boolean addEdgeSuccess = addEdgeFromTo(source, destination);
		if (addEdgeSuccess) {
			numEdges++;
		}
		return addEdgeSuccess;
	}

	@Override
	public boolean removeEdge(Node source, Node destination) {
		if (!containsNode(source) || !containsNode(destination)) {
			return false;
		}
		boolean removeEdgeSuccess = removeEdgeFromTo(source, destination);
		if (removeEdgeSuccess) {
			numEdges--;
		}
		return removeEdgeSuccess;
	}

}
