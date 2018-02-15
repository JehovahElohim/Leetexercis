package leetcode;

import java.util.ArrayList;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * @author asus pc
 *
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		 int last = m+n-1;
	        int first = m - 1;
	        int second = n - 1;
	        
	        while (first >= 0 && second >= 0) {
	            if (nums1[first] > nums2[second]) {
	                nums1[last] = nums1[first--];
	            } else {
	                nums1[last] = nums2[second--];
	            }
	            last--;
	        }
	        
	        if (first < 0) {
	            for (int i = 0; i <= last; i++) {
	                nums1[i] = nums2[i];
	            }
	        }
	}

	public static void main(String args[]) {
		new MergeSortedArray().merge(new int[] { 0 }, 0, new int[] { 1 }, 1);
	}
}
