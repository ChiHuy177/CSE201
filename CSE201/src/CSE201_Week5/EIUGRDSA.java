package CSE201_Week5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIUGRDSA {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();
		int numberOfStudent = reader.nextInt();
		int numberOfProblem = reader.nextInt();
		int numberOfSubmission = reader.nextInt();
		int[] arrayOfStID = new int[numberOfStudent];
		for (int i = 0; i < numberOfStudent; i++) {
			arrayOfStID[i] = reader.nextInt();
		}
		//int[] arrayOfStProblem = new int[numberOfProblem];
		for (int i = 0; i < numberOfProblem; i++) {
			 reader.nextInt();
		}
		
		
		
		
		Map<Integer, Student> mapOfStID = new HashMap<Integer,Student>();
		for (int i = 0; numberOfStudent-- > 0; i++) {
			
			
			Student newSt = new Student(arrayOfStID[i], numberOfProblem);
			mapOfStID.put(arrayOfStID[i], newSt);
		}
		
		while (numberOfSubmission-- > 0) {
			int stID = reader.nextInt();
			int subID = reader.nextInt();
			int newGrade = reader.nextInt();
			Student student = mapOfStID.get(stID);
			
			int oldGrade = student.subCode.getOrDefault(subID, 0);
			if(oldGrade < newGrade) {
				student.subCode.put(subID, newGrade);
			}
			
		}
		
		ArrayList<Student> listOfStudent = new ArrayList<Student>(mapOfStID.values());
		Collections.sort(listOfStudent, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.getStudentID() - o2.getStudentID();
			}
		});
		
		
		for (Student e: listOfStudent) {
			
			sb.append(e.getStudentID()+" ").append((int)Math.floor(e.getAverage())).append("\n");
		}
		
		System.out.println(sb);
		
		
		
		
		

	}
	static class Student{
		private int studentID = 0;
		private Map<Integer, Integer> subCode = new HashMap<Integer, Integer>();
		private int numberOfSubmission = 0;
		
		public Student(int studentID, int numberOfSubmission) {
			super();
			this.studentID = studentID;
			this.numberOfSubmission = numberOfSubmission;
		}
			
		public int getStudentID() {
			return studentID;
		}


		
		public double getAverage() {
			ArrayList<Integer> listOfGrade = new ArrayList<Integer>(subCode.values());
			int sum = 0;
			for(Integer e:listOfGrade) {
				sum += e;
			}
			double average = sum*1.0 / numberOfSubmission;
			return average;
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
