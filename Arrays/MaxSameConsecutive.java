public class MaxSameConsecutive {
    
    public int maxConsecBits(int[] arr) {
        
        int ans_one = 0;
        int count_one = 0;
        
        int ans_zero = 0;
        int count_zero = 0;
        
        for(int i=0;i<arr.length;i++){
            
            if(arr[i] == 1){
                
                count_one++;
                count_zero = 0;
                
            }
            
            else{
                
                count_one = 0;
                count_zero++;
                
            }
            
            ans_one = Math.max(ans_one , count_one);
            ans_zero = Math.max(ans_zero , count_zero);
            
        }
        
        return Math.max(ans_one , ans_zero);
        
    }
    
}
