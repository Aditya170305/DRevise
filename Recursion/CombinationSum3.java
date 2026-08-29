
import java.util.ArrayList;
import java.util.Scanner;

public class CombinationSum3 {

    public static void sum(int k , int n , int index , int sum , int arr [] , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> ds){

        if(k == 0){
            if(sum == n) ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<arr.length;i++){
            ds.add(arr[i]);
            sum(k - 1 , n , i + 1 , sum + arr[i] , arr , ans , ds);
            ds.remove(ds.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int k = sc.nextInt();

        int arr [] = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        sum(k , n , 0 , 0 , arr , ans , new ArrayList<>());

        System.out.println(ans);
    }
}
