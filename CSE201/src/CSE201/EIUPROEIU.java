package CSE201;

import java.util.Scanner;

public class EIUPROEIU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int space = n / 2;
		// cot 1
		String first = " ";
		String middle = "|";
		String last = "|";
		String normal = "|";

		for (int i = 0; i < space; i++) {
			first += "_";
			middle += "_";
			last += "_";
			normal += " ";
		}

		for (int i = 0; i <= 3; i++) {
			if (i == 0) {
				first += " ";
				middle += " ";
				last += " ";
				normal += " ";
			} else if (i == 1) {
				first += " ";
				middle += "|";
				last += "|";
				normal += "|";
			} else if (i == 2) {
				first += " ";
				middle += " ";
				last += " ";
				normal += " ";
			} else {
				first += " ";
				middle += "|";
				last += "|";
				normal += "|";
			}
		}
		for (int i = 0; i <= space ; i++) {
			if (i == space ) {
				first += " ";
				middle += "|";
				last += "|";
				normal += "|";
			} else {
				first += " ";
				middle += " ";
				last += "_";
				normal += " ";
			}

		}
		

		sb.append(first + "\n");
		for (int  i = 0; i < n / 2 - 1; i++) {
			sb.append(normal + "\n");
		}
		sb.append(middle+"\n");
		for (int  i = 0; i < n /2 - 1; i++) {
			sb.append(normal + "\n");
		}
		sb.append(last);
		

		System.out.println(sb);
	}

}
