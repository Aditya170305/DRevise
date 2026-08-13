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
            parent.set(ulp_u , ulp_v);
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
        }
        
    }
    
}

public class NumberOfIslandsII {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        
        DisjointSet ds = new DisjointSet(rows * cols);
        int vis [][] = new int [rows][cols];
        int count = 0;
        
        List<Integer> ans = new ArrayList<Integer>();
        
        int len = operators.length;
        
        for(int i=0;i<len;i++){
            
            int row = operators[i][0];
            int col = operators[i][1];
            if(vis[row][col] == 1){
                ans.add(count);
                continue;
            }
            
            vis[row][col] = 1;
            count++;
            
            int dr [] = {-1 , 0 , +1 , 0};
            int dc [] = {0 , +1 , 0 , -1};
            
            for(int ind=0;ind<4;ind++){
                
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];
                
                if(adjr >= 0 && adjr < rows && adjc >= 0 && adjc < cols && vis[adjr][adjc] == 1){
                    int nodeNo = row * cols + col;
                    int adjNodeNo = adjr * cols + adjc;
                    if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)){
                        count--;
                        ds.unionBySize(nodeNo , adjNodeNo);
                    }
                }
            }
            
            ans.add(count);
            
        }
        
        return ans;
        
    }
}
