public class CountPrimes {
    
    public int countPrimes(int n) {
        int arr[] = new int[n+1];
        int count = 0;
        for(int i=2;i*i<=n;i++){
            if(arr[i]==0){
                for(int j=i*i;j<=n;j=j+i){
                    arr[j] = 1;
                }
                // if(i!=n){
                //     count++;
                // }
            }
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i] == 0 && i!=n){
                count++;
            }
        }
        if(n == 2){
            return 0;
        }
        return count;
    }
    
}
