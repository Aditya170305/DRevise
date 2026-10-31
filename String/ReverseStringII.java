public class ReverseStringII {
    
    public void reverse(int left , int right , char [] str){

        while(left < right){

            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;

            left++;
            right--;

        }

    }

    public String reverseStr(String s, int k) {

        int n = s.length();

        int i = 0;
        int j = 2 * k - 1;

        char str [] = s.toCharArray();

        while(j < n){

            reverse(i , i + k - 1 , str);
            i = i + 2 * k;
            j = j + 2 * k;

        }

        if(n - i >= k) reverse(i , i + k - 1 , str);
        else reverse(i , n - 1 , str);

        return new String(str);

    }
    
}
