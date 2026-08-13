import java.util.ArrayList;
import java.util.List;

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
            size.set(ulp_v , size.get(ulp_v) + size.get(ulp_u));
        }

        else{
            parent.set(ulp_v , ulp_u);
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
        }

    }
}


public class NoOfProvinces {
    
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;

        DisjointSet ds = new DisjointSet(n);

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                if(isConnected[i][j] == 1) ds.unionBySize(i , j);

            }
        }

        int count = 0 ;

        for(int i=0;i<n;i++){

            if(ds.parent.get(i) == i) count++;

        }

        return count;

    }

}
