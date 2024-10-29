package CSE201;

import java.util.Arrays;
import java.util.Scanner;

public class EIKMAX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int k = sc.nextInt(), length = n - 1;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < k; i++) {
			sb.append(arr[length] + " ");
			length--;
		}
		System.out.println(sb);
	}

}
