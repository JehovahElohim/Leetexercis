package leetcode;

import java.util.LinkedHashMap;

public class LRUCache {
	LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
	int capacity;
	int lastKey;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		Integer res = map.get(key);
		if (res == null)
			return -1;
		map.remove(key);
		map.put(key, res);
		lastKey = map.entrySet().iterator().next().getKey();
		return res;
	}

	public void put(int key, int value) {
		if(lastKey==0){
			lastKey = key;
		}
		
		if (map.get(key) == null) {
			if (capacity <= map.size()) {
				map.remove(lastKey);
				map.put(key, value);
				lastKey = map.entrySet().iterator().next().getKey();
			}
			map.put(key, value);
		} else {
			map.remove(key);
			map.put(key, value);
			lastKey = map.entrySet().iterator().next().getKey();
		}
	}

	public static void main(String args[]) {
		LRUCache obj = new LRUCache(3);
		obj.put(1, 1);
		obj.put(2, 2);
		obj.put(3, 3);
		obj.put(4, 4);
		System.out.println(obj.get(4));
		System.out.println(obj.get(3));
		System.out.println(obj.get(2));
		System.out.println(obj.get(1));
		obj.put(5, 5);
		System.out.println(obj.get(1));
		System.out.println(obj.get(2));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));
		System.out.println(obj.get(5));
	}
}
