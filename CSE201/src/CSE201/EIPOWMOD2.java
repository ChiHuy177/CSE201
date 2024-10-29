package CSE201;

import java.util.Scanner;

public class EIPOWMOD2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		System.out.println(powMod(a,b,c));
		
	}
	
	public static long powMod (long a, long b, long c) {
		
		if (c == 1) {
			return 0;
		}
		else {
			//long result = 0;
			long r = 1;
			//long x = a;
			a = a % c;
			while (b>0) {
				if (b%2 == 1) {
					r = (r*a) % c;
				}
				a = (a*a) % c;
				b = b >> 1;
			}
			return r;
		}
		
		
		
		
		
	}

}
