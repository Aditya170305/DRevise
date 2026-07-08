import java.util.ArrayList;
import java.util.Scanner;

public class CombinationSum {

    public static void sum(int index , int [] arr , int k , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> ds){

        if(index == arr.length){
            if(k == 0) ans.add(new ArrayList<>(ds));
            return;
        }

        if(k < 0) return;

        if(arr[index] <= k){
            ds.add(arr[index]);
            sum(index , arr , k - arr[index] , ans , ds);
            ds.remove(ds.size() - 1);
        }

        sum(index + 1 , arr , k , ans , ds);
    }
    
    public static void main(String[] args) {
        
         int n;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int arr [] = new int [n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        sum(0 , arr , k , ans , new ArrayList<>());

        System.out.println(ans);
    }
    
}
