import java.util.Scanner;

public class HW3TestCharOrderingExercise {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for (int numTests = 10; numTests > 0; numTests--){
			String line = scan.nextLine();
			HW3.charOrderingExercise(line.toCharArray());
		}
		
		scan.close();
	}

}
