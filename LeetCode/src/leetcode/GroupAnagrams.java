package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<Arr, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			Arr a = new Arr(strs[i]);
			List<String> temp = map.get(a);
			if (temp == null) {
				temp = new ArrayList<String>();
				temp.add(strs[i]);
				map.put(a, temp);
			} else {
				map.get(a).add(strs[i]);
			}
		}
		res.addAll(map.values());
		
		return res;
	}

	public static boolean isSimilar(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 != len2)
			return false;
		int quantity[] = new int[26];
		for (int i = 0; i < len1; i++) {
			quantity[s1.charAt(i) - 'a']++;
			quantity[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < quantity.length; i++) {
			if (quantity[i] != 0)
				return false;
		}
		return true;
	}

	static class Arr {
		int[] value = new int[26];

		public Arr() {
			super();
		}

		public Arr(String s1) {
			int len1 = s1.length();
			for (int i = 0; i < len1; i++) {
				value[s1.charAt(i) - 'a']++;
			}
		}

		@Override
		public int hashCode() {
			return Arrays.hashCode(value);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Arr other = (Arr) obj;
			if (!Arrays.equals(value, other.value))
				return false;
			return true;
		}
	}

	public static void main(String args[]) {
		System.out.println(new Arr().equals(new Arr()));
	}

}
