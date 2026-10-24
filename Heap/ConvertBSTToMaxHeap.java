import java.util.ArrayList;
import java.util.List;

class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }

}

public class ConvertBSTToMaxHeap {
    
    static int index;

	public static void findInorder(BinaryTreeNode root , List<Integer> inOrder){

		if(root == null) return;
		findInorder(root.left , inOrder);
		inOrder.add(root.data);
		findInorder(root.right , inOrder);

	}

	public static void createMinHeap(BinaryTreeNode root , List<Integer> inOrder){

		if(root == null) return;

		root.data = inOrder.get(index++);
		createMinHeap(root.left , inOrder);
		createMinHeap(root.right , inOrder);

	}

	public static BinaryTreeNode convertBST(BinaryTreeNode root) {
		
		List<Integer> inOrder = new ArrayList<Integer>();
		findInorder(root , inOrder);

		index = 0;

		createMinHeap(root , inOrder);

		return root;

	}

}
