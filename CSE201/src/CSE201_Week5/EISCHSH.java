package CSE201_Week5;


import java.io.*;
import java.util.*;

class EISCHSH {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		PriorityQueue<Student> qOfStudent = new PriorityQueue<Student>(((Student o1, Student o2) -> {
			int compare = Double.compare(o2.getGrade(), o1.getGrade());
			if (compare == 0) {
				compare = Long.compare(o1.getId(), o2.getId());
			}
			return compare;
		}));
		
		int numberOfStudent = ni();
		int numberOfScholarship = ni();
		while (numberOfStudent-- > 0) {
			long id = nl();
			String name = ns();
			int learnedCourse = ni();
			int grade = 0;
			int count = 0;
			while (learnedCourse-- > 0) {
				int newGrade = ni();
				if (newGrade > 49) {
					grade += newGrade;
					count++;
				}
			}
			double average = 0;
			if (grade == 0) {
				average = 0;
			} else
				average = grade * 1.0 / count;
			Student newStudent = new Student(id, name, average);
			qOfStudent.add(newStudent);
		}

		
			int rank = 1, space = 1;
			Student student = qOfStudent.poll();
			numberOfScholarship--;
			sb.append(rank + " " + student.toString());
			double temp = student.getGrade();
			
			while (numberOfScholarship-- > 0) {
				Student foundSt = qOfStudent.poll();
				
				if (foundSt.getGrade() == temp) {
					space++;

				} else {
					rank += space;
					space = 1;

				}
				
				sb.append(rank +" " + foundSt.toString());
				temp = foundSt.getGrade();
			}
			while ( !qOfStudent.isEmpty() && temp == qOfStudent.peek().getGrade()) {
				sb.append(rank +" " + qOfStudent.poll().toString());
			}

		

		System.out.println(sb);
	}

	static class Student {
		private long id = 0;
		private String name;
		private double grade = 0;
		

		public Student(long id, String name, double grade) {
			super();
			this.id = id;
			this.name = name;
			this.grade = grade;
		}


		public long getId() {
			return id;
		}

		public double getGrade() {
			return grade;
		}

		@Override
		public String toString() {
			return  this.id + " " + this.name + " " + Math.round(this.grade) + "\n";
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
