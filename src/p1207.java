import java.util.Scanner;

public class p1207 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			System.out.print(i + " " + j + " ");
			if (j < i) {
				int temp = i;
				i = j;
				j = temp;
			}
			int max = collatz(j);
			for (int x = i; x < j; ++x) {
				int temp = collatz(x);
				if (max < temp) {
					max = temp;
				}
			}
			System.out.println(max);
		}
		sc.close();
	}

	private static int collatz(int x) {
		int count = 1;
		while (x != 1) {
			++count;
			if (x % 2 == 0) {
				x /= 2;
			} else {
				x = 3 * x + 1;
			}
		}
		return count;
	}
}