package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 首先找到最高的，然后从左往最高处扫，碰到一个数A[i]，计算A[0,,,i-1]最高的是否高过A[i]，如果是，则A[i]上的水的体积为max(A[0..
 * .i-1])-A[i],否则为0并且更新最大值
 * 
 * 从右往最高处再同样扫一遍
 * 
 * @author asus pc
 *
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		if (height.length < 3)
			return 0;
		int max = height[0], maxIndex = 0;
		for (int i = 1; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
				maxIndex = i;
			}
		}
		int area = 0, temp = height[0];
		for (int i = 1; i < maxIndex; i++) {
			if (height[i] > temp) {
				temp = height[i];
			} else {
				area = area + temp - height[i];
			}
		}
		temp = height[height.length - 1];
		for (int i = height.length - 2; i > maxIndex; i--) {
			if (height[i] > temp) {
				temp = height[i];
			} else {
				area = area + temp - height[i];
			}
		}
		return area;
	}

	public static void main(String args[]) {
		System.out.println(new TrappingRainWater().trap(new int[] { 0, 1, 0, 2,
				1, 0, 1, 3, 2, 1, 2, 1 }));
	}
}
