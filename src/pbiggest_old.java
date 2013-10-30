import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class pbiggest_old {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_cases = sc.nextInt(); // 1 <= m <= 200
		for (int case_num = 0; case_num < num_cases; ++case_num) {
			int radius = sc.nextInt(); // 0 < x <= 100
			int people = sc.nextInt(); // 0 < x <= 10**8
			int degrees = sc.nextInt(); // 0 <= x <= 359
			int minutes = sc.nextInt(); // 0 <= x <= 59
			int seconds = sc.nextInt(); // 0 <= x <= 59
			// BigDecimal angle = new BigDecimal(degrees);
			// angle = angle.add(new BigDecimal(minutes / 60.0));
			// angle = angle.add(new BigDecimal(seconds / 3600.0));
			// BigDecimal ang = new BigDecimal(0);
			double angle = degrees + minutes / 60.0 + seconds / (60.0 * 60);
			double ang = 0;
			List<Double> cuts = new ArrayList<Double>();
			// List<BigDecimal> cuts = new ArrayList<BigDecimal>();
			for (int i = 0; i < people; ++i) {
				cuts.add(ang);
				// ang = ang.add(angle);
				ang = (ang + angle) % 360;
			}
			Collections.sort(cuts);

			double max_slice;
			if (cuts.size() == 1) {
				max_slice = 360;
			} else {
				max_slice = 360 - (cuts.get(cuts.size() - 1) - cuts.get(0));
				for (int i = 1; i < people; ++i) {
					if (max_slice < cuts.get(i) - cuts.get(i - 1)) {
						max_slice = cuts.get(i) - cuts.get(i - 1);
					}
				}
			}

			// BigDecimal max_slice = cuts.get(1).subtract(cuts.get(0));
			// for (int i = 2; i < people; ++i) {
			// if (max_slice.compareTo(cuts.get(i).subtract(cuts.get(i - 1))) <
			// 0) {
			// max_slice = cuts.get(i).subtract(cuts.get(i - 1));
			// }
			// }
			System.out.println(max_slice * Math.PI / 360 * radius * radius);
			// System.out.println(max_slice.multiply(new BigDecimal(Math.PI))
			// .divide(new BigDecimal(360))
			// .multiply(new BigDecimal(radius).pow(2)));
			// System.out.println(max_slice.multiply(new
			// BigDecimal(Math.PI)).multiply(new
			// BigDecimal(radius).pow(2)).divide(new BigDecimal(360),
			// RoundingMode.HALF_EVEN));
		}
		sc.close();
	}
}
