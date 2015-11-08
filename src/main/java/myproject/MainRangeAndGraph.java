package myproject;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class MainRangeAndGraph {
    
    public static void main(String[] args) {
        
        Queue<Integer> q = new PriorityQueue<>();
        
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int nextInt = Math.abs(rand.nextInt() % 100);
            q.add(nextInt);
        }
        
        System.out.println("q: " + q);
        
        
        for (String s : range(10)) {
            System.out.println("s: " + s);
        }
        
//        Range<Integer> range = Range.closed(1, 10);
//
//        for (int r : ContiguousSet.create(range, DiscreteDomain.integers())) {
//            System.out.println("r: " + r);
//        }
        
        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path name: dirs) {
            System.out.println(name);
        }
        
        int[][] g = new int[][] {{0,1,1},
                                 {0,0,1},
                                 {0,1,0}};
        
        System.out.println("-------------");
        for (int i = 0; i<g.length; i++) {
            for (int j=0; j<g[i].length; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
        
        
//        System.out.println("--- walk--");
//        walk(g, 0);
        
        System.out.println("--- dfs--");
        dfs(g, 0);
        
        System.out.println("--- bfs--");
        bfs(g, 0);
        
        System.out.println("--- allPaths--");
        List<List<String>> allPaths = allPaths(g, 0, 2, new ArrayList<String>());
        System.out.println("allPaths: " + allPaths);
        
    }

    private static Iterable<String> range(int n) {
        return new RangeIter(n);
    }
    
    private static class RangeIter implements Iterable<String> {
        
        private int start;
        private int end;
        
        public RangeIter(int n) {
            this.start = 0;
            this.end = n;
        }
        
        @Override
        public Iterator<String> iterator() {
            return new Iterator<String>() {
                
                @Override
                public void remove() {
                }
                
                @Override
                public String next() {
                    return "hello-" + start++;
                }
                
                @Override
                public boolean hasNext() {
                    return start < end;
                }
            };
        }
    }
    
    private static List<Integer> adj(int[][] g, int v) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<g[v].length; i++) {
            if (g[v][i] > 0) {
                list.add(i);
            }
        }
        return list;
    }
    
    // not support cycle
    private static void walk(int[][] g, int s) {
        System.out.println("v: " + s);
        for (int w : adj(g, s)) {
            walk(g, w);
        }
    }
    
    private static void dfs(int[][] g, int s) {
        boolean[] marked = new boolean[g.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(s);
        System.out.println("s: " + s);
        
        while (!stack.isEmpty()) {
            Integer u = stack.pop();
            for (int v : adj(g, u)) {
                if (marked[v] == false) {
                    marked[v] = true;
                    stack.add(v);
                    System.out.println("v: " + v);
                }
            }
        }
    }
    
    private static void bfs(int[][] g, int s) {
        boolean[] marked = new boolean[g.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        System.out.println("s: " + s);
        
        while (!queue.isEmpty()) {
            Integer u = queue.remove();
            for (int v : adj(g, u)) {
                if (marked[v] == false) {
                    marked[v] = true;
                    queue.add(v);
                    System.out.println("v: " + v);
                }
            }
        }
    }
    
    // TODO: check again
    private static List<List<String>> allPaths(int[][] g, int s, int end, List<String> path) {
        path.add(String.valueOf(s));

        if (s == end) {
            List<List<String>> p = new ArrayList<>();
            p.add(path);
            return p;
        }
//        if (g[0][0] == 0) return new ArrayList<>();

        List<List<String>> paths = new ArrayList<>();
        for (int u : adj(g, s)) {
            if (!path.contains(u)) {
                List<List<String>> newPaths = allPaths(g, u, end, path);
                
                for (List<String> newPath : newPaths) {
                    paths.add(newPath);
                }
            }
        }

        return paths;
    }

}
