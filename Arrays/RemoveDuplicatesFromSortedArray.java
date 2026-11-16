import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {
    
    ArrayList<Integer> removeDuplicates(int[] arr) {
        
        int i = 0;
        
        for(int j=1;j<arr.length;j++){
            
            if(arr[j] != arr[i]){
                
                arr[i + 1] = arr[j];
                i++;
                
            }
            
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int k=0;k<=i;k++){
            
            ans.add(arr[k]);
            
        }
        
        return ans;
        
    }
    
}
