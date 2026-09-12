

public class L2904 {
    
    public String shortestBeautifulSubstring(String s, int k) {
        
        int min_length = Integer.MAX_VALUE;
        String ans = "";

        for(int i=0;i<s.length();i++){

            int freq [] = new int [2];

            for(int j=i;j<s.length();j++){

                if(s.charAt(j) == '1') freq[1]++; 

                if(freq[1] == k){
                    int length = j - i + 1;
                    String sub = s.substring(i , j + 1);

                    if(length < min_length){
                        min_length = length;
                        ans = sub;
                    }

                    else if(length == min_length){
                        if(sub.compareTo(ans) < 0){
                            ans = sub;
                        }
                    }

                    break;

                }

            }

        }

        return ans;

    }
    
}
