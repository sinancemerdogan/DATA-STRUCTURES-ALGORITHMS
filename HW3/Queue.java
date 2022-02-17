
public class Queue implements QueueInterface {
	private int size;
	private ListNode front;
	private ListNode back;
	
	public Queue() {
    size = 0;
    front = new ListNode();
    back = new ListNode();
	}

	@Override
	public char front() {
    if(this.front.getNext() != null) {
       char data = this.front.getNext().getData();
		   return data; 
       }
    return '\0';
	}

	@Override
	public char dequeue() {
    if(this.front.getNext() == null) {
      System.out.println("Queue is empty.");
      return '\0';
    }
    char data = this.front.getNext().getData();
    this.front.setNext(this.front.getNext().getNext());
    this.size--;
    if(this.front.getNext() == null) {
      this.back.setNext(null);
    }
    return data;
	}

	@Override
	public void enqueue(char data) {
    ListNode node = new ListNode(data);
    if(this.back.getNext() == null) {
      this.back.setNext(node); 
      this.front.setNext(node);
      this.size++;
      return;
    }
    this.back.getNext().setNext(node);
    this.back.setNext(node);
    this.size++;
	}

	@Override
	public boolean isEmpty() {
    if(this.front.getNext() == null) {
      return true;
    }
		return false;
	}

	@Override
	public int size() {
    return size;
	}
	
	// The string representation of the items in the queue
	public String toString() {
		String str = "front -> ";
		for (int i = size; i > 0; i--) {
			char value = dequeue();
			str += value + " -> ";
			enqueue(value);
		}
		return str + "back";
	}

}
