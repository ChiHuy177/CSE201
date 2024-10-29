package CSE201_Week6;

import java.io.*;
import java.util.*;

public class EIAPPLEBOX {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();

		int testCase = reader.nextInt();
		while (testCase-- > 0) {
			int n = reader.nextInt();

			long a = reader.nextLong();
			long p = reader.nextLong();
			long[] arr = new long[n];
			long[] result = new long[arr.length];
			arr[0] = (a * a) % p;
			for (int i = 1; i < arr.length; i++) {
				arr[i] = (arr[i - 1] * a) % p;
			}

			sb.append(mergeSort(arr, 0, arr.length - 1, result) + "\n");

		}
		System.out.println(sb);

	}

	public static long mergeSort(long[] arr, int startIndex, int endIndex, long[] result) {
		long count = 0;
		if (startIndex >= endIndex) {
			return count;
		}
		int middle = (startIndex + endIndex) / 2;
		count += mergeSort(arr, startIndex, middle, result);
		count += mergeSort(arr, middle + 1, endIndex, result);
		count += merge(arr, startIndex, middle, endIndex, result);
		return count;

	}

	private static long merge(long[] arr, int startIndex, int middle, int endIndex, long[] result) {
		int pointer1 = startIndex;
		int pointer2 = middle + 1;
		long swap = 0;
		int n = (middle - startIndex + 1) + (endIndex - middle);

		int i = 0;
		while (pointer1 <= middle && pointer2 <= endIndex) {
			if (arr[pointer1] < arr[pointer2]) {
				result[i] = arr[pointer1++];
				i++;
			} else {
				result[i] = arr[pointer2++];
				swap += (middle - pointer1 + 1);
				i++;
			}
		}

		while (pointer1 <= middle) {
			result[i++] = arr[pointer1++];

		}
		while (pointer2 <= endIndex) {
			result[i++] = arr[pointer2++];

		}

		for (i = 0; i < n; i++) {
			arr[startIndex++] = result[i];
		}
		return swap;
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
