public class L3870 {
    
    public int countCommas(int n) {
        
        int count = 0;

        int n1 = n;

        while(n != 0){

            count++;
            n = n / 10;

        }

        if(count <= 3) return 0;

        int diff = n1 - 1000 + 1;

        return diff;
        

    }
    
}
