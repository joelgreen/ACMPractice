import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class pbiggest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_cases = sc.nextInt(); // 1 <= m <= 200
		for (int case_num = 0; case_num < num_cases; ++case_num) {
			int radius = sc.nextInt(); // 0 < x <= 100
			int people = sc.nextInt(); // 0 < x <= 10**8
			int degrees = sc.nextInt(); // 0 <= x <= 359
			int minutes = sc.nextInt(); // 0 <= x <= 59
			int seconds = sc.nextInt(); // 0 <= x <= 59
			double angle = degrees + minutes / 60.0 + seconds / (60.0 * 60);
			double ang = 0;
			TreeSet<Double> cuts = new TreeSet<Double>();
			for (int i = 0; i < people; ++i) {
				if (!cuts.add(ang)) {
					break;
				}
				ang = (ang + angle) % 360;
			}
			double max_slice;
			if (people == 1) {
				max_slice = 360;
			} else {
				max_slice = 360 - (cuts.last() - cuts.first());
				while (cuts.size() != 1) {
					double t = cuts.pollFirst();
					if (max_slice < cuts.first() - t) {
						max_slice = cuts.first() - t;
					}
				}
			}

			System.out.println(max_slice * Math.PI / 360 * radius * radius);
		}
		sc.close();
	}
}
