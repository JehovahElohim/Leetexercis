package leetcode;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height.length < 2) {
			return 0;
		}
		int left = 0;
		int right = height.length - 1;
		int max = Math.min(height[left], height[right]) * (right - left);
		while (left < right) {
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
			max = Math.max(max, Math.min(height[left], height[right])
					* (right - left));
		}
		return max;
	}

	public static void main(String args[]) {
		ContainerWithMostWater s = new ContainerWithMostWater();
	}
}
