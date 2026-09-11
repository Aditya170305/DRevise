public class L2220 {
    
    public int minBitFlips(int start, int goal) {
        
        int ans = start ^ goal;

        int count = 0;

        while(ans != 0){

            ans = ans & ans - 1;
            count++;

        }

        return count;
        
    }
    
}
