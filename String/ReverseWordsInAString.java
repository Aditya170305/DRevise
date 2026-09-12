import java.util.Stack;

public class ReverseWordsInAString {
    
    public String reverseWords(String s) {
        
        Stack<String> st = new Stack<String>();

        s = s.trim();

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == ' ') continue;

            int j = i;

            while(i < s.length() && s.charAt(i) != ' '){
                i++;
            }

            st.push(s.substring(j , i));

        }

        String ans = "";

        while(!st.isEmpty()){

            ans = ans + " " + st.pop(); 

        }

        return ans.substring(1);

    }

}
