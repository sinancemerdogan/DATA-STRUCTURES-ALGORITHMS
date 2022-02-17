import java.util.Scanner;

public class HW3 {
	
	public static void charOrderingExercise(char[] charArray) {
		Queue myQueue = new Queue();
    myQueue.enqueue(charArray[0]);
    for(int i =1; i < charArray.length; i++) {
      for(int j = myQueue.size(); j > 0; j--) {
          char data = myQueue.dequeue();
          if(data == charArray[i]) {
            continue;
        }
        myQueue.enqueue(data);
      }
      myQueue.enqueue(charArray[i]);
    }
		System.out.println(myQueue);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		charOrderingExercise(line.toCharArray());
		
		scan.close();
	}

}
