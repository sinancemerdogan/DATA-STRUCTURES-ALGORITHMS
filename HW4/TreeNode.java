/**
* This class is an implementation 
* of a tree node with 2 children
* 
*/

		
// you can add your methods and/or fields to incorporate the information about
// the number of children nodes. Please try to follow the encapsulation standards
public class TreeNode {

		private int data;
		private TreeNode left, right;
    private int nChildren = 0;
		
		public TreeNode(int data) {
			this.setData(data);
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}
    public void setNChilds(int nChildren) {
      this.nChildren = nChildren;
    }
    public int getNChilds() {
      return nChildren;
    }
}
