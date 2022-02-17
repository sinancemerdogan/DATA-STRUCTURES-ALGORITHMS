import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HW3TestQueue {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		for (int numTests = 10; numTests > 0; numTests--){ 
			Queue myQueue = new Queue(); 
			int c = 0; 
			
			while((c = buffer.read()) >= 32) {
				if (c == 45) {
					myQueue.dequeue();
				} else {
					myQueue.enqueue(((char)c));
				}
			} 
			System.out.println(myQueue); 
			buffer.read();
		}
		
		buffer.close();
	}

}
