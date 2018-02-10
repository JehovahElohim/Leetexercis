package _5_LongestPalindromicSubstring;

import java.util.ArrayList;
import java.util.Collection;
//求最长回文字符串
//马拉车算法： 时间复杂度O（n）
public class Solution {
	public String longestDrome(String s) {
		int[] p = new int[2048];
        StringBuilder t = new StringBuilder("$");
        for (int i = 0; i < s.length(); ++i) {
            t.append('#');
            t.append(s.charAt(i));
        }
        t.append("#_");
        // mx为已判断回文串最右边位置，id为中间位置，mmax记录p数组中最大值
        int mx = 0, id = 0, mmax = 0;
        int right = 0;
        for (int i = 1; i < t.length() - 1; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (t.charAt(i + p[i]) == t.charAt(i - p[i]))
                p[i]++;
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
            if (mmax < p[i]) {
                mmax = p[i];
                right = i;
            }
        }
        // 最长为mmax - 1
        return s.substring(right/2 - mmax/2, right/2 - mmax/2 + mmax-1);
	}

	public String longestPalindrome(String s) {
		if (s == null)
			return null;
		else if (s.length() <= 0)
			return s;
		char[] c = s.toCharArray();
		String temp = new String(c, 0, 1);
		int left = 0, right = 0;
		double center = 0;
		while (center < c.length - 1.5) {
			center = center + 0.5;
			left = (int) (center - 0.5);
			right = (int) (center + 1);
			if (s.charAt(left) != s.charAt(right))
				continue;
			while (left > 0 && right < s.length() - 1) {
				if (s.charAt(left - 1) != s.charAt(right + 1)) {
					break;
				}
				left--;
				right++;
			}
			if (right - left + 1 > temp.length()) {
				temp = new String(c, left, right - left + 1);
				System.out.println(center + "    " + temp);
			}
		}

		return temp;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		System.out.println(s.longestDrome("bbwefwef"));
	}
}
