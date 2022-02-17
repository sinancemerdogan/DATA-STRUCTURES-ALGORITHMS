public class BinarySearchTree implements BSTInterface {

	public TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

  public TreeNode getRoot() {
    return root;
  }
  //Adds a stutendt to the BST
	@Override
	public void add(Student data) {
    root = recursiveAdd(root, data);
	}
  //Function that recursively finds the location of the new node and return it.
  private TreeNode recursiveAdd(TreeNode root, Student data) {
    if(root == null)  {
      root = new TreeNode(data);
      return root;
    }
    if(root.getData().id > data.id) {
      root.setLeft(recursiveAdd(root.getLeft(),data));
    }
    else if (root.getData().id < data.id) {
      root.setRight(recursiveAdd(root.getRight(),data));
    }
    return root;
  }
	//Deletes a student from BST
	@Override
	public TreeNode delete(Student data) {
		root = recursiveDelete(root,data);
    return root;
	}
  //Function that recursively finds the student to be removed
  private TreeNode recursiveDelete(TreeNode root, Student data)
    {
    if (root == null)
      return root;

    if (data.id < root.data.id)
      root.left = recursiveDelete(root.left, data);
    else if (data.id > root.data.id)
      root.right = recursiveDelete(root.right, data);
 
    else {
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;    
        root.data = findMin(root.right);
        root.right = recursiveDelete(root.right, root.data);
        }

    return root;
    }
  //Finds the minimum data (the left-most node) in BST and returns it   
  private Student findMin(TreeNode root)
    {
        Student min = root.data;
        while (root.left != null) 
        {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
  // BST to string using In Order Traversal
  public String toStringInorder(TreeNode root) {
	    String result = "";
	    if (root == null)
	        return result;
	    result += toStringInorder(root.getLeft());
	    result += root.getData() + "\n";
	    result += toStringInorder(root.getRight());
	    return result;
	}
  //Prints the BST
  public void printBst() {
    System.out.print(toStringInorder(root));
  }  
	@Override
	public TreeNode search(Student data) {
		// you don't have to implement it
		return null;
	}
	@Override
	public boolean contains(Student data) {
		// you don't have to implement it
		return false;
	}
}
