import java.util.Arrays;

public class TwoSum {
    
    boolean twoSum(int arr[], int target) {
        
        int n = arr.length;
        
        Arrays.sort(arr);
        
        int i = 0;
        int j = n - 1;
        
        while(i < j){
            
            int sum = arr[i] + arr[j];
            
            if(sum == target) return true;
            
            if(sum < target) i++;
            
            else j--;
            
        }
        
        return false;
        
    }
    
}
