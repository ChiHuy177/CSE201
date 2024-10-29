package CSE201_Week7;

import java.io.*;
import java.util.*;

public class EISCH2 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Student> qOfStudent = new PriorityQueue<Student>(((Student o1, Student o2) -> {
			int compare = Double.compare(o2.grade, o1.grade);
			if (compare == 0) {
				compare = o1.name.compareTo(o2.name);
			}
			return compare;
		}));
		Map<Double, Integer> mapOfGrade = new HashMap<Double, Integer>();

		int numberOfStudent = ni();

		int[] arrOfGrade = new int[3];
		arrOfGrade[0] = numberOfStudent / 12;
		arrOfGrade[1] = numberOfStudent / 3;
		arrOfGrade[2] = numberOfStudent / 2;

		String[] gradeChar = { "A", "B", "C" };

		for (int i = 0; i < numberOfStudent; i++) {
			String name = ns();
			int numberOfCourses = ni();
			int n = numberOfCourses;
			int sum = 0;
			while (n-- > 0) {
				sum += ni();
			}
			double grade = sum * 1.0 / numberOfCourses;

			Student newStudent = new Student(name, grade);
			qOfStudent.add(newStudent);
			mapOfGrade.put(newStudent.grade, mapOfGrade.getOrDefault(newStudent.grade, 0) + 1);
		}

		int numberOfStudentEachGrade = arrOfGrade[0];
		int check = 0;
		int alreadyOut = 0;
//		while (!qOfStudent.isEmpty()) {
//			int number = mapOfGrade.get(qOfStudent.peek().grade);
//			if (number <= arrOfGrade[check]) {
//				for (int i = 0; i < number; i++) {
//					sb.append(qOfStudent.poll().toString() + gradeChar[check] + " \n");
//				}
//				for (int i = check; i < 3; i++) {
//					arrOfGrade[i] -= number;
//				}
//			} else {
//				check++;
//				if (check == 3)
//					break;
//			}
//		}
		while (!qOfStudent.isEmpty()) {
			int num = 0;
			int number = mapOfGrade.get(qOfStudent.peek().grade);
			if (number <= numberOfStudentEachGrade) {
				for (int i = 0; i < number; i++) {
					sb.append(qOfStudent.poll().toString() + gradeChar[check] + " \n");
					num++;
				}
				numberOfStudentEachGrade -= num;
				alreadyOut += num;
				
			} else {

				check++;
				if (check == 3)
					break;

				numberOfStudentEachGrade = arrOfGrade[check] - alreadyOut;
				continue;
			}

			if (numberOfStudentEachGrade < 1) {

				check++;
				if (check == 3)
					break;

				numberOfStudentEachGrade = arrOfGrade[check] - alreadyOut;
			}

		}
		System.out.println(sb);

	}

	static class Student {
		String name;
		double grade;

		public Student(String name, double grade) {
			super();
			this.name = name;
			this.grade = grade;
		}

		@Override
		public String toString() {

			return this.name + " " + Math.round(this.grade * 100) * 1.0 / 100 + " ";
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
