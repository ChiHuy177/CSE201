package CSE201;

import java.util.Scanner;

public class EIDORM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		int result = 0;
		while (testCases>0) {
			int people = sc.nextInt();
			int maxSpace = sc.nextInt();
			if ((people+2)<=maxSpace)
				result+=1;
			
			
			testCases--;
		}
		System.out.println(result);
	}

}
