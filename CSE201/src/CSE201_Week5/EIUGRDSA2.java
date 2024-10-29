package CSE201_Week5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.*;

public class EIUGRDSA2 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int numberOfStudent = ni();
		int numberOfExercise = ni();
		int totalSubmission = ni();

		long[] arrOfStudent = new long[numberOfStudent];
		for (int i = 0; i < arrOfStudent.length; i++) {
			arrOfStudent[i] = nl();
		}

		Map<Long, Integer> mapOfExercise = new HashMap<Long, Integer>();
		while (numberOfExercise-- > 0) {
			long exercise = nl();
			mapOfExercise.put(exercise, 1);
		}

		Map<Long, Student> mapOfStudent = new HashMap<Long, Student>();
		for (int i = 0; i < numberOfStudent; i++) {
			mapOfStudent.put(arrOfStudent[i], new Student(arrOfStudent[i], mapOfExercise.size()));
		}

		while (totalSubmission-- > 0) {
			long id = nl();
			long exercise = nl();
			double grade = ni();

			if (mapOfExercise.get(exercise) != null) {
				Student student = mapOfStudent.get(id);
				double oldGrade = student.mapOfScore.getOrDefault(exercise, 0.0);
				if (oldGrade < grade) {
					student.mapOfScore.put(exercise, grade);
					student.setMinusSum(oldGrade);
					student.setAddSum(grade);
				}
				student.addTotalSubmission();
			}
		}
		PriorityQueue<Student> qOfStudent = new PriorityQueue<Student>(((Student o1, Student o2) -> {
			int compare = Double.compare(o2.getAverage(), o1.getAverage());
			if (compare == 0) {
				compare = o1.totalSubmission - o2.totalSubmission;
			}
			if (compare == 0) {
				compare = Long.compare(o1.id, o2.id);
			}
			return compare;
		}));
		qOfStudent.addAll(mapOfStudent.values());
		while (!qOfStudent.isEmpty()) {
			sb.append(qOfStudent.poll().toString());
		}
		System.out.println(sb);
	}

	static class Student {
		long id;
		double sum = 0;
		int totalSubmission = 0;
		int count = 0;
		double average = 0;

		HashMap<Long, Double> mapOfScore = new HashMap<Long, Double>();

		public Student(long id, int count) {
			super();
			this.id = id;
			this.count = count;
		}

		public void setAddSum(double grade) {
			this.sum += grade;
		}
		
		public void setMinusSum (double grade) {
			this.sum -= grade;
		}

		public double getAverage() {
			return Math.floor(sum*1.0 / count);
		}

		public void addTotalSubmission() {
			this.totalSubmission += 1;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.id + " " + (long) (this.getAverage()) + " " + this.totalSubmission + "\n";
		}

	}

	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

}
