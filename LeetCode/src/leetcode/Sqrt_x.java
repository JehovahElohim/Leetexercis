package leetcode;

public class Sqrt_x {
	public static int mySqrt(int x) {
		int n = 1;
		while (true) {
			if (n > x / n)
				return n - 1;
			n++;
		}
	}

	public static void main(String args[]) {
		System.out.println(mySqrt(9));
	}
}
