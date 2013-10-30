import java.util.Arrays;
import java.util.Scanner;

public class pshotcube {
	private static int indent = 0;
	private static int loops = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_cases = sc.nextInt();
		sc.nextLine();
		for (int casenum = 0; casenum < num_cases; ++casenum) {
			boolean[][] grid = new boolean[7][];
			for (int i = 0; i < 7; ++i) {
				String line = sc.nextLine();
				grid[i] = new boolean[7];
				for (int j = 0; j < 7; ++j) {
					grid[i][j] = line.charAt(j) == 'X';
				}
			}
			System.out.println(shotcube(grid));
			// System.out.println(loops);
			sc.nextLine();
		}
		sc.close();
	}

	private static void print(boolean[][] grid) {
		for (int i = 0; i < 7; ++i) {
			for (int k = 0; k < indent; ++k) {
				System.out.print("|   ");
			}
			for (int j = 0; j < 7; ++j) {
				System.out.print(grid[i][j] ? 'X' : '.');
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static int shotcube(boolean[][] grid) {
		++indent;
		if (++loops == 50) {
			// System.exit(0);
		}
		// print(grid);
		int ret = -1;
		int r = 0;
		int c = 0;
		outer: for (int i = 0; i < 7; ++i) {
			for (int j = 0; j < 7; ++j) {
				if (grid[i][j]) {
					r = i;
					c = j;
					break outer;
				}
			}
		}
		if (r < 5 && c < 5) {
			boolean solved = true;
			outer: for (int i = 0; i < 3; ++i) {
				for (int j = 0; j < 3; ++j) {
					if (!grid[r + i][c + j]) {
						solved = false;
						break outer;
					}
				}
			}
			if (solved) {
				return 0;
			}
		}
		for (int i = 0; i < 7; ++i) {
			if (grid[i][0]) {
				boolean ok = false;
				boolean gap = false;
				int num_cubes = 0;
				int destination = -1;
				for (int j = 0; j < 7; ++j) {
					if (!grid[i][j] && !gap) {
						gap = true;
					}
					if (grid[i][j]) {
						if (gap) {
							ok = true;
							destination = j;
							break;
						} else {
							++num_cubes;
						}
					}
				}
				if (ok) {
					boolean[][] mygrid = copy(grid);
					for (int j = 0; j < num_cubes; ++j) {
						mygrid[i][j] = false;
					}
					for (int j = destination - num_cubes; j < destination; ++j) {
						mygrid[i][j] = true;
					}
					ret = min(ret, shotcube(mygrid));
				}
			}
			if (grid[i][6]) {
				boolean ok = false;
				boolean gap = false;
				int num_cubes = 0;
				int destination = -1;
				for (int j = 6; j >= 0; --j) {
					if (!grid[i][j] && !gap) {
						gap = true;
					}
					if (grid[i][j]) {
						if (gap) {
							ok = true;
							destination = j;
							break;
						} else {
							++num_cubes;
						}
					}
				}
				if (ok) {
					boolean[][] mygrid = copy(grid);
					for (int j = 0; j < num_cubes; ++j) {
						mygrid[i][6 - j] = false;
					}
					for (int j = 0; j < num_cubes; ++j) {
						mygrid[i][j + destination + 1] = true;
					}
					ret = min(ret, shotcube(mygrid));
				}
			}
			if (grid[0][i]) {
				boolean ok = false;
				boolean gap = false;
				int num_cubes = 0;
				int destination = -1;
				for (int j = 0; j < 7; ++j) {
					if (!grid[j][i] && !gap) {
						gap = true;
					}
					if (grid[j][i]) {
						if (gap) {
							ok = true;
							destination = j;
							break;
						} else {
							++num_cubes;
						}
					}
				}
				if (ok) {
					boolean[][] mygrid = copy(grid);
					for (int j = 0; j < num_cubes; ++j) {
						mygrid[j][i] = false;
					}
					for (int j = destination - num_cubes; j < destination; ++j) {
						mygrid[j][i] = true;
					}
					ret = min(ret, shotcube(mygrid));
				}
			}
			if (grid[6][i]) {
				boolean ok = false;
				boolean gap = false;
				int num_cubes = 0;
				int destination = -1;
				for (int j = 6; j >= 0; --j) {
					if (!grid[j][i] && !gap) {
						gap = true;
					}
					if (grid[j][i]) {
						if (gap) {
							ok = true;
							destination = j;
							break;
						} else {
							++num_cubes;
						}
					}
				}
				if (ok) {
					boolean[][] mygrid = copy(grid);
					for (int j = 0; j < num_cubes; ++j) {
						mygrid[6 - j][i] = false;
					}
					for (int j = 0; j < num_cubes; ++j) {
						mygrid[j + destination + 1][i] = true;
					}
					ret = min(ret, shotcube(mygrid));
				}
			}
		}
		--indent;
		return ret;
	}

	private static int min(int old, int new_) {
		if (old == -1) {
			if (new_ == -1) {
				return -1;
			} else {
				return new_ + 1;
			}
		} else {
			return Math.min(old, new_ + 1);
		}
	}

	private static boolean[][] copy(boolean[][] grid) {
		boolean[][] ret = new boolean[7][];
		for (int i = 0; i < 7; ++i) {
			ret[i] = Arrays.copyOf(grid[i], 7);
		}
		return ret;
	}
}