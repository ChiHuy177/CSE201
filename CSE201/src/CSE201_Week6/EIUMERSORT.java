package CSE201_Week6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIUMERSORT {

	static InputReader sc = new InputReader(System.in);
	static int n = sc.nextInt();
	static int[] arr = new int[n];	
	static int[] result = new int[n];
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();

		
		for (int  i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}		
		mergeSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}
	
	
	
	public static void mergeSort(int[] arr, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int middle = (startIndex + endIndex) / 2;
		mergeSort(arr, startIndex, middle);
		mergeSort(arr, middle + 1, endIndex);
		merge(arr, startIndex, middle, endIndex);
	}

	private static void merge(int[] arr, int startIndex, int middle, int endIndex) {
		int pointer1 = startIndex;
		int pointer2 = middle + 1;
		int n = endIndex - startIndex;
		int i = 0;
		for ( i = 0; i < n; i++) {
			if (pointer1 > middle || pointer2 > endIndex)
				break;

			if (arr[pointer1] < arr[pointer2]) {
				result[i] = arr[pointer1];
				pointer1++;
			} else {
				result[i] = arr[pointer2];
				pointer2++;
			}
		}
		while ( pointer1 <= middle) {
			result[i++] = arr[pointer1++];					
		}
		while ( pointer2 <= endIndex) {
			result[i++] = arr[pointer2++];			
		}
		
		for ( i = 0; i < n; i ++) {
			arr[startIndex++] = result[i];
		}
		
		
		

	}
	
	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}
