public class SortZerosOnesTwos {
    
    public void sort012(int[] arr) {
        
        int n = arr.length;
        
        int count0 = 0 , count1 = 0 , count2 = 0;
        
        for(int i=0;i<n;i++){
            
            if(arr[i] == 0) count0++;
            else if(arr[i] == 1) count1++;
            else count2++;
            
        }
        
        for(int i=0;i<n;i++){
            
            if(count0 != 0){
                
                arr[i] = 0;
                count0--;
                
            }
            
            else if(count1 != 0){
                
                arr[i] = 1;
                count1--;
                
            }
            
            else{
                
                arr[i] = 2;
                count2--;
                
            }
            
        }
        
    }
    
}
