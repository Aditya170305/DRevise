public class DetectCapital {
    
    public boolean detectCapitalUse(String word) {
        
        int count = 0;

        int n = word.length();

        for(int i=0;i<n;i++){

            if('A' <= word.charAt(i) && word.charAt(i) <= 'Z'){
                count++;
            }
        }

        int diff = n - count;

        if(diff == 0 || diff == n) return true;
        else if(diff == n - 1 && 'A' <= word.charAt(0) && word.charAt(0) <= 'Z') return true;
        return false;
    }
    
}
