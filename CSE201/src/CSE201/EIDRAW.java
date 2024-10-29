package CSE201;

import java.util.Scanner;

 class EIDRAW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); 
		int rows =  sc.nextInt();
		char one = '/';
		char two = '\\' ;
		char three = ' ';
		int started = 0;
		int space = rows + (rows-2);
		int space1 = 0;
		for (int i = 0; i<rows; i++) {
			for (int j = 0; j<i; j++) {
				sb.append(" ");
			}
			started++;
			sb.append(two);
			for (int j = 0; j<space; j++) {
				sb.append(" ");
			}
			
			sb.append(one);
			for (int j = 0; j<space1; j++) {
				sb.append(" ");
			}
			space1+=2;
			sb.append(two);
			for (int j = 0; j<space; j++) {
				sb.append(" ");
			}
			space -= 2;
			sb.append(one);
			sb.append("\n");
		}
		System.out.println(sb  );
		
	}

}
