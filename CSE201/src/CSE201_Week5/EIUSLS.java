package CSE201_Week5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EIUSLS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader reader = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Student> mapOfStudent = new HashMap<Integer, Student>();

		int testCase = reader.nextInt();
		int value = 0;
		while (testCase-- > 0) {
			String name = reader.next();
			int n = reader.nextInt();
			int count = 0;
			int sum = 0;
			while (n-- > 0) {
				sum += reader.nextInt();
				count++;
			}
			mapOfStudent.put(value++, new Student(name, sum, count));
		}

		ArrayList<Student> listOfStudent = new ArrayList<Student>(mapOfStudent.values());
		Collections.sort(listOfStudent, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				int compare = Double.compare(s2.getAverage(), s1.getAverage());
				if (compare == 0)
					return 0;
				return compare;
			}
		});
		if (listOfStudent.size() == 1) {
			sb.append(listOfStudent.get(0).toString());
		} else {
			for (int i = 0; i < 2; i++) {
				sb.append(listOfStudent.get(i).toString());
			}
		}
		System.out.println(sb);
	}

	static class Student {
		String name;
		int sum = 0;
		int count = 0;
		double average = 0;

		public Student(String name, int sum, int count) {
			super();
			this.name = name;
			this.sum = sum;
			this.count = count;
		}

		public double getAverage() {
			return sum * 1.0 / count;
		}

		@Override
		public boolean equals(Object obj) {
			Student student = (Student) obj;
			if (this.getAverage() == student.getAverage()) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {

			return name + "\n";
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
