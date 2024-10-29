package CSE201_Week7;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class EIULOGFILE2 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		long n = nl();
		long m = nl();
		
		long[] arr = new long[(int) n];
		long[] arr1 = new long[(int) m];
		
		for (int i = 0; i < n; i++) {
			arr[i] = nl();
		}
		Arrays.sort(arr);
		for (int i = 0; i < m; i++) {
			arr1[i] = nl();
		}
		
		long i = 0;
		while (m > 0) {
			sb.append( binarySearch(arr, arr1[(int) i++]) +" ");
			m--;
		}
		System.out.println(sb);
	}
	
	public static long binarySearch(long[] arr, long key) {
		int left = 0, right = arr.length - 1;
		int resultIndex = -1;
		
		if (arr[0] == key) {
			return arr[0];
		}
		
		while (right  - left > 0) {
			int middle = (left + right) / 2;
			if (key < arr[middle]) {
				resultIndex = middle;
				right = middle ;
			} else if (key == arr[middle]) {
				resultIndex = middle;
				right = middle ;
			} else {
				left = middle + 1;
				if (key <= arr[left]) {
					resultIndex = left;
					break;
				}
			}
			
		}
		
		
		
		if (resultIndex == -1)
			return -1;
		return arr[resultIndex];
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
