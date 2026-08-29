public class L3734 {
    
     public boolean solve(StringBuilder curr , int [] freq , String target , int index , boolean greater , String [] ans , char midChar , int halfLen){

        if(index == halfLen){

            StringBuilder s1 = new StringBuilder(curr);
            StringBuilder s2 = new StringBuilder(curr).reverse();

            if(midChar != ' '){
                s1.append(midChar);
            }

            s1.append(s2);

            if(s1.toString().compareTo(target) > 0){
                ans[0] = s1.toString();
                return true;
            }
            
            return false;

        }

        for(char ch='a';ch<='z';ch++){

            if(freq[ch - 'a'] == 0) continue;
            if(greater == false && ch < target.charAt(index)) continue;

            curr.append(ch);
            freq[ch - 'a']--;

            boolean isGreater = greater || ch > target.charAt(index);

            if(solve(curr , freq , target , index + 1 , isGreater , ans , midChar , halfLen)) return true;

            curr.deleteCharAt(index);
            freq[ch - 'a']++;

        }

        return false;

    }

    public String lexPalindromicPermutation(String s, String target) {
        
        String ans [] = new String [1];

        int [] freq = new int [26];

        for(int i=0;i<s.length();i++){

            freq[s.charAt(i) - 'a']++;

        }

        int oddCount = 0;
        char midChar = ' ';

        for(int i=0;i<26;i++){

            if(freq[i] % 2 == 1){
                oddCount++;
                midChar = (char)(i + 'a');
            }

        }

        if(oddCount > 1){
            return "";
        }

        for(int i=0;i<26;i++){

            freq[i] = freq[i] / 2;

        }

        int halfLen = s.length() / 2;

        StringBuilder curr = new StringBuilder();

        solve(curr , freq , target , 0 , false , ans , midChar , halfLen);

        return ans[0] == null ? "" : ans[0];

    }
    
}
