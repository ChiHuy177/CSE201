package CSE201_Week7;

import java.io.IOException;
import java.io.InputStream;

import java.util.*;

public class EISTOCK2 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		HashMap<Long, Product> mapOfProduct = new HashMap<Long, Product>();

		int transaction = ni();
		while (transaction-- > 0) {
			String operator = ns();
			switch (operator) {
			case "+":
				long id = ni();
				long quantity = nl();
				long price = nl();
				int day = ni();
				if (mapOfProduct.get(id) == null) {
					mapOfProduct.put(id, new Product(id));
				}
				mapOfProduct.get(id).listOfIn4.add(new Information(day, quantity, price));
				mapOfProduct.get(id).addQuantity(quantity);
				break;

			case "-":
				long id1 = ni();
				long quantity1 = nl();
				long price1 = nl();
				int day1 = ni();
				if (mapOfProduct.get(id1) == null)
					break;

				if (mapOfProduct.get(id1).quantity < quantity1)
					break;
				else {
					mapOfProduct.get(id1).minusQuantity(quantity1);
					Product found = mapOfProduct.get(id1);
					while (quantity1 > 0) {
						if (quantity1 <= found.listOfIn4.peek().quantity) {
							long oldQuan = found.listOfIn4.peek().quantity;
							oldQuan -= quantity1;
							if (oldQuan == 0) {
								if (found.listOfIn4.size() > 1)
									found.listOfIn4.poll();
							} else {
								found.listOfIn4.get(0).setQuantity(oldQuan);

							}
							break;
						} else {
							if (found.listOfIn4.size() > 1)
								quantity1 -= found.listOfIn4.poll().quantity;
						}
					}
				}

				break;
			}

		}
		PriorityQueue<Product> qOfProduct = new PriorityQueue<Product>((o1, o2) -> {
			int compare = Long.compare(o1.id, o2.id);

			return compare;
		});

		qOfProduct.addAll(mapOfProduct.values());
		while (!qOfProduct.isEmpty()) {
			if (qOfProduct.peek().quantity > 0)
				sb.append(qOfProduct.poll().toString() + "\n");
			else
				qOfProduct.poll();
		}
		System.out.println(sb);

	}

	static class Product {
		long id;
		long quantity = 0;
		LinkedList<Information> listOfIn4 = new LinkedList<Information>();

		public Product(long id) {
			super();
			this.id = id;

		}

		public void addQuantity(long quan) {
			this.quantity += quan;
		}

		public void minusQuantity(long quan) {
			this.quantity -= quan;
		}

		public double getAverage() {
			long sum = 0;
			long total = 0;
			for (Information e : this.listOfIn4) {
				total += e.quantity;
				sum += (e.price * e.quantity);
			}
			return sum * 1.0 / total;
		}

		@Override
		public String toString() {

			return this.id + " " + this.quantity + " " + (long) Math.floor(this.getAverage()) + " "
					+ this.listOfIn4.peek().day;
		}

	}

	static class Information {
		long day;
		long quantity;
		long price;

		public Information(long day, long quantity, long price) {
			super();
			this.day = day;
			this.quantity = quantity;
			this.price = price;
		}

		public long getQuantity() {
			return quantity;
		}

		public void setQuantity(long quantity) {
			this.quantity = quantity;
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
