import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

public class MakingALargeIsland {
    
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 0) continue;

                int dr [] = {-1 , 0 , +1 , 0};
                int dc [] = {0 , -1 , 0 , +1};

                for(int ind=0;ind<4;ind++){

                    int newr = i + dr[ind];
                    int newc = j + dc[ind];

                    if(newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 1){

                        int nodeNo = i * n + j;
                        int adjNodeNo = newr * n + newc;

                        ds.unionBySize(nodeNo , adjNodeNo);

                    }
                }
            }
        }

        int max = 0;

        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){

                if(grid[row][col] == 1) continue;

                int dr [] = {-1 , 0 , +1 , 0};
                int dc [] = {0 , -1 , 0 , +1};

                Set<Integer> st = new HashSet<Integer>();

                for(int ind=0;ind<4;ind++){

                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    if(newr >= 0 && newr < n && newc >= 0 && newc < n){

                        if(grid[newr][newc] == 1){

                            st.add(ds.findUPar(newr * n + newc));

                        }

                    }

                }

                int sizeTotal = 1;

                for(Integer parent : st){

                    sizeTotal = sizeTotal + ds.size.get(parent);

                }

                max = Math.max(sizeTotal , max);

            }
        }

        for(int cellNo=0;cellNo<n*n;cellNo++){

            max = Math.max(max , ds.size.get(ds.findUPar(cellNo)));

        }

        return max;

    }
}
