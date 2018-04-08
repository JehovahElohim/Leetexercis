package leetcode;

public class CountingBits {
	public static int[] countBits(int num) {
		int[] res = new int[num + 1];
		res[0] = 0;
		int t = 1;
		for (int i = 1; i < res.length; i++) {
			if (2 * t >= i)
				t *= 2;
			res[i] = res[i - t] + 1;
		}
		return res;
	}

}
