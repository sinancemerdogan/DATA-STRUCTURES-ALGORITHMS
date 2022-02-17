
public interface BSTInterface {

	
    /**
     * Add a new Student element to the BST
     */
	public void add(Student data);

	
    /**
     * Find a TreeNode with the given data in the tree and remove it
     * 
     * @return TreeNode with the given data, from the tree
     */
	public TreeNode delete(Student data);

	
    /**
     * Find a TreeNode with the given data in the tree
     * 
     * @return TreeNode with the given data, from the tree
     */
	public TreeNode search(Student data);

	
    /**
     * Check whether there is a TreeNode with the given data in the tree
     * 
     * @return boolean value result
     */
	public boolean contains(Student data);

}
