package leetcode;

import java.util.Arrays;

public class ReverseWordsinaString {
	public static String reverseWords(String s) {
		s = s.trim();
		if (s == null || s.equals(""))
			return s;
		String[] temp = s.split(" ");
		System.out.println(Arrays.toString(temp));
		StringBuilder sb = new StringBuilder();
		sb.append(temp[temp.length - 1]);
		for (int i = temp.length - 2; i >= 0; i--) {
			if (!temp[i].equals(""))
				sb.append(' ').append(temp[i]);
		}
		System.out.println(sb);
		return sb.toString();
	}
	public static void main(String args[]){
		reverseWords("b   a");
	}
}
