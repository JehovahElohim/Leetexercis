package leetcode;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		String[] sub = path.split("/");
		List<String> files = new ArrayList<String>();
		for (int i = 0; i < sub.length; i++) {
			if (sub[i].equals("") || sub[i].equals("."))
				continue;
			else if (sub[i].equals("..")) {
				if (files.size() > 0) {
					files.remove(files.size() - 1);
				}
			} else {
				files.add(sub[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String string : files) {
			sb.append("/").append(string);
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}

	public static void main(String args[]) {
		System.out.println(simplifyPath("/a/./b/../../c/"));
	}

}
