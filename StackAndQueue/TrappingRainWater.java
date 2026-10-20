public class TrappingRainWater {
    
    public int maxWater(int arr[]) {
        
        int n = arr.length;
        int prefMax [] = new int [n];
        int suffMax [] = new int [n];
        
        prefMax[0] = arr[0];
        
        for(int i=1;i<n;i++){
            prefMax[i] = Math.max(prefMax[i - 1] , arr[i]);
        }
        
        suffMax[n - 1] = arr[n - 1];
        
        for(int i=n-2;i>=0;i--){
            suffMax[i] = Math.max(suffMax[i + 1] , arr[i]);
        }
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            
            int leftMax = prefMax[i];
            int rightMax = suffMax[i];
            
            if(arr[i] < leftMax && arr[i] < rightMax){
                ans = ans + Math.min(leftMax , rightMax) - arr[i];
            }
            
        }
        
        return ans;
        
    }
    
}
