package CSE201_Week7;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class EISTOCK {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Product> mapOfProduct = new HashMap<Integer, Product>();
		int transaction = ni();
		while (transaction-- > 0) {
			String operator = ns();
			switch (operator) {
			case "+":
				int id = ni();
				long quantity = nl();
				long price = nl();
				if (mapOfProduct.get(id) == null) {
					mapOfProduct.put(id, new Product(id));
				}
				mapOfProduct.get(id).setAddQuantity(quantity);
				mapOfProduct.get(id).setAddImport(price * quantity);
				break;
				
			case "-":
				int id1 = ni();
				long quantity1 = nl();
				long price1 = nl();
				if (mapOfProduct.get(id1) == null) {
					break;
				} else {
					if (quantity1 <= mapOfProduct.get(id1).quantity) {
						mapOfProduct.get(id1).setAddExport(price1 * quantity1);
						mapOfProduct.get(id1).setQuantity(mapOfProduct.get(id1).quantity - quantity1);
					}
				}

				break;
			}

		}
		PriorityQueue<Product> qOfProduct = new PriorityQueue<Product>((o1, o2) -> {
			int compare = o1.id - o2.id;
			
			return compare;
		});
		
		qOfProduct.addAll(mapOfProduct.values());
		while (!qOfProduct.isEmpty()) {
			sb.append(qOfProduct.poll().toString() +"\n");
		}
		System.out.println(sb);

	}

	static class Product {
		private int id;
		private long import1 = 0;
		private long export = 0;
		private long quantity = 0;

		public Product(int id) {
			super();
			this.id = id;

		}
		
		

		public long getQuantity() {
			return quantity;
		}



		public void setQuantity(long quantity) {
			this.quantity = quantity;
		}



		public void setAddImport(long price) {
			this.import1 += price;
		}

		public void setAddQuantity(long quantity) {
			this.quantity += quantity;
		}
		
		public void setAddExport(long price) {
			this.export += price;
		}

		@Override
		public String toString() {

			return this.id + " " + this.import1 + " " + this.export;
		}
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
