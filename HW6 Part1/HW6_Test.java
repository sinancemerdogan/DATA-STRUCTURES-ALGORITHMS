import java.util.ArrayList;
import java.util.Scanner;

public class HW6_Test {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		for (int numTests = 1; numTests > 0; numTests--) {
			ArrayList<Student> stdArr = new ArrayList<Student>();
			HashMap map = new HashMap(0);

			// reads integer tokens from the console and constructs a BST from them
			while (scan.hasNextLine()) {
				String[] str = scan.nextLine().split(" ");
				if (str.length < 5)
					break;
				int studID = Integer.parseInt(str[1]);
				double studGPA = Double.parseDouble(str[2]);

				Student std = new Student(str[0], studID, studGPA);
				Advisor adv = new Advisor(str[3], str[4]);

				stdArr.add(std);

				map.add(std, adv);
			}

			ArrayList<Advisor> advArr = new ArrayList<Advisor>();
			for (Student std : stdArr) {
				advArr.add(map.get(std));
			}
			
			map.printSorted();

			System.out.println("\nTheir advisors:");
			for (Advisor adv : advArr) {
				System.out.println(adv);
			}

			int i = 1;
			while (i < stdArr.size()) {
				map.remove(stdArr.get(i));
				i *= 2;
			}
			System.out.println("\nAfter removing some elements:");
			
			map.printSorted();

		}

		scan.close();
	}
}