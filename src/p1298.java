import java.util.Scanner;

public class p1298 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			if (sc.nextLine().equals("ENDOFINPUT")) { // skip START
				break;
			}
			String line = sc.nextLine();
			for (char c : line.toCharArray()) {
				if (c >= 'A' && c <= 'Z') {
					System.out.print((char) (c - 5 + (c < 'F' ? 26 : 0)));
				} else {
					System.out.print((char) c);
				}
			}
			System.out.println();
			sc.nextLine(); // skip END
		}
		sc.close();
	}
}