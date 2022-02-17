
public class TreeNode {

		Student data;
		TreeNode left, right;
		
		public TreeNode(Student data) {
			this.data = data;
		}

		public Student getData() {
			return data;
		}

		public void setData(Student data) {
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
    /*public void setNChilds(Student nChildren) {
      this.nChildren = nChildren;
    }
    public int getNChilds() {
      return nChildren;
    }*/
}
