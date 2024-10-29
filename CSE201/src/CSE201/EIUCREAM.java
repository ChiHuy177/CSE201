package CSE201;

import java.util.Scanner;

public class EIUCREAM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long iceCream = sc.nextLong();
		long buyToGet = sc.nextLong();
		long res = iceCream;
		long du = 0;
		while (iceCream >= buyToGet) {
			res += iceCream / buyToGet;
			du = iceCream % buyToGet;
			iceCream = iceCream / buyToGet + du;
			
		}

		System.out.println(res);
	}

}
