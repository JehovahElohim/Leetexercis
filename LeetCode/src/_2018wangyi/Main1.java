package _2018wangyi;

import java.util.Scanner;

public class Main1 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		Room[] rooms = new Room[s.nextInt()];
		int ad = s.nextInt();
		int ch = s.nextInt();
		int n = s.nextInt();
		
	}

	public static Room readRoom(Scanner s) {
		Room r = new Room();
		r.adult = s.nextInt();
		r.child = s.nextInt();
		r.price = s.nextDouble();
		return r;
	}
}

class Room {
	int adult;
	int child;
	double price;
}