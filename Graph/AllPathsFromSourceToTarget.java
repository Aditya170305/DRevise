import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    
    public void find(int src , int dst , int [][] graph , List<Integer> path , List<List<Integer>> ans){

        path.add(src);

        if(src == dst){

            ans.add(new ArrayList<> (path));

        }

        for(int it=0;it<graph[src].length;it++){

            find(graph[src][it] , dst , graph , path , ans);

        }

        path.remove(path.size() - 1);

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int n = graph.length;

        List<List<Integer>> ans = new ArrayList<>();

        find(0 , n - 1 , graph , new ArrayList<>() , ans);

        return ans;

        
    }
    
}
