package leetcode;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * @author asus pc 思路：双指针
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen1(int sum, int[] nums) {
        int minlen = Integer.MAX_VALUE;
		int curSum = 0;
		int start = 0;
		int end = 0;
		
		while(start < nums.length){
			System.out.print(curSum+" ");
			//if current window doesn't add up to the given sum then 
			//strech the window to right
			if(curSum < sum && end < nums.length){
				curSum += nums[end];
				end++;
			}
			//if current window adds up to at least given sum then
			//we can shrink the window 
			else if(curSum >= sum){
				minlen = Math.min(minlen, end-start);
				curSum -= nums[start];
				start++;
			}
			//cur sum less than required sum but we reach the end 
			else{
				break;
			}
		}
		System.out.println();
		System.out.println(minlen);
		return (minlen == Integer.MAX_VALUE) ? 0 : minlen;
    }
	public static void main(String args[]) {
		new MinimumSizeSubarraySum().minSubArrayLen1(11, new int[] { 1, 2, 3, 4,
				5 });
	}
}
