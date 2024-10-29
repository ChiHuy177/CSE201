package CSE201_Week7;

import java.util.*;
import java.io.*;

class EICARDSYS {

	public static void main(String[] args) {
		
		InputReader reader = new InputReader(System.in);
		HashMap<String, Long> customer = new HashMap<String, Long>();

		int n = reader.nextInt();
		double discount = 0;
		for (int i = 0; i < n; i++) {
			String cusCode = reader.next();
			long moneyInput = reader.nextLong();
			if (customer.containsKey(cusCode) == false) {
				customer.put(cusCode, (long) 0);
			}

			if (customer.get(cusCode) < 1000000)
				discount += moneyInput * 0;
			else if (customer.get(cusCode) < 20000000)
				discount += moneyInput * 0.02;
			else if (customer.get(cusCode) < 50000000)
				discount += moneyInput * 0.03;
			else if (customer.get(cusCode) < 200000000)
				discount += moneyInput * 0.05;
			else if (customer.get(cusCode) < Long.MAX_VALUE)
				discount += moneyInput * 0.07;

			customer.put(cusCode, customer.get(cusCode) + moneyInput);
		}

		System.out.println(String.format("%.2f", discount));
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
