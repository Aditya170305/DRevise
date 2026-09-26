import java.util.Arrays;

class Pair {
    
    public int weight;
    public int value;
    
    public Pair(int weight , int value){
        
        this.weight = weight;
        this.value = value;
        
    }
    
}

public class FractionalKnapsack {

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        
        int n = val.length;
        
        Pair items [] = new Pair [n];
        
        for(int i=0;i<n;i++){
            
            items[i] = new Pair(wt[i] , val[i]);
            
        }
        
        Arrays.sort(items , (a , b) -> {
           
           double ratio1 = (double)a.value / a.weight;
           double ratio2 = (double)b.value / b.weight;
           
           return Double.compare(ratio2 , ratio1);
           
        });
        
        double total_value = 0;
        
        for(int i=0;i<n;i++){
            
            if(items[i].weight <= capacity){
                
                total_value = total_value + items[i].value;
                capacity = capacity - items[i].weight;
                
            }
            
            else{
                
                total_value = total_value + ((double)items[i].value / items[i].weight) * capacity;
                break;
                
            }
            
        }
        
        return total_value;
        
    }

}
