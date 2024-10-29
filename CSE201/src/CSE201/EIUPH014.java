package CSE201;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class EIUPH014 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			} else {
				int[] arr = new int[n];
				int[] newRow = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
				}
				boolean flag = true;
				int count = 0, countEqual = 0;

				for (int i = 1; i < n; i++) {
					if (arr[i] != arr[i - 1]) {
						flag = false;
					}
				}
				if (flag == false) {
					count += 1;
					while (!flag) {
						arr = newRow(arr, n);
						for (int i = 1; i < n; i++) {
							if (count >= 1000) {
								count = -1;
								flag = true;
								break;
							} else {
								if (arr[i] != arr[i - 1]) {
									count += 1;
									countEqual = 0;
									break;
								} else {
									countEqual += 1;
								}
								if (countEqual == (n - 1)) {
									flag = true;
								}

							}
						}
					}
					System.out.println(count);

				} else  {
					System.out.println("0");
				}
			}

		}
	}

	public static int[] newRow(int[] arr, int n) {
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			if (i == (n - 1)) {
				res[i] = Math.abs(arr[i] - arr[0]);
			} else {
				res[i] = Math.abs(arr[i] - arr[i + 1]);
			}
		}

		return res;
	}
}
