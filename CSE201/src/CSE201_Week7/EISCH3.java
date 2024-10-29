package CSE201_Week7;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class EISCH3 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> mapOfDepar = new HashMap<String, Integer>();
		Map<Double, ArrayList<Student>> mapOfGrade = new HashMap<Double, ArrayList<Student>>();
		List<Student> listOfStudent = new ArrayList<Student>();
		int[] arrOfGrade = { 2, 5, 10 };
		String[] arr = { "A", "B", "C" };

		int numberOfStudent = ni();
		for (int i = 0; i < numberOfStudent; i++) {
			String name = ns();
			String department = ns();
			if (mapOfDepar.get(department) == null) {
				mapOfDepar.put(department, 2);
			}
			int numberOfCourses = ni();
			double grade = 0;

			for (int j = 0; j < numberOfCourses; j++) {
				grade += ni();
			}
			grade /= numberOfCourses;
			if (grade % 1 == 0) {
				grade = Math.round(grade);
			} else {
				grade = Math.round(grade * 100) * 1.0 / 100;
			}
			Student st = new Student(name, department, grade);
			listOfStudent.add(st);
			if (mapOfGrade.get(grade) == null) {
				mapOfGrade.put(grade, new ArrayList<Student>());
				mapOfGrade.get(grade).add(st);
			} else {
				mapOfGrade.get(grade).add(st);
			}
		}

		Collections.sort(listOfStudent, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				int compare = Double.compare(o2.grade, o1.grade);
				if (compare == 0) {
					compare = o1.name.compareTo(o2.name);
				}

				return compare;
			}

		});

		int check = 0;
		int numberOfStudentEachGrade = arrOfGrade[check];
		int alreadyOut = 0;

		
		while (listOfStudent.size() > 0) {
			Student st = listOfStudent.get(0);
			int number = mapOfGrade.get(st.grade).size();
			int n = mapOfDepar.get(st.department);
			if (n > 0 && numberOfStudentEachGrade >= number) {

				sb.append(st.toString() + arr[check] + "\n");
				if (mapOfGrade.get(st.grade).size() != 0)
					mapOfGrade.get(st.grade).remove(st);
				numberOfStudentEachGrade--;
				mapOfDepar.put(st.department, --n);
				alreadyOut++;
				number--;
				if (n == 0) {
					for (int i = 0; i < listOfStudent.size(); i++) {
						Student e = listOfStudent.get(i);
						if (e.department.equalsIgnoreCase(st.department)) {
							int numb = mapOfDepar.get(e.department);
							mapOfDepar.put(e.department, numb - 1);
							ArrayList<Student> listOf = mapOfGrade.get(e.grade);
							listOf.remove(e);
							mapOfGrade.put(e.grade, listOf);
							//mapOfGrade.get(e.grade).remove(e);
							listOfStudent.remove(e);
						}
					}
				} else {
					if (listOfStudent.size() != 0)
						listOfStudent.remove(0);
				}

			} else if (number > numberOfStudentEachGrade) {
				if (++check == 3) {
					break;
				}
				numberOfStudentEachGrade = arrOfGrade[check] - alreadyOut;
			} else if (n < 0) {
				if (listOfStudent.size() != 0)
					listOfStudent.remove(0);
			}
			if (numberOfStudentEachGrade == 0) {
				if (++check == 3) {
					break;
				}
				numberOfStudentEachGrade = arrOfGrade[check] - alreadyOut;
			}

		}
		System.out.println(sb);

	}

	static class Student {
		String name;
		String department;
		double grade;

		public Student(String name, String department, double grade) {
			super();
			this.name = name;
			this.department = department;
			this.grade = grade;
		}

		@Override
		public String toString() {
			
			return this.name + " " + this.grade + " ";
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
