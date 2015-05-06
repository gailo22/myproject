package myproject;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainSimpleGraph {

    public static void main(String[] args) {
        Map<String, List<String>> G = new LinkedHashMap<>();
        G.put("a", Arrays.asList("b", "c"));
        G.put("b", Arrays.asList("c"));
        G.put("c", Arrays.asList("b"));
        
        for (String u : G.keySet()) {
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
    }
    
    private static List<String> adj(Map<String, List<String>> G, String u) {
        return G.get(u);
    }

}
