
public class MinimumWindowSubstring {
    public static String minSubString(String a, String b) {
        
        int hash [] = new int [256];
        int l = 0 , r = 0 , minLength = 1000000000 , sIndex = -1 , count = 0;

        for(int i=0;i<b.length();i++){
            hash[b.charAt(i)]++;
        }

        while(r < a.length()){

            if(hash[a.charAt(r)] > 0) count++;
            hash[a.charAt(r)]--;

            while(count == b.length()){

                if(r - l + 1 < minLength){

                    minLength = r - l + 1;
                    sIndex = l;

                }

                hash[a.charAt(l)]++;
                if(hash[a.charAt(l)] > 0) count--;

                l++;

            }

            r++;

        }

        return sIndex == -1 ? "" : a.substring(sIndex , sIndex + minLength);
        
    }
}
