package leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
 * 
 * @author asus pc
 *	思路：二分查找
 */
public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0||matrix[0].length==0)
			return false;
		int left = 0, right = matrix.length * matrix[0].length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			System.out.print(mid+ " ");
			System.out.print(mid / matrix.length+" ");
			System.out.println(mid % matrix.length);
			if (matrix[mid / matrix[0].length][mid % matrix[0].length] < target) {
				left = mid + 1;
			} else if (matrix[mid / matrix[0].length][mid % matrix[0].length] > target) {
				right = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
	public static void main(String args[]){
		new Searcha2DMatrix().searchMatrix(new int[][]{{1,1}}, 2);
	}
}
