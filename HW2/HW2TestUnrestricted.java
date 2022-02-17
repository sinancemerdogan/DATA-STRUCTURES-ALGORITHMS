import java.util.Scanner;
		
public class HW2TestUnrestricted {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for (int numTests = 10; numTests > 0; numTests--){
			ListNode head = null;
			ListNode current = null;
			
			// reads integer tokens from the console and constructs a LinkedList from them
			while (scan.hasNextInt()) {
				int value = scan.nextInt();
				if (head == null) {
					 head = new ListNode(value);
					 current = head;
				} else {
					current.setNext(new ListNode(value));
					current = current.getNext();
				}
			}
			scan.next(); // gets rid of the "end" token in the end of each list in the test cases

			System.out.println(HW2.isPalindromeUnrestricted(head));
		}
		
		scan.close();
	}
}
