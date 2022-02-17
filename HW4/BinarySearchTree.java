
public class BinarySearchTree implements BSTInterface {
	
	private TreeNode root;

  // variable that keeps the conunt of the elements
  private int countNode = 0;
  // variable that keeps the value of kth element
  private double kth = 0;
  // varibale that keeps the index for creating new array
  private int index = 0;

	public BinarySearchTree() {
    root = null;
	}

	@Override
	public void add(int data) {
    root = recursiveAdd(root, data);
    }
    
  // Function that recursively founds the location of the new node and return it.
  private TreeNode recursiveAdd(TreeNode root, int data) {
    if(root == null)  {
      root = new TreeNode(data);
      return root;
    }
    root.setNChilds((root.getNChilds() + 1));
    if(root.getData() > data) {
      root.setLeft(recursiveAdd(root.getLeft(),data));
    }
    else if (root.getData() < data) {
      root.setRight(recursiveAdd(root.getRight(),data));
    }
    return root;
  }
  
  //Function that returns the kth element of inoder traversal .
  public double kthElement(int k) {
    kthElementInOrder(root,k);
    countNode = 0;
    return kth;
  }

  //Function that recursively founds the location of the kth node.
  private void kthElementInOrder(TreeNode root, int k) {
    if (root == null)  
        return;  
    
    if (countNode <= k) {  
        kthElementInOrder(root.getLeft(), k);  
        countNode++;  
     
        if (countNode == k) { 
          kth = root.getData();
        }    
    
        kthElementInOrder(root.getRight(), k);  
   }
  }
  // returns the new array
  public int[] toArray() {
    int[] array = new int[root.getNChilds() + 1];
    toArrayRecursive(root,array);
    index = 0;
    return array;
  }
  // the elements of the tree to an integer array using inorder traversal
  private void  toArrayRecursive(TreeNode root , int [] array) {
     if (root == null) {
	        return;
     }
	    toArrayRecursive(root.getLeft(),array);
	    array[index] = root.getData();
      index++;
	    toArrayRecursive(root.getRight(),array);
  }

  // Returning the size of the tree.
  public int size() {
    return sizeRecursive(root);
  }

  // Recursively count the number of nodes in the given tree.
  private int sizeRecursive(TreeNode root) {
	if (root == null) {
    return 0;
  }
   return sizeRecursive(root.getLeft()) + 1 + sizeRecursive(root.getRight());
  }


	@Override
	public TreeNode delete(int data) {
		// you don't have to implement this
		return null;
	}

	@Override
	public TreeNode search(int data) {
		// you don't have to implement this
		return null;
	}

	@Override
	public boolean contains(int data) {
		// you don't have to implement this
		return false;
	}
	
	//provides the String representation of the BST in inorder fashion
	public String toString() {
		return toStringInorder(root).trim();
	}
	
	private String toStringInorder(TreeNode root) {
	    String result = "";
	    if (root == null)
	        return result;
	    result += toStringInorder(root.getLeft());
	    result += root.getData() + " ";
	    result += toStringInorder(root.getRight());
	    return result;
	}
	
	public TreeNode getRoot(){
		return root;
	}

}