public class L3720 {
    
    public boolean solve(StringBuilder curr , int [] freq , String target , int index , boolean greater , String [] ans){

        if(index == target.length()){

            if(greater){
                ans[0] = curr.toString();
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

            if(solve(curr , freq , target , index + 1 , isGreater , ans)) return true;

            curr.deleteCharAt(index);
            freq[ch - 'a']++;

        }

        return false;

    }

    public String lexGreaterPermutation(String s, String target) {
        
        String ans [] = new String [1];

        int freq [] = new int [26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder curr = new StringBuilder();

        solve(curr , freq , target , 0 , false , ans);

        return ans[0] == null ? "" : ans[0];

    }
}
