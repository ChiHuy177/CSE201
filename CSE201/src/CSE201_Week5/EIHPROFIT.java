package CSE201_Week5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIHPROFIT {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		//InputReader reader = new InputReader(System.in);
		int numberOfProduct = ni();
		int needToRank = ni();
		PriorityQueue<Product> listOfProduct = new PriorityQueue<Product>(((Product o1, Product o2) -> {
			int compare = Double.compare(o2.getProfit(), o1.getProfit());
			if (compare == 0) {
				compare = o1.identity - o2.identity;
			}
			return compare;
		}));
		while (numberOfProduct-- > 0) {
			int identity = ni();
			String name = ns();
			double price = ni();
			double cost = ni();
			double sold = ni();
			listOfProduct.add(new Product(identity, name, price, cost, sold));
		}
		if (needToRank > 0) {
			double temp = listOfProduct.peek().getProfit();
			sb.append(listOfProduct.poll().toString());
			needToRank--;
			while (!listOfProduct.isEmpty() && needToRank-- > 0) {
				if (temp != listOfProduct.peek().getProfit()) {
					temp = listOfProduct.peek().getProfit();
					
					
				} else {
					
				}sb.append(listOfProduct.poll().toString());
				
			}
			while (!listOfProduct.isEmpty() && temp == listOfProduct.peek().getProfit()) {
				sb.append(listOfProduct.poll().toString());
			}
			
		}
		System.out.println(sb);

	}
	
	static class Product{
		int identity;
		String name;
		double price;
		double cost;
		double sold;
		
		public Product(int identity, String name, double price2, double cost2, double sold2) {
			super();
			this.identity = identity;
			this.name = name;
			this.price = price2;
			this.cost = cost2;
			this.sold = sold2;
		}
		
		
		
		public double getProfit() {
			return (this.price - this.cost) * sold;
		}
		
		@Override
		public String toString() {
			return this.identity +" "+ this.name + " "+ (long)this.getProfit() +"\n" ;
		}
		
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
