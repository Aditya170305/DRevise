import java.util.ArrayList;

public class FirstAndLastOccurenceOfAnElement {
    
    int lowerBound(int arr [] , int x){
        
        int n = arr.length;
        
        int ans = n;
        
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(arr[mid] >= x){
                
                ans = mid;
                high = mid - 1;
                
            }
            
            else{
                
                low = mid + 1;
                
            }
            
        }
        
        return ans;
        
    }
    
    int upperBound(int arr [] , int x){
        
        int n = arr.length;
        
        int ans = n;
        
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(arr[mid] > x){
                
                ans = mid;
                high = mid - 1;
                
            }
            
            else{
                
                low = mid + 1;
                
            }
            
        }
        
        return ans;
        
    }
    
    ArrayList<Integer> find(int arr[], int x) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int lower_bound = lowerBound(arr , x);
        
        
        if(lower_bound == arr.length || arr[lower_bound] != x){
            
            ans.add(-1);
            ans.add(-1);
            
            return ans;
            
        }
        
        int upper_bound = upperBound(arr , x);
        
        if(arr[upper_bound - 1] != x){
            
            ans.add(lower_bound);
            ans.add(lower_bound);
            
        }
        
        else{
            
            ans.add(lower_bound);
            ans.add(upper_bound - 1);
            
        }
        
        return ans;
        
    }
    
}
