package CSE201_Week7;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class EI2122Q1ADAM2 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int numberOfMen = ni();
		int numberOfWomen = ni();
		int needToPair = ni();
		int[] heightOfMen = new int[numberOfMen];
		int[] heightOfWomen = new int[numberOfWomen];
		for (int i = 0; i < numberOfMen; i++) {
			heightOfMen[i] = ni();
		}
		for (int i = 0; i < numberOfWomen; i++) {
			heightOfWomen[i] = ni();
		}
		Arrays.sort(heightOfMen);
		Arrays.sort(heightOfWomen);
		System.out.println(binarySearch(heightOfMen, heightOfWomen, 0, (heightOfMen[numberOfMen - 1] - heightOfWomen[0]), needToPair));
		//System.out.println(checkTwoPointer(heightOfMen, heightOfWomen, 12));
	}

	public static int binarySearch(int[] heightOfMen, int[] heightOfWomen, int left, int right, int needToPair){
		while (left <= right){
			int mid = (left + right) / 2;
			boolean check  = checkTwoPointer(heightOfMen, heightOfWomen, mid, needToPair);
			if (check) {
				right = mid - 1 ;
			} 
			else {
				left = mid + 1;
			}
			 
		}

		return left;
	}

	public static boolean checkTwoPointer(int[] heightOfMen, int[] heightOfWomen, int checkHeight, int needToPair) {
		int count = 0;
		int i = 0, j = 0;
		while (i < heightOfMen.length && j < heightOfWomen.length) {
			if (Math.abs(heightOfMen[i] - heightOfWomen[j]) <= checkHeight){
				count++;
				i++;
				j++;
			} else {
				if (heightOfMen[i] > heightOfWomen[j]){
					j++;
				} else {
					i++;
				}
			}
		}
		
		if (count >= needToPair ){
			return true;
		}

		return false;
	}

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
