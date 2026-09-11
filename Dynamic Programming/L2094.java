import java.util.Set;
import java.util.TreeSet;

public class L2094 {
    
    Set<Integer> st = new TreeSet<Integer>();

    public void find(int num , int count , int n , int freq [] , int [] digits){

        if(count == 3){
            if(num % 2 == 0){
                st.add(num);
            }

            return;

        }

        for(int i=0;i<n;i++){

            if(freq[i] == 0){
                int num1 = (num * 10) + digits[i];
                if(num1 != 0){
                    freq[i] = 1;
                    count++;
                    find(num1 , count , n , freq , digits);
                    freq[i] = 0;
                    count--;
                }
            }
        }
    }
    
    public int[] findEvenNumbers(int[] digits) {
        
        int n = digits.length;

        int freq [] = new int [n];

        st.clear();

        find(0 , 0 , n , freq , digits);

        int arr [] = new int [st.size()];
        int index = 0;

        for(Integer el : st){
            arr[index] = el;
            index++;
        }

        return arr;
        
    }
    
}
