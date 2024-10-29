package CSE201_Week6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class EIUMEDARRAY4 {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();

		int testCase = reader.nextInt();
		while (testCase-- > 0) {
			int n = reader.nextInt();

			long a = reader.nextLong();
			long p = reader.nextLong();
			int k = reader.nextInt();
			long[] arr = new long[n];
			arr[0] = (a * a) % p;
			for (int i = 1; i < arr.length; i++) {
				arr[i] = (arr[i - 1] * a) % p;
			}
			sb.append(quickSort(arr, 0, n - 1, k) +"\n");
		}
		System.out.println(sb);
	}

	public static long quickSort(long arr[], int left, int right, int k) {

		int pivot = partition(arr, left, right);
		if (pivot == k - 1) {
			return arr[pivot];
		} else if (pivot > k - 1) {
			return quickSort(arr, left, pivot - 1, k);
		} else {
			return quickSort(arr, pivot + 1, right, k);
		}

	}

	private static int partition(long[] arr, int left, int right) {
		if (isAllElementsSame(arr, left, right)) {
			return (left + right) / 2;
		}
		int pivot = median(arr, left, right);
		int tempIndex = left + 1;
		for (int i = tempIndex; i <= right; i++) {
			if (arr[i] < arr[pivot]) {
				swap(arr, tempIndex++, i);
			}
		}
		swap(arr, pivot, tempIndex - 1);

		return tempIndex - 1;
	}

	public static void swap(long[] arr, int v1, int v2) {
		long temp = arr[v2];
		arr[v2] = arr[v1];
		arr[v1] = temp;
	}

	public static int median(long[] arr, int left, int right) {
		int mid = (left + right) / 2;
		if (arr[left] > arr[mid])
			swap(arr, left, mid);
		if (arr[left] > arr[right])
			swap(arr, left, right);
		if (arr[mid] > arr[right])
			swap(arr, mid, right);
		swap(arr, left, mid);
		return left;

	}

	static boolean isAllElementsSame(long arr[], int low, int high) {
		for (int i = low + 1; i <= high; i++) {
			if (arr[i] != arr[low]) {
				return false;
			}
		}
		return true;
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
