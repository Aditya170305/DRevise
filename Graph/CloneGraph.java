import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

}

public class CloneGraph {

    Map<Node , Node> mpp = new HashMap<Node , Node>();

    public Node cloneGraph(Node node) {
        
        if(node == null) return null;

        if(mpp.containsKey(node)){
            return mpp.get(node);
        }

        Node newNode = new Node(node.val);
        mpp.put(node , newNode);

        for(Node it : node.neighbors){
            newNode.neighbors.add(cloneGraph(it));
        }

        return newNode;

    }

}
