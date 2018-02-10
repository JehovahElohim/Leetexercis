package _12_;

public class IntegertoRoman {
	/**
	 * Given an integer, convert it to a roman numeral.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	// I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000） MMMDLDXCIX
	// 左减的数字有限制，仅限于I、X、C。
	// 4 9 40 90 400 900
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			if (num >= 900) {
				if (num >= 1000) {
					sb.append('M');
					num = num - 1000;
				} else {
					sb.append("CM");
					num = num - 900;
				}
			} else if (num >= 500) {
				sb.append('D');
				num = num - 500;
			} else if (num >= 400) {
				sb.append("CD");
				num = num - 400;
			} else if (num >= 100) {
				sb.append('C');
				num = num - 100;
			} else if (num >= 90) {
				sb.append("XC");
				num = num - 90;
			} else if (num >= 50) {
				sb.append("L");
				num = num - 50;
			} else if (num >= 40) {
				sb.append("XL");
				num = num - 40;
			} else if (num >= 10) {
				sb.append("X");
				num = num - 10;
			} else {
				if (num == 9) {
					sb.append("IX");
					break;
				} else if (num >= 5) {
					sb.append("V");
					num = num - 5;
				} else if (num == 4) {
					sb.append("IV");
					break;
				} else {
					while (num > 0) {
						sb.append("I");
						num--;
					}
				}
			}

		}
		return sb.toString();
	}

	public static void main(String args[]) {
		System.out.println(new IntegertoRoman().intToRoman(3999));
	}
}
