import java.util.ArrayList;
import java.util.Scanner;

public class PermutationOfArrayOptimal {
    
    public static void permu(int index , int [] arr , ArrayList<ArrayList<Integer>> ans){

        if(index == arr.length){

            ArrayList<Integer> ds = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<arr.length;i++){
            swap(arr , index , i);
            permu(index + 1 , arr , ans);
            swap(arr , index , i);
        }
    }

    private static void swap(int arr [] , int a , int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

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

        permu(0 , arr , ans);

        System.out.println(ans);

    }
}
