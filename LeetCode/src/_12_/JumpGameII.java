package _12_;

public class JumpGameII {
	public int jump(int[] nums) {
		if (nums.length <= 1) return 0;
        int reach = nums[0];
        int lastreach = 0;
        int step = 0;
        
        for (int i = 1; i <= reach && i < nums.length; i++) {
            if (i > lastreach) {
                step++;
                lastreach = reach;
            }
            reach = Math.max(reach, i+nums[i]);
        }
        if (reach < nums.length-1) return 0;
        return step;
    }


	public static void main(String args[]) {
		System.out.println(new JumpGameII().jump(new int[] { 0, 1, 0, 2, 1, 0,
				1, 3, 2, 1, 2, 1 }));
	}
}
