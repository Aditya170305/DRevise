public class StoneRemovalStone {
    
    public boolean canAliceWin(int n) {
        
        int turn = 0;

        int k = 10;

        while(n >= k){

            n = n - k;
            k--;

            turn++;

        }

        return turn % 2 == 1;

    }
    
}
