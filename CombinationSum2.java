import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CombinationSum2 {
    
    public static void sum(int index , int [] arr , int k , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> ds){

        if(k == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<arr.length;i++){
            if(i > index && arr[i] == arr[i - 1]) continue;
            if(arr[i] > k) break;
            ds.add(arr[i]);
            sum(i + 1 , arr , k - arr[i] , ans , ds);
            ds.remove(ds.size() - 1);
        }
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

        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        sum(0 , arr , k , ans , new ArrayList<>());

        System.out.println(ans);
    }
}
