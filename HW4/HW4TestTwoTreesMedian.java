import java.util.Scanner;

public class HW4TestTwoTreesMedian {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		for (int numTests = 5; numTests > 0; numTests--) {
			BinarySearchTree myTree1 = new BinarySearchTree();
			BinarySearchTree myTree2 = new BinarySearchTree();
			
			// reads integer tokens from the console and constructs a BST from them
			while (scan.hasNextInt()) {
				int value = scan.nextInt();
				myTree1.add(value);
			}
			
			scan.next(); // gets rid of the "end" token in the end of each list in the test case
			
			// reads integer tokens from the console and constructs a BST from them
			while (scan.hasNextInt()) {
				int value = scan.nextInt();
				myTree2.add(value);
			}
			
			scan.next(); // gets rid of the "end" token in the end of each list in the test case
			
			System.out.println(HW4.twoTreesMedian(myTree1, myTree2));
		}
		
		scan.close();
	}

}
