package CSE201;

import java.io.*;
import java.util.*;

class EIUGIFT1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();

		double gifts = reader.nextDouble();
		double papers = reader.nextDouble();
		ArrayList<Double> listOfGift = new ArrayList<Double>();
		ArrayList<Double> listOfPaper = new ArrayList<Double>();
		for (int i = 0; i < gifts; i++) {
			listOfGift.add(reader.nextDouble());
		}
		for (int i = 0; i < papers; i++) {
			listOfPaper.add(reader.nextDouble());
		}
		Collections.sort(listOfGift);
		Collections.sort(listOfPaper);

		int giftInList = 0;
		int paperInList = 0;
		int res = 0;
		while (giftInList < gifts) {
			if (paperInList == papers || giftInList == gifts) {
				break;
			} else {
			double check = listOfPaper.get(paperInList) / listOfGift.get(giftInList);
			if (check < 2) {
				paperInList++;

			} else if (check <= 3 && check >= 2) {
				paperInList++;
				giftInList++;
				res++;
			}

			else if (check > 3) {

				giftInList++;
			}}

		}
		System.out.println(res);
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