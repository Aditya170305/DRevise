import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L331 {
    
    public void dfs(int currNode , String s , int [] parent , List<List<Integer>> adj , int [] last , int [] ans){

        int c = s.charAt(currNode) - 'a';

        int nearestAnsector = last[c];

        last[c] = currNode;

        for(int child : adj.get(currNode)){

            dfs(child , s , parent , adj , last , ans);

        }

        last[c] = nearestAnsector;

        if(currNode != 0){

            int newParent = parent[currNode];

            if(nearestAnsector != -1){

                newParent = nearestAnsector;

            }

            parent[currNode] = newParent;

            ans[newParent] = ans[newParent] + ans[currNode];

        }

    }

    public int[] findSubtreeSizes(int[] parent, String s) {
        
        int n = parent.length;

        List<List<Integer>> adj = new ArrayList<>();

        int ans [] = new int [n];

        Arrays.fill(ans , 1);

        int last [] = new int [26];

        Arrays.fill(last , -1);

        for(int i=0;i<n;i++){

            adj.add(new ArrayList<>());

        }

        for(int i=1;i<n;i++){

            int u = parent[i];
            int v = i;

            adj.get(u).add(v);

        }

        dfs(0 , s , parent , adj , last , ans);

        return ans;

    }
    
}
