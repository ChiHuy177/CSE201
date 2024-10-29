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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class EISTULI {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		InputReader reader = new InputReader(System.in);
		LinkedList<Student> listOfStudent = new LinkedList<Student>();
		int numberOfStudents = reader.nextInt();
		int needToList = reader.nextInt();
		while (numberOfStudents-- > 0) {
			String id = reader.next();
			String name = reader.next();
			int sum = 0;
			int digits = 0;
			int count = 0;
			int subs = reader.nextInt();
			int[] arr = new int[subs];
			for (int i = 0; i < subs; i++) {
				arr[i] = reader.nextInt();

				if (arr[i] >= 50) {
					digits += 4;
					sum += arr[i];
					count++;
				}
			}
			double average = 0;
			if (sum == 0) {
				average = 0;
			} else
				average = sum * 1.0 / count;
			Student newSt = new Student(id, name, sum, digits, average);
			listOfStudent.add(newSt);
		}
		if (needToList == 0) {
			System.out.println("none");
		} else {

			Collections.sort(listOfStudent, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					int compare = Double.compare(o2.getAverage(), o1.getAverage());
					return compare;
				}
			});
			
			// show result 
			LinkedHashMap<Double, Integer> mapOfCheck = new LinkedHashMap<Double, Integer>();
			for (Student e : listOfStudent) {
				mapOfCheck.put(e.getAverage(), mapOfCheck.getOrDefault(e.average, 0) + 1);
			}
			ArrayList<Double> listOfGrade = new ArrayList<Double>(mapOfCheck.keySet());
			
			boolean flag = false;
			for (int i = 0; i < listOfGrade.size(); i++) {
				if (needToList == 0) {
					break;
				}
				int count = mapOfCheck.get(listOfGrade.get(i));
				if (count <= needToList) {
					needToList -= count;
					while (count-- > 0) {
						flag = true;
						sb.append(listOfStudent.removeFirst().toString() + "\n");
					}
				} else {
					if (!flag)
						sb.append("none");
					break;
				}

			}

			System.out.println(sb);

		}
	}

	static class Student {
		String id;
		String name;
		int sum = 0;
		int count = 0;
		int digits = 0;
		double average = 0;

		public Student(String id, String name, int sum, int digits, double average) {
			super();
			this.id = id;
			this.name = name;
			this.sum = sum;
			this.digits = digits;
			this.average = average;
		}

		public double getAverage() {
			return this.average;
		}

		@Override
		public String toString() {

			return id + " " + name + " " + Math.round(average) + " " + digits;
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
