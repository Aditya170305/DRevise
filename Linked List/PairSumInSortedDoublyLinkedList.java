import java.util.ArrayList;

class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }

}

public class PairSumInSortedDoublyLinkedList {
    
    public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        Node left = head;
        
        Node right = head;
        
        while(right.next != null){
            
            right = right.next;
            
        }
        
        while(left.data < right.data){
            
            int ele = left.data + right.data;
            
            if(ele == target){
                
                ArrayList<Integer> temp = new ArrayList<Integer>();
                
                temp.add(left.data);
                temp.add(right.data);
                
                ans.add(new ArrayList<>(temp));
                
                left = left.next;
                right = right.prev;
                
            }
            
            else if(ele < target){
                
                left = left.next;
                
            }
            
            else{
                
                right = right.prev;
                
            }
            
        }
        
        return ans;
        
    }
    
}
