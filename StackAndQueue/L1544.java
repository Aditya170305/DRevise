import java.util.Stack;

public class L1544 {
    
    public String makeGood(String s) {
        
        StringBuilder str = new StringBuilder(s);

        Stack<Character> st = new Stack<Character>();

        for(int i=0;i<str.length();i++){

            boolean flag = true;
        
            if(!st.isEmpty()){

                char ch1 = str.charAt(i);
                char ch2 = st.peek();

                if(ch1 >= 'a' && ch1 <= 'z'){

                    if((char)(ch1 - 32) == ch2){

                        st.pop();
                        flag = false;

                    }

                }

                else if(ch1 >= 'A' && ch1 <= 'Z'){

                    if((char)(ch1 + 32) == ch2){

                        st.pop();
                        flag = false;

                    }

                }

            }

            if(flag) st.push(str.charAt(i));

        }

        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty()){

            ans.append(st.pop());

        }

        return ans.reverse().toString();

    }
    
}
