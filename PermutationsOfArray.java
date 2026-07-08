import java.lang.reflect.Array;
import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class PermutationsOfArray {
    
    public static void permu(int arr [] , ArrayList<Integer> ds , ArrayList<ArrayList<Integer>> ans , boolean freq []){

        if(ds.size() == arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<arr.length;i++){

            if(!freq[i]){
                freq[i] = true;
                ds.add(arr[i]);
                permu(arr, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
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

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        boolean freq [] = new boolean [arr.length];

        permu(arr , new ArrayList<>() , ans , freq);

        System.out.println(ans);
    }
}
