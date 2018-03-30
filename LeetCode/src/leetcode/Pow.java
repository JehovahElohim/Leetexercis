package leetcode;

public class Pow {
	public static double myPow(double x, int n) {
		boolean neg = false;
		if (x < 0) {
			neg = true;
			if (x == Double.MIN_VALUE)
				return x;
			x = Math.abs(x);
		}
		if (n == 0)
			return 1.0;
		boolean even = (n & 1) == 0;
		double sum = 1;
		double temp = x;

		boolean nNeg = false;
		if (n < 0) {
			nNeg = true;
			n = Math.abs(n);
			if (n == Integer.MIN_VALUE)
				n = Integer.MAX_VALUE;
		}

		while (n != 0) {
			if ((n & 1) != 0) {
				if (!nNeg)
					sum *= temp * (n & 1);
				else {
					sum /= temp * (n & 1);
				}
			}
			temp = temp * temp;
			n = n >> 1;
		}
		if (n == Integer.MIN_VALUE)
			sum /= x;

		return (neg && !even) ? -sum : sum;
	}

	public static void main(String args[]) {
		System.out.println(myPow(2, -1));
	}
}
