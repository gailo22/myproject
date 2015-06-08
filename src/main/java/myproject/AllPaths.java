package myproject;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


/*************************************************************************
 *  Compilation:  javac AllPaths.java
 *  Execution:    java AllPaths
 *  Depedencies:  Graph.java
 *  
 *  Find all paths from s to t.
 *  
 *  % java AllPaths
 *  A: B C 
 *  B: A F 
 *  C: A D F 
 *  D: C E F G 
 *  E: D G 
 *  F: B C D 
 *  G: D E 
 * 
 *  [A, B, F, C, D, E, G]
 *  [A, B, F, C, D, G]
 *  [A, B, F, D, E, G]
 *  [A, B, F, D, G]
 *  [A, C, D, E, G]
 *  [A, C, D, G]
 *  [A, C, F, D, E, G]
 *  [A, C, F, D, G]
 *
 *  [B, A, C, D, F]
 *  [B, A, C, F]
 *  [B, F]
 *
 *  Remarks
 *  --------
 *   -  Currently prints in reverse order due to stack toString()
 *
 *************************************************************************/

public class AllPaths<Vertex> {

    private Stack<String> path  = new Stack<String>();   // the current path
    private Set<String> onPath  = new HashSet<String>();     // the set of vertices on the path

    public AllPaths(Graph G, String s, String t) {
        enumerate(G, s, t);
    }

    // use DFS
    private void enumerate(Graph G, String v, String t) {

        // add node v to current path from s
        path.push(v);
        onPath.add(v);

        // found path from s to t - currently prints in reverse order because of stack
        if (v.equals(t)) System.out.println(path);

        // consider all neighbors that would continue path with repeating a node
        else {
            for (String w : G.adjacentTo(v)) {
                if (!onPath.contains(w)) enumerate(G, w, t);
            }
        }

        // done exploring from v, so remove from path
        path.pop();
        onPath.remove(v);
    }

    public static void main(String[] args) {
        Graph G = new Graph();
        G.addEdge("A", "B");
        G.addEdge("A", "C");
        G.addEdge("C", "D");
        G.addEdge("D", "E");
        G.addEdge("C", "F");
        G.addEdge("B", "F");
        G.addEdge("F", "D");
        G.addEdge("D", "G");
        G.addEdge("E", "G");
        System.out.println(G);
        System.out.println("--------");
        AllPaths allpaths1 = new AllPaths(G, "A", "E");
        System.out.println("--------");
        AllPaths allpaths2 = new AllPaths(G, "B", "F");
    }

}
