public class ReverseDegreeOfAString {
    
    public int reverseDegree(String s) {
        
        int ans = 0;

        for(int i=0;i<s.length();i++){

            int ch = s.charAt(i);

            int val = 'a' - ch + 26;
            ans = ans + (val * (i + 1));

        }

        return ans;

    }
    
}

