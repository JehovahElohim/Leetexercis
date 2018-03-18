package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public static List<String> restoreIpAddresses(String s) {
		List<String> temp = new ArrayList<String>();
		List<String> res = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12)
			return res;
		dfs(res, temp, s, 0, 0);
		for (String string : res) {
			System.out.println(string);
		}
		return res;
	}

	static void dfs(List<String> res, List<String> temp, String s, int start,
			int count) {
		int len = s.length();
		if (count == 4) {
			if (start == len) {
				StringBuilder sb = new StringBuilder(16);
				for (int i = 0; i < 4; i++) {
					sb.append(temp.get(i));
					if (i != 3)
						sb.append('.');
				}
				res.add(sb.toString());
			}
			return;
		} else if (count > 4 || (count < 4 && len < start)) {
			return;
		}
		for (int i = 1; i < 4; i++) {
			if (start + i > len)
				break;
			String subIp = s.substring(start, start + i);
			if (isSubIp(subIp)) {
				temp.add(subIp);
				dfs(res, temp, s, start + i, ++count);
				temp.remove(temp.size() - 1);
				count--;
			}
		}
	}

	static boolean isSubIp(String s) {
		if (s.equals("0"))
			return true;
		else if (s.equals("") || s.charAt(0) == '0')
			return false;
		int i = 0;
		try {
			i = Integer.valueOf(s);
		} catch (Exception e) {
			return false;
		}
		if (i > 0 && i < 256)
			return true;
		return false;
	}

	public static void main(String args[]) {
		restoreIpAddresses("010010");
	}
}
