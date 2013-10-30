import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int beds = sc.nextInt();
			if (beds == 0) {
				break;
			}
			String customers = sc.nextLine().substring(1);
			int customersLeft = 0;
			int bedsInUse = 0;
			List<Character> seen = new ArrayList<Character>();
			List<Character> left = new ArrayList<Character>();
			for (char c : customers.toCharArray()) {
				if (seen.contains(c)) {
					if (!left.contains(c)) {
						--bedsInUse;
					}
				} else {
					seen.add(c);
					if (bedsInUse == beds) {
						++customersLeft;
						left.add(c);
					} else {
						++bedsInUse;
					}
				}
			}
			if (customersLeft == 0) {
				System.out.println("All customers tanned successfully.");
			} else {
				System.out.println(customersLeft + " customer(s) walked away.");
			}
		}
		sc.close();
	}
}