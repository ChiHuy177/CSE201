package CSE201_Week5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EIUGRADE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader reader = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Student> mapOfStudent = new HashMap<Integer, EIUGRADE.Student>();
		int testCase = reader.nextInt();
		while (testCase-- > 0) {
			int id = reader.nextInt();
			reader.next();
			double grade = reader.nextDouble();
			if (mapOfStudent.get(id) == null) {
				mapOfStudent.put(id, new Student(id));
				mapOfStudent.get(id).addSumAndCount(grade);
			}
			else {
				mapOfStudent.get(id).addSumAndCount(grade);
			}
			
			
			
		}
		PriorityQueue<Student> qOfStudent = new PriorityQueue<Student>(((Student s1, Student s2) -> {
			int compare = Double.compare(s2.getAverage(), s1.getAverage());
			if (compare == 0) {
				compare = s1.getId() - s2.getId();
			}
			return compare;
		}));
		
		
		qOfStudent.addAll( mapOfStudent.values());
		Student found = qOfStudent.poll();
		while (found!=null) {
			sb.append(found.getId() + " "+ found.getAverage()+"\n");
			found = qOfStudent.poll();
		}
		System.out.println(sb);
	}

	static class Student {
		int id;
		double average = 0;
		int count = 0;
		double sum = 0;

		public Student(int id) {
			super();
			this.id = id;

		}

		public void addSumAndCount(double number) {
			sum += number;
			count++;
		}

		public double getAverage() {
			return sum * 1.0 / count;
		}

		public int getId() {
			return id;
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
