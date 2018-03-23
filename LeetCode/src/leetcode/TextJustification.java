package leetcode;

/**
 * 题意：把一个集合的单词按照每行L个字符放，每行要两端对齐，如果空格不能均匀分布在所有间隔中，那么左边的空格要多于右边的空格，最后一行靠左对齐。
 */
import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		int len = 0;
		int count = 0;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if (len + words[i].length() + count <= maxWidth) {
				list.add(words[i]);
				count++;
				len += words[i].length();
			} else {
				StringBuilder sb = new StringBuilder(maxWidth + 1);
				if (count == 1) {
					sb.append(list.get(0));
					while (sb.length() < maxWidth)
						sb.append(' ');
				} else {
					int biggerCount = ((maxWidth - len) % (count - 1));
					int avg = (maxWidth - len) / (count - 1);
					for (String string : list) {
						sb.append(string);
						if (--count > 0) {
							for (int j = 0; j < avg; j++) {
								sb.append(' ');
							}
						}
						if (biggerCount > 0) {
							biggerCount--;
							sb.append(' ');
						}
					}
				}
				res.add(sb.toString());
				list.clear();
				list.add(words[i]);
				count = 1;
				len = words[i].length();
			}
		}
		StringBuilder sb = new StringBuilder(maxWidth + 1);
		for (String string : list) {
			sb.append(string);
			if (sb.length() < maxWidth)
				sb.append(' ');
		}
		while (sb.length() < maxWidth)
			sb.append(' ');
		res.add(sb.toString());
		return res;
	}

	public static void main(String args[]) {
		System.out.println(fullJustify(
				new String[] { "a", "b", "c", "d", "e" }, 3));
	}
}
