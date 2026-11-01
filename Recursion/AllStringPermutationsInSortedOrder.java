import java.util.ArrayList;
import java.util.Collections;

public class AllStringPermutationsInSortedOrder {
    
    public void find(int index , char [] arr , ArrayList<String> ans){
        
        if(index == arr.length){
            
            ans.add(new String(arr));
            return;
            
        }
        
        for(int i=index;i<arr.length;i++){
            
            swap(i , index , arr);
            find(index + 1 , arr , ans);
            swap(i , index , arr);
            
        }
        
    }
    
    public void swap(int a , int b , char [] arr){
        
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        
    }
    
    public ArrayList<String> permutation(String s) {
        
        ArrayList<String> ans = new ArrayList<String>();
        
        char [] arr = s.toCharArray();
        
        find(0 , arr , ans);
        
        Collections.sort(ans);
        
        return ans;
        
    }
    
}
