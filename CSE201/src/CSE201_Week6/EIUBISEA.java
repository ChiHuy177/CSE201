package CSE201_Week6;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class EIUBISEA {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int n = ni();
		int m = ni();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ni();
		}
		Arrays.sort(arr);
		int[] arr2 = new int[m];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = ni();
		}

		int i = 0;
		while (m-- > 0) {
			sb.append(binarySearch(arr, arr2[i++]) + " ");
		}
		System.out.println(sb);

	}

	public static int binarySearch(int[] arr, int key) {
		int left = 0, right = arr.length - 1;
		int resultIndex = -1;
		if (arr[0] == key) {
			return 0;
		}
		while (right - left > 0) {
			int middle = (left + right) / 2;
			if (arr[middle] < key ) {
				left = middle + 1;
				if (arr[middle + 1] == key) {
					resultIndex = middle + 1;
					break;
				}
			} else if (arr[middle] > key) {
				right = middle - 1;
			} else {
				right = middle;
			}
		}

		return resultIndex;
	}

	// High performance
	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

}
