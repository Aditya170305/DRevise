
public class LongestRepeatingCharacterReplacement {
    public static int longestRepeatingSubstring(String str, int k) {
        
        // int maxlen = 0;
        // int changes = 0;

        // for(int i=0;i<str.length();i++){

        //     int hash [] = new int [26];
        //     int maxfreq = 0;

        //     for(int j=i;j<str.length();j++){

        //         hash[str.charAt(j) - 'A']++;

        //         maxfreq = Math.max(maxfreq , hash[str.charAt(j) - 'A']);

        //         changes = (j - i + 1) - maxfreq;

        //         if(changes <= k) maxlen = Math.max(maxlen , j - i + 1);
        //         else break;

        //     }
        // }

        // return maxlen;

        int hash [] = new int [26];

        int l = 0 , r = 0 , maxlen = 0 , maxfreq = 0;

        while(r < str.length()){

            hash[str.charAt(r) - 'A']++;
            maxfreq = Math.max(hash[str.charAt(r) - 'A'] , maxfreq);
            if((r - l + 1) - maxfreq > k){
                hash[str.charAt(l) - 'A']--;
                l++;
            }

            if((r - l + 1) - maxfreq <= k){
                maxlen = Math.max(maxlen , r - l + 1);
            }

            r++;

        }

        return maxlen;
        
    }
}
