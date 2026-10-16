public class IntegerReplacement {
    
    public int find(long n , int steps){

        if(n < 0) return Integer.MAX_VALUE;
        if(n == 1) return steps;

        int for_even = Integer.MAX_VALUE;  

        int pos_n = Integer.MAX_VALUE;
        int neg_n = Integer.MAX_VALUE;

        if(n % 2 == 0) for_even = find(n / 2 , steps + 1);
        else{
            pos_n = find(n + 1 , steps + 1);
            neg_n = find(n - 1 , steps + 1);
        }

        return Math.min(for_even , Math.min(pos_n , neg_n));

    }

    public int integerReplacement(int n) {
        
        return find((long)n , 0);

    }
    
}
