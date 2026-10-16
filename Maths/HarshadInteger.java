public class HarshadInteger {
    
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        
        int sum = 0;

        int num = x;
        while(num != 0){

            sum = sum + (num % 10);
            num = num / 10;

        }

        return (x % sum == 0) ? sum : -1;

    }
    
}
