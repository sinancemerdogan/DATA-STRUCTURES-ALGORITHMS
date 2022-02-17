import java.util.Scanner;

public class HW4TestPerfectMedian {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		for (int numTests = 5; numTests > 0; numTests--) {
			BinarySearchTree myTree = new BinarySearchTree();
			
			// reads integer tokens from the console and constructs a BST from them
			while (scan.hasNextInt()) {
				int value = scan.nextInt();
				myTree.add(value);
			}
			
			scan.next(); // gets rid of the "end" token in the end of each list in the test cases
			System.out.println(HW4.perfectMedian(myTree));
		}
		
		scan.close();
	}

}
