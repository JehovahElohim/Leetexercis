package leetcode;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] temp = new int[gas.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = gas[i] - cost[i];
		}

		int pre = 0;
		int next = 0;
		int sum = 0;
		int count = 0;
		while (true) {
			while (sum >= 0) {
				sum += temp[next];
				next = (next + 1) % gas.length;
				count++;
				if (count == gas.length && sum >= 0)
					return pre;
			}
			while (sum < 0) {
				sum -= temp[pre++];
				if (pre >= gas.length)
					return -1;
				count--;
			}
		}
	}
}
