public class ArrangingCoins {
    
    public int arrangeCoins(int n) {

        int i = 1;

        while(n >= i){

            n = n - i;
            i++;

        }

        return i - 1;

    }
    
}
