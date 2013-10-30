import java.util.Scanner;

public class p1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_inputs = sc.nextInt();
		for (int input = 0; input < num_inputs; ++input) {
			int n = sc.nextInt();
			boolean[] cells = new boolean[n];
			for (int x = 1; x <= n; ++x) {
				int cell = x - 1;
				while (cell < n) {
					cells[cell] = !cells[cell];
					cell += x;
				}
			}
			int count = 0;
			for (int x = 0; x < n; ++x) {
				if (cells[x]) {
					++count;
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
}