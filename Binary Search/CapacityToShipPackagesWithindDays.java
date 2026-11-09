import java.util.ArrayList;

public class CapacityToShipPackagesWithindDays {
    
    public boolean find(int capacity , ArrayList<Integer> arr , int d){
        
        int days = 1;
        int load = arr.get(0);
        
        for(int i=1;i<arr.size();i++){
            
            if(load + arr.get(i) <= capacity){
                
                load = load + arr.get(i);
                
            }
            
            else{
                
                load = arr.get(i);
                days++;
                
            }
            
        }
        
        return (days <= d);
        
    }
    
    public int leastWeightCapacity(ArrayList<Integer> arr, int d) {
        
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0;i<arr.size();i++){
            
            maxi = Math.max(maxi , arr.get(i));
            sum = sum + arr.get(i);
            
        }
        
        int low = maxi;
        int high = sum;
        
        int ans = 0;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(find(mid , arr , d)){
                
                ans = mid;
                high = mid - 1;
                
            }
            
            else{
                
                low = mid + 1;
                
            }
            
        }
        
        return ans;
        
    }
    
}
