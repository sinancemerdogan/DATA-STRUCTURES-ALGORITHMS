import java.util.Scanner;

public class HW2 {
	
	// For this implementation you should use constant space
	// Note: you are free to add any extra methods,
	// but this method has to be used
	public static boolean isPalindromeRestricted(ListNode head) {
    ListNode normalHead = head;
    ListNode reversedHead = reverseLinkedList(getTheMidOfList(normalHead));
    while(reversedHead.getNext() != null) {
      if(normalHead.getData() != reversedHead.getData()) {
        return false;
      }
      normalHead = normalHead.getNext();
      reversedHead = reversedHead.getNext();
    }
    if(normalHead.getData() != reversedHead.getData()) {
        return false;
      }
    return true;
  }
  //Reverses the list using iteration
  public static ListNode reverseLinkedList(ListNode head) { 
    ListNode previous = null;
    ListNode current = head;
    ListNode next = null;
    
    while(current != null) { 
      next = current.getNext();  
      current.setNext(previous);
      previous = current;  
      current = next; 
    
    }
    return previous; //When current == null, previous become the new head of the list
  }
   //Returns the middle element of the list
  public static ListNode getTheMidOfList(ListNode head) {
    ListNode slowNode = head;
    ListNode fastNode = head;

    if(head != null) {
      while(fastNode != null && fastNode.getNext() != null) {
        fastNode = fastNode.getNext().getNext();
        slowNode = slowNode.getNext();
      }
    }
     return slowNode;
  }

	// For this implementation the space is not restricted
	// Note: you are free to add any extra methods,
	// but this method has to be used 
	public static boolean isPalindromeUnrestricted(ListNode head) {
    ListNode reversedHead = reverseLinkedList(listToNewList(head));

    if(head !=null && reversedHead != null) {
      if(head.getData() != reversedHead.getData()) {
        return false;
      }
    }
    while(head.getNext() !=null && reversedHead.getNext() != null) {
      reversedHead = reversedHead.getNext();
      head = head.getNext();
      if(head.getData() != reversedHead.getData()) {
        return false;
      }
	  }
    return true;
  }
  //Pass the values from list to a new list
  public static ListNode listToNewList(ListNode head) {
    ListNode tempHead = head;
    ListNode head2 = null;
    ListNode current = null;
    while(head != null) {
       if (head2 == null) {
					    head2 = new ListNode(head.getData());
					    current = head2;
              head = head.getNext();
		  } else {
					current.setNext(new ListNode(head.getData()));
					current = current.getNext();
          head = head.getNext();
				}
    }
    return head2;  
  }
	// Prints LinkedList, given the head of the list (if needed for testing)
	public static String listToString(ListNode head) {
		String result = "";
		if (head != null) {
			result += head.getData();
    } else {
      return result;
    }
		while (head.getNext() != null) {
			head = head.getNext();
			result += " -> " + head.getData();
		}	
		return result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ListNode head = null;
		ListNode current = null;
		
		// reads integer tokens from the console and constructs a LinkedList from them
		String line = scan.nextLine();
		scan.close();
		scan = new Scanner(line);
		
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
    System.out.println(listToString(head));
    System.out.println(isPalindromeUnrestricted(head));
    System.out.println(isPalindromeRestricted(head));
		scan.close();
	}

}

