package leetcode;

import java.util.Arrays;

/**
 * 一个非负整数被表示为一个数组，数组中每一个元素代表该整数的一个位。数组的下标越小，代表的位数越高。现在对该数组做加一运算，请返回结果数组。
 * 
 * @author asus pc
 *
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (i == digits.length - 1) {
				digits[i] = (digits[i] + 1 + carry) % 10;
				carry = digits[i] == 0 ? 1 : 0;
			} else {
				digits[i] = (digits[i] + carry) % 10;
				carry = digits[i] == 0 ? 1 : 0;
			}
			if (carry == 0)
				break;
		}
		if (carry == 1) {
			int[] a = new int[digits.length + 1];
			a[0] = 1;
			System.arraycopy(digits, 0, a, 1, digits.length);
			return a;
		}
		return digits;
	}
}
