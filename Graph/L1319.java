import java.util.ArrayList;
import java.util.List;

class DisjointSet {

    List<Integer> size;
    List<Integer> parent;

    public DisjointSet(int n){

        size = new ArrayList<Integer>();
        parent = new ArrayList<Integer>();

        for(int i=0;i<n;i++){

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

        if(ulp_u == ulp_v) return ;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v , size.get(ulp_v) + size.get(ulp_u));
        }

        else{
            parent.set(ulp_v , ulp_u);
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
        }

    }
}

public class L1319 {
    
    public int makeConnected(int n, int[][] connections) {
        
        DisjointSet ds = new DisjointSet(n);

        int n1 = connections.length;

        int extras = 0;

        for(int i=0;i<n1;i++){

            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.findUPar(u) == ds.findUPar(v)){
                extras++;
            }

            else{
                ds.unionBySize(u , v);
            }

        }

        int countC = 0;

        for(int i=0;i<n;i++){
            if(ds.parent.get(i) == i) countC++;
        }

        int ans = countC - 1;

        if(extras >= ans){
            return ans;
        }

        return -1;
    }
}
