public class AllocateMinimumPages {
    
    public int countStudents(int [] arr , long pages){
        
        int students = 1;
        int pageStudents = 0;
        
        for(int i=0;i<arr.length;i++){
            
            if(pageStudents + arr[i] <= pages){
                
                pageStudents = pageStudents + arr[i];
                
            }
            
            else{
                
                students++;
                pageStudents = arr[i];
                
            }
            
        }
        
        return students;
        
    }
    
    public int findPages(int[] arr, int k) {
        
        if(k > arr.length) return -1;
        
        long maxi = Integer.MIN_VALUE;
        long sum = 0;
        
        for(int i=0;i<arr.length;i++){
            
            maxi = Math.max(maxi , arr[i]);
            sum = sum + arr[i];
            
        }
        
        long low = maxi;
        long high = sum;
        
        long ans = -1;
        
        while(low <= high){
            
            long mid = (low + high) >> 1;
            
            if(countStudents(arr , mid) > k){
                
                low = mid + 1;
                
            }
            
            else{
                
                ans = mid;
                high = mid - 1;
                
            }
            
        }
        
        return (int)ans;
        
    }
    
}
