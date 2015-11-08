package myproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Main3 {
	
	static Map<String, Integer> dist = new HashMap<>();
	static Map<String, String> prev = new HashMap<>();
	static Map<String, List<String>> edgesTo = new HashMap<>();
	
	public static class Node {
		String name;
		
		Node(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String toString() {
			return name;
		}
		
	}

	static Node[][] map = new Node[][] {
			{null,new Node("B"),new Node("C")},
			{null,null,new Node("C")},
			{null,null,null},
	};
	
	public static void main(String[] args) {
		
		
		for (int i = 0; i<map.length; i++) {
			for (int j = 0; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		// from 'A' to 'C'
		Queue<String> q = new LinkedList<String>();
		q.add("A");
		dist.put("A", 0);
		
		while (!q.isEmpty()) {
			String v = q.remove();
			List<String> edges = new ArrayList<>();
			for (Node n : adj(v)) {
				String w = n.getName();
				if (edgesTo.get(w) == null) {
					edgesTo.put(w, edges);
				} else {
					edges = edgesTo.get(w);
				}
				edges.add(v);
                if (dist.get(w) == null) {
                    q.add(w);
                    dist.put(w, 1 + dist.get(v));
                    prev.put(w, v);
                }
            }
			
		}
		
		System.out.println("dist: " + dist);
		System.out.println("prev: " + prev);
		System.out.println("edgesTo: " + edgesTo);
		
		for (String v : pathTo("C")) {
            System.out.println("   " + v);
        }
        System.out.println("distance " + distanceTo("C"));
	}
	
	public static List<Node> adj(String v) {
		List<Node> list = new ArrayList<>();
		int index = index(v);
		for (int i = 0; i < map[index].length; i++) {
			if(map[index][i] != null) {
				list.add(map[index][i]);
			}
		}
		
		return list;
	}
	
	public static boolean hasPathTo(String v) {
		return dist.get(v) != null;
	}

	public static int distanceTo(String v) {
		if (!hasPathTo(v)) return Integer.MAX_VALUE;
		return dist.get(v);
	}
	public static Iterable<String> pathTo(String v) {
        Stack<String> path = new Stack<String>();
        while (v != null && dist.get(v) != null) {
            path.push(v);
            v = prev.get(v);
        }
        return path;
    }
	
	public static int index(String v) {
		if ("A".equals(v)) {
			return 0;
		} else if ("B".equals(v)) {
			return 1;
		} else if ("C".equals(v)) {
			return 2;
		}
		
		return -1;
	}
}
