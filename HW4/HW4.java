import java.util.Scanner;


public class HW4 {
	
	// median exercise #1
	public static double perfectMedian(BinarySearchTree bst){
    return (double) bst.getRoot().getData();	
	}


	// median exercise #2
	public static double anyMedian(BinarySearchTree bst){
    int size = bst.size();

    if(size % 2 == 0) {
      return (bst.kthElement(size/2) + bst.kthElement((size + 2) / 2) ) / 2;
    } else {
      return bst.kthElement((size + 1)  / 2);
    }
	}

	// median exercise #3
	public static double nChildrenMedian(BinarySearchTree bst){
    TreeNode root = bst.getRoot();
    int numberOfNodes = root.getNChilds() + 1;
    int target = (numberOfNodes + 1) / 2;
    double x = medianNChild(root,target);

    if( numberOfNodes % 2 == 0) {
      return (double) ((x + medianNChild(root,target + 1) ) / 2);
    }
    else {
      return (double) x;
    }
	}
  // Return the value of the target node using the information of number of childs.
  public static double medianNChild(TreeNode root, int target) {
    int k;
    if(root.getLeft() == null) {
      k = -1;
    }
    else {
       k = root.getLeft().getNChilds();
    }

    if (k+2 == target) return root.getData();
    else if (k+2 > target) {
      return medianNChild(root.getLeft(),target);
    }
    else {
      return medianNChild(root.getRight(),target - k -2);
       }
    }   
	// median exercise #4
	public static double twoTreesMedian(BinarySearchTree tree1, BinarySearchTree tree2){

    int[] array1 = tree1.toArray();
    int[] array2 = tree2.toArray();
    int[] array3 = combineArrays(array1,array2);

    BinarySearchTree newTree = arrayToBst(array3);

    return nChildrenMedian(newTree);
  }
  // helper function that combines the two sorted arrays
  public static int[] combineArrays(int[] array1 ,int[] array2) {
    int i = 0, j = 0, k = 0; 
    int length1 = array1.length;
    int length2 = array2.length;

    int[] array3 = new int[length1 + length2];

        while (i<length1 && j <length2) {
            if (array1[i] < array2[j]) 
                array3[k++] = array1[i++]; 
            else
                array3[k++] = array2[j++]; 
        } 
        while (i < length1) {
            array3[k++] = array1[i++];
        } 
      
        while (j < length2) {
            array3[k++] = array2[j++]; 
        }
    return array3;
  }
  // helper function that converts array to BST
  public static BinarySearchTree arrayToBst(int[] array) {
    BinarySearchTree newTree = new BinarySearchTree();
    for(int i = 0; i < array.length; i++) {
      newTree.add((array[i]));
    }
    return newTree;
  }

	public static void main(String[] args) {
		// this method is for your own testing purposes
		Scanner scan = new Scanner(System.in);
    BinarySearchTree myTree = new BinarySearchTree();
		//reads integer tokens from the console and constructs a BinarySearchTree from them
		while (scan.hasNextInt()) {
			int value = scan.nextInt();
			myTree.add(value);
		}
		scan.close();

	}

}