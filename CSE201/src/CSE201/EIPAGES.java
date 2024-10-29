package CSE201;

import java.util.Arrays;
import java.util.Scanner;

public class EIPAGES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int firstPage = arr[0], count = 0;;
		
		for (int i = 1; i<n; i++) {
			if ((arr[i] - firstPage) == 1 + count) {
				count += 1;
			}
			else {
				if (count >= 2) {
					sb.append(firstPage + "-"+ arr[i-1]+" ");
					
				}
				else {
					if (count == 0) {
						sb.append(firstPage+" ");
					}
					else {
						sb.append(firstPage+" "+ arr[i-1]+" ");
					}
					
				}
				count = 0;
				firstPage = arr[i];
			}
			
		}
		if (count == 1) {
			sb.append(arr[n-2]+" "+ arr[n-1]);
		}else if (count >= 2) {
			sb.append(arr[n-1]-count+"-"+ arr[n-1]);
		} else if (count == 0)
			sb.append(firstPage);
	
		
		
		System.out.println(sb);
		
	}

}
