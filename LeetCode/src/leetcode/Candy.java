package leetcode;


public class Candy {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		int subjected[] = new int[ratings.length];
		subjected[0] = 1;
		for (int i = 1; i < subjected.length; i++) {
			subjected[i] = ratings[i] > ratings[i - 1] ? subjected[i - 1] + 1
					: 1;
		}
		int sum = subjected[subjected.length - 1];
		for (int i = subjected.length - 1; i > 0; i--) {
			if (ratings[i] < ratings[i - 1]) {
				subjected[i - 1] = Math.max(subjected[i - 1], subjected[i] + 1);
			}
			sum += subjected[i - 1];
		}
		return sum;
	}
}
