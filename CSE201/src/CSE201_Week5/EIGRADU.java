package CSE201_Week5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIGRADU {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		InputReader reader = new InputReader(System.in);
		LinkedList<Student> listOfStudent = new LinkedList<Student>();
		int numberOfStudents = reader.nextInt();
		int passGrade = reader.nextInt();
		while (numberOfStudents-- > 0) {
			long id = reader.nextLong();
			String name = reader.next();
			int sum = 0;
			int credits = 0;
			int count = 0;
			int subs = reader.nextInt();
			
			for (int i = 0; i < subs; i++) {
				int grade  = reader.nextInt();

				if (grade >= 50) {
					credits += 4;
					sum += grade;
					count++;
				}
			}
			double gpa = 0;
			if (sum == 0) {
				gpa = 0;
			} else
				gpa = sum * 1.0 / count;
			if (credits >= passGrade) {
				Student newSt = new Student(id, name, gpa);
				listOfStudent.add(newSt);
			}
		}
		
		// SORTING
		Collections.sort(listOfStudent, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				int compare = Double.compare(o2.getGpa(), o1.getGpa());
				if (compare == 0) {
					compare = Long.compare(o1.getId(), o2.getId());
				}
				return compare;
			}
		});
		
		for (Student e : listOfStudent) {
			sb.append(e.toString()+"\n");
		}
		
		System.out.println(sb);
		
	}

	static class Student {
		long id = 0;
		String name;
		double gpa = 0;
		
		
		
		public Student(long id, String name, double average) {
			super();
			this.id = id;
			this.name = name;
			
			this.gpa = average;
		}

		

		public long getId() {
			return id;
		}



		public double getGpa() {
			return Math.floor(gpa);
		}



		@Override
		public String toString() {

			return id + " " + name + " " + (long)Math.floor(gpa);
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
