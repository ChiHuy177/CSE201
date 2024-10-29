package CSE201;

import java.io.*;
import java.util.*;

public class EI2121Q1M1 {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Staff> qOfStaff = new PriorityQueue<Staff>(((Staff o1,Staff o2) ->{
			int compare = o2.getGap() - o1.getGap();
			if (compare == 0) {
				compare = o1.name.compareTo(o2.name);
			}
			if (compare == 0) {
				compare = o1.id - o2.id;
			}
			return compare;
		}));
		
		
		int numberOfStudent = reader.nextInt();
		while (numberOfStudent-- > 0) {
			int id = reader.nextInt();
			String name = reader.next();
			int startYear = reader.nextInt();
			qOfStaff.add(new Staff(id, name, startYear));
		}
		while (!qOfStaff.isEmpty()) {
			sb.append(qOfStaff.poll().toString());
		}
		System.out.println(sb);

	}
	
	static class Staff{
		int id;
		String name;
		int startYear;
		
		public Staff(int id, String name, int startYear) {
			super();
			this.id = id;
			this.name = name;
			this.startYear = startYear;
		}
		
		public int getGap() {
			return 2021 - this.startYear;

		}
		
		@Override
		public String toString() {
			return this.id +" "+this.name+" "+this.getGap()+"\n";
		}
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
