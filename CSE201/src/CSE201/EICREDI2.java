package CSE201;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EICREDI2 {

	public static void main(String[] args) {
		MyInputReader reader = new MyInputReader(System.in);
		StringBuilder sb = new StringBuilder();
		
		int numberOfStudents = reader.nextInt();
		while (numberOfStudents-- > 0) {
			String name = reader.next();
			int n = reader.nextInt();
			ArrayList<Integer> listOfPass = new ArrayList<Integer>();
			int sum = 0, count = 0;
			for (int i = 0; i<n; i++) {
				int grade = reader.nextInt();
				if (grade >= 50) {
					listOfPass.add(grade);
					sum += grade;
					count += 1;
				}
			}
			Student student = new Student(name, listOfPass, sum, count);
			sb.append(student.getName()+" "+student.getPass(new StringBuilder())+ (int)student.getAverage()+"\n");
			
			
			
		}
		System.out.println(sb);
		

	}
	
	static class Student{
		String name;
		ArrayList<Integer> passGrade;
		int sum;
		int count;
		double average;

		
		public Student(String name, ArrayList<Integer> passGrade, int sum, int count) {
			super();
			this.name = name;
			this.passGrade = passGrade;
			this.sum = sum;
			this.count = count;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public int getSum() {
			return sum;
		}
		public void setSum(int sum) {
			this.sum = sum;
		}
		public double getAverage() {
			if (sum == 0) {
				return 0;
			}
			return    sum/count;
		}
		public void setAverage(double average) {
			this.average = average;
		}
		
		
		public StringBuilder getPass(StringBuilder sb) {
			
			for (int i = 0; i < passGrade.size(); i++) {
				sb.append(passGrade.get(i) + " ") ;
			}
			return sb;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static class MyInputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public MyInputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public MyInputReader(FileInputStream stream) {
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
