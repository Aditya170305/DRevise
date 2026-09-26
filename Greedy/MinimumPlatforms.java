import java.util.Arrays;

public class MinimumPlatforms {

    public int minPlatform(int arr[], int dep[]) {
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 0 , j = 0;
        int count = 0 , maxCount = 0;
        
        int n = arr.length;
        
        while(i < n){
            
            if(arr[i] <= dep[j]){
                
                count++;
                i = i + 1;
                
            }
            
            else{
                
                count--;
                j = j + 1;
                
            }
            
            maxCount = Math.max(count , maxCount);
            
        }
        
        return maxCount;
        
    }

}
