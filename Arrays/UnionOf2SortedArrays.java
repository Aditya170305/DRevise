import java.util.ArrayList;

public class UnionOf2SortedArrays {
    
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int i = 0;
        int j = 0;
        
        int n1 = a.length;
        int n2 = b.length;
        
        while(i < n1 && j < n2){
            
            if(a[i] <= b[j]){
                
                if(ans.size() == 0 || ans.get(ans.size() - 1) != a[i]){
                    
                    ans.add(a[i]);
                    
                }
                
                i++;
                
            }
            
            else{
                
                if(ans.size() == 0 || ans.get(ans.size() - 1) != b[j]){
                    
                    ans.add(b[j]);
                    
                }
                
                j++;
                
            }
            
        }
        
        while(i < n1){
            
            if(ans.size() == 0 || ans.get(ans.size() - 1) != a[i]){
                
                ans.add(a[i]);
                
            }
            
            i++;
            
        }
        
        while(j < n2){
            
            if(ans.size() == 0 || ans.get(ans.size() - 1) != b[j]){
                
                ans.add(b[j]);
                
            }
            
            j++;
            
        }
        
        return ans;
        
    }
    
}
