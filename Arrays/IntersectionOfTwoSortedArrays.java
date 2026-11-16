import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays {
    
    static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int i = 0;
        int j = 0;
        
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        while(i < n1 && j < n2){
            
            if(arr1[i] < arr2[j]){
                
                i++;
                
            }
            
            else if(arr2[j] < arr1[i]){
                
                j++;
                
            }
            
            else{
                
                if(ans.size() == 0 || ans.get(ans.size() - 1) != arr1[i]) ans.add(arr1[i]);
                i++;
                j++;
                
            }
            
        }
        
        return ans;
        
    }
    
}
