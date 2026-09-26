import java.util.Arrays;

public class AssignCookies {
    
    public static int assignCookie(int []greed, int []size) {
        
        Arrays.sort(greed);
        Arrays.sort(size);

        int n = greed.length;
        int m = size.length;

        int l = 0 , r = 0;

        while(l < m && r < n){

            if(greed[r] <= size[l]){
                r++;
            }

            l++;

        }

        return r;
        
    }

}
