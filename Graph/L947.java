import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DisjointSet {

    List<Integer> size;
    List<Integer> parent;

    public DisjointSet(int n){

        size = new ArrayList<Integer>();
        parent = new ArrayList<Integer>();

        for(int i=0;i<=n;i++){

            size.add(1);
            parent.add(i);

        }

    }

    public int findUPar(int node){

        if(node == parent.get(node)){
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);

    }

    public void unionBySize(int u , int v){

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v , size.get(ulp_u) + size.get(ulp_v));
        }

        else{
            parent.set(ulp_v , ulp_u);
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
        }

    }

}


public class L947 {
    
    public int removeStones(int[][] stones) {
        
        int maxRow = 0;
        int maxCol = 0;

        for(int i=0;i<stones.length;i++){

            maxRow = Math.max(maxRow , stones[i][0]);
            maxCol = Math.max(maxCol , stones[i][1]);

        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);

        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();

        for(int i=0;i<stones.length;i++){

            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;

            ds.unionBySize(nodeRow , nodeCol);
            mpp.put(nodeRow , 1);
            mpp.put(nodeCol , 1);

        }

        int count = 0;

        for(Map.Entry<Integer , Integer> it : mpp.entrySet()){
            if(ds.findUPar(it.getKey()) == it.getKey()){
                count++;
            }
        }

        return stones.length - count;

    }
}
