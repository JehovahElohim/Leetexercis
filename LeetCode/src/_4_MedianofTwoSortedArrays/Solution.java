package _4_MedianofTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 *
 * 一般思路：给2个数组排序，取排序后数组的中间值
 * 优化思路：求KthNumer，在2个数组中求第K大的数，如果A[K/2]大于B[K/2]，则舍弃B前K/2的数.
 */
public class Solution {

	// 正常
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int up = 0, down = 0, total = 0;
		List<Integer> list = new ArrayList<Integer>(30);
		while (up < nums1.length || down < nums2.length) {
			total++;
			if (up == nums1.length) {
				list.add(nums2[down++]);
			} else if (down == nums2.length) {
				list.add(nums1[up++]);
			} else {
				if (nums1[up] >= nums2[down]) {
					list.add(nums2[down++]);
				} else {
					list.add(nums1[up++]);
				}
			}
		}
		return total % 2 == 1 ? list.get((total - 1) / 2) : (double) (list
				.get(total / 2) + list.get(total / 2 - 1)) / 2;
	}

	// 优化：
	public double optimization(int[] nums1, int[] nums2) {
		int total = (nums1.length + nums2.length);
		if (total % 2 == 0) {
			System.out.println("偶数");
			return (findKth(nums1, 0, nums1.length - 1, nums2, 0,
					nums2.length - 1, total / 2) + findKth(nums1, 0,
					nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 + 1)) / 2;
		} else {
			System.out.println("奇数");
			return findKth(nums1, 0, nums1.length - 1, nums2, 0,
					nums2.length - 1, total / 2 + 1);
		}
	}

	// 1 2 di3
	// 1 2
	public double findKth(int[] A, int astart, int aend, int[] B,
			int bstart, int bend, int k) {
		 int m = aend - astart + 1;
		      int n = bend - bstart + 1;
		      
		      if(m>n)
		          return findKth(B,bstart,bend,A,astart,aend,k);
		      if(m==0)
		          return B[k-1];
		      if(k==1)
		          return Math.min(A[astart],B[bstart]);
		      
 
		      int partA = Math.min(k/2,m);
		      int partB = k - partA;
		      if(A[astart+partA-1] < B[bstart+partB-1])
		          return findKth(A,astart+partA,aend,B,bstart,bend,k-partA);
		      else if(A[astart+partA-1] > B[bstart+partB-1])
		          return findKth(A,astart,aend,B,bstart+partB,bend,k-partB);
		      else
		          return A[astart+partA-1];
		      }

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] nums1 = { 1, 3, 10, 11 };
		int[] nums2 = { 1, 3, 5, 9, 13 };
		System.out.println(s.optimization(nums1, nums2));
	}
}
