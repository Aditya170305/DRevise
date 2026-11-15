public class SecondLargestElement {
    
    public int getSecondLargest(int[] arr) {
        
        int second_maxi = -1;
        int maxi = arr[0];
        
        for(int i=1;i<arr.length;i++){
            
            if(arr[i] > maxi){
                
                second_maxi = maxi;
                maxi = arr[i];
                
            }
            
            else if(arr[i] < maxi && arr[i] > second_maxi){
                
                second_maxi = arr[i];
                
            }
            
        }
        
        return second_maxi;
        
    }
    
}
