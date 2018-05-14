package leetcode;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			int yu = n % 26;
			if (yu == 0)
				yu = 26;
			n = (n - yu) / 26;
			sb.append((char) (yu + 'A' - 1));
		}
		return sb.reverse().toString();
	}
}
