package CSE201;

import java.io.*;

import java.util.*;

public class EI2121Q1M2 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		InputReader reader = new InputReader(System.in);
		int numberOfStaff = reader.nextInt();
		Map<Integer, Integer> mapOfStaff = new LinkedHashMap<Integer, Integer>();
		while (numberOfStaff-- > 0) {
			int joinedYear = reader.nextInt();
			
			mapOfStaff.put(joinedYear, mapOfStaff.getOrDefault(joinedYear, 0) + 1);
		}
		PriorityQueue<Integer> listOfKey = new PriorityQueue<Integer>(((Integer o1,Integer o2) ->{
			return o1 - o2;
		}));
		listOfKey.addAll(mapOfStaff.keySet());
		
		while (!listOfKey.isEmpty()) {
			sb.append(listOfKey.peek() + " " + mapOfStaff.get(listOfKey.poll())+"\n");
		}
		
		
		
		
		System.out.println(sb);

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
