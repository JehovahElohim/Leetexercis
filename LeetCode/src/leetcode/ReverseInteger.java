package leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		boolean isNeg = false;
        int num = 0;
        if(x<0) {
            isNeg = true;
            x = -x;
        }
 
        //System.out.println(Integer.MAX_VALUE);
        while(x>0) {
            if((long) num*10 > Integer.MAX_VALUE) {
                return 0;
            }
            num = num*10 + x%10;
            //System.out.println(num);
            x = x/10;
        }
        num = isNeg ? -num : num;
        return num;
	}

	public static void main(String args[]) {
		ReverseInteger s = new ReverseInteger();
 		System.out.println(s.reverse(-2147447412));
	}
}
