package myproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class MainSimpleGraph {

	private static Stack<String> path  = new Stack<String>();
    private static Set<String> onPath  = new HashSet<String>();
    
    public static void main(String[] args) {
        Map<String, List<String>> G = new LinkedHashMap<>();
//        G.put("a", Arrays.asList("b", "c"));
//        G.put("b", Arrays.asList("c"));
//        G.put("c", Arrays.asList("b"));
        addEdge(G, "a", "b");
        addEdge(G, "a", "c");
        addEdge(G, "b", "c");
        addEdge(G, "c", "b");
        
        for (String u : vertices(G)) {
            StringBuilder sb = new StringBuilder();
            sb.append(u +"-> [");
            String delim = "";
            for (String v : adj(G, u)) {
                sb.append(delim);
                sb.append(v);
                delim = ",";
            }
            sb.append("]");
            
            System.out.println(sb);
            
//          a-> [b,c]
//          b-> [c]
//          c-> [b]
        }
        
        
        allPaths(G, "a", "c");
        
    }
    
    private static void addVertex(Map<String, List<String>> g, String u) {
        if (!hasVertex(g, u)) g.put(u, new ArrayList<String>());
    }
    
	private static void addEdge(Map<String, List<String>> g, String v, String w) {
		if (!hasVertex(g, v)) addVertex(g, v);
		if (!hasVertex(g, w)) addVertex(g, w);
		// if (!hasEdge(g, v, w)) E++;
		g.get(v).add(w);
//		g.get(w).add(v);
	}
    
	private static Iterable<String> vertices(Map<String, List<String>> g) {
		return g.keySet();
	}

	private static List<String> adj(Map<String, List<String>> g, String u) {
		return g.get(u);
	}

	private static int degree(Map<String, List<String>> g, String u) {
		return g.get(u).size();
	}
	
	private static boolean hasVertex(Map<String, List<String>> g, String u) {
        return g.containsKey(u);
    }
	
	private static boolean hasEdge(Map<String, List<String>> g, String u, String v) {
        return g.get(u).contains(v);
    }
	
    private static void allPaths(Map<String, List<String>> g, String u, String v) {
        path.push(u);
        onPath.add(u);

        if (u.equals(v)) {
        	System.out.println(path);
        }
        else {
            for (String w : adj(g, u)) {
                if (!onPath.contains(w)) allPaths(g, w, v);
            }
        }

        path.pop();
        onPath.remove(u);
    }

}
