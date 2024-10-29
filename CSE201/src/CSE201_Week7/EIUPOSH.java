package CSE201_Week7;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Stack;

public class EIUPOSH {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		HashMap<String, Boolean> mapOfSymbol = new HashMap<String, Boolean>();
		
		mapOfSymbol.put("+", true);
		mapOfSymbol.put("-", true);
		mapOfSymbol.put("*", true);
		mapOfSymbol.put("/", true);
		
		int testCase = ni();
		while (testCase-- > 0) {
			int n = ni();
			Stack<Double> mapOfValue = new Stack<Double>();
			for (int i = 0; i < n; i++) {
				String k = ns();
				if (mapOfSymbol.get(k) != null ) {
					if (k.equalsIgnoreCase("+")) {
						double number2 = mapOfValue.pop();
						double number1 = mapOfValue.pop();
						mapOfValue.add(number1 + number2);
					} else if (k.equalsIgnoreCase("-")) {
						double number2 = mapOfValue.pop();
						double number1 = mapOfValue.pop();
						mapOfValue.add(number1 - number2);
					} else if (k.equalsIgnoreCase("*")) {
						double number2 = mapOfValue.pop();
						double number1 = mapOfValue.pop();
						mapOfValue.add(number1 * number2);
					} else  {
						double number2 = mapOfValue.pop();
						double number1 = mapOfValue.pop();
						mapOfValue.add(number1 / number2);
					}
				}
				else {
					mapOfValue.add(Double.parseDouble(k));
				}
			}
			sb.append(mapOfValue.pop() + "\n");
		}
		System.out.println(sb);

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
