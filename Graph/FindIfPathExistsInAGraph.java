import java.util.ArrayList;

public class FindIfPathExistsInAGraph {
    
    public boolean find(ArrayList<ArrayList<Integer>> adj , int source , int destination , int [] vis){

        if(source == destination) return true;

        vis[source] = 1;

        for(int it : adj.get(source)){

            if(vis[it] == 0) if(find(adj , it , destination , vis)) return true;

        }

        return false;

    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){

            adj.add(new ArrayList<>());

        }

        for(int i=0;i<edges.length;i++){

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        int vis [] = new int [n];

        return find(adj , source , destination , vis);

    }
    
}
