public class MinimumOperationsToSortAString {
    
    public boolean isSorted(String s , int n){

        for(int i=0;i<n - 1;i++){

            if(s.charAt(i) > s.charAt(i + 1)) return false;

        }

        return true;

    }

    public int minOperations(String s) {

        int n = s.length();
        
        if(isSorted(s , n)) return 0;

        if(n == 2) return -1;

        char max_char = ' ';
        char min_char = (char)123;

        char max_middle = ' ';
        char min_middle = (char)123;

        for(int i=0;i<n;i++){

            char ch = s.charAt(i);

            max_char = (char)Math.max(max_char , ch);
            min_char = (char)Math.min(min_char , ch);

            if(i !=0 && i != n-1){

                max_middle = (char)Math.max(max_middle , ch);
                min_middle = (char)Math.min(min_middle , ch);

            }

        }

        if(s.charAt(0) == min_char) return 1;
        if(s.charAt(n - 1) == max_char) return 1;

        if(s.charAt(0) > max_middle && min_middle > s.charAt(n - 1)) return 3;
        return 2;

    }
    
}
