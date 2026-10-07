public class LongestPalindrome {
    
    public int longestPalindrome(String s) {
        
        int freq [] = new int [256];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }

        boolean odd = false;

        int result = 0;

        for(int i=0;i<256;i++){
            if(freq[i] % 2 == 0){
                result = result + freq[i];
            }

            else{
                result = result + freq[i] - 1;
                odd = true;
            }

        }

        if(odd) result = result + 1;
        return result;
        
    }
    
}
