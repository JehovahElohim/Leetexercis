package leetcode;

public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < version1.length(); i++) {
			if (version1.charAt(i) == '.')
				count1++;
		}

		for (int i = 0; i < version2.length(); i++) {
			if (version2.charAt(i) == '.')
				count2++;
		}
		StringBuilder sb = new StringBuilder();
		int n = Math.abs(count1 - count2);
		for (int i = 0; i < n; i++) {
			sb.append('.').append(0);
		}
		if (count1 < count2) {
			version1 = version1 + sb.toString();
		} else if (count2 < count1) {
			version2 = version2 + sb.toString();
		}
		int p1 = 0, p2 = 0;
		int compare = 0;
		while (true) {
			int n1 = version1.indexOf('.', p1);
			int n2 = version2.indexOf('.', p2);
			if (n1 == -1 || n2 == -1)
				compare = Integer.parseInt(version1.substring(p1))
						- Integer.parseInt(version2.substring(p2));
			else
				compare = Integer.parseInt(version1.substring(p1, n1))
						- Integer.parseInt(version2.substring(p2, n2));
			p1 = n1 + 1;
			p2 = n2 + 1;
			if (compare < 0)
				return -1;
			else if (compare > 0)
				return 1;
			if (p1 == 0 && p2 == 0)
				return 0;
		}
	}

	public static void main(String args[]) {
		System.out.println(compareVersion("1", "1.0"));
	}
}
