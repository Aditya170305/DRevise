import java.util.ArrayList;

public class L2685 {
    
    public void dfs(int node , ArrayList<ArrayList<Integer>> adj , int [] vis , int arr []) {

        vis[node] = 1;
        arr[0]++;

        for(int it : adj.get(node)){
            
            arr[1]++;

            if(vis[it] == 0){
                dfs(it , adj , vis , arr);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        
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
        int count = 0;
        int arr [] = new int [2];  

        for(int i=0;i<n;i++){

            if(vis[i] == 0){
                dfs(i , adj , vis , arr);
                int node = arr[0];
                int edge = arr[1] / 2;
                if(edge == (node * (node - 1)) / 2) count++;
                arr[0] = 0;
                arr[1] = 0;
            }
        }

        return count;

    }
    
}
