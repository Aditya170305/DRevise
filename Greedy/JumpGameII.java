public class JumpGameII {
    
    public int minJumps(int[] arr) {
        
        int jumps = 0 , l = 0 , r = 0;
        
        while(r < arr.length){
            
            int farthest = 0;
            
            for(int index=l;index<=r;index++){
                
                farthest = Math.max(farthest , index + arr[index]);
                
            }
            
            l = r + 1;
            r = farthest;
            jumps++;
            
        }
        
        return jumps;
        
    }

}
