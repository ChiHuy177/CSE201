package CSE201;

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
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class EIDUPBOD {

	public static void main(String[] args) {
		MyInputReader12 reader = new MyInputReader12(System.in);
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		PriorityQueue<Birthday> q = new PriorityQueue<Birthday>((Birthday b1, Birthday b2) -> {
			int compare = b1.getYear() - b2.getYear();
			if (compare == 0) {
				compare = b1.getMonth() - b2.getMonth();
			}
			if (compare == 0) {
				compare = b1.getDay() - b2.getDay();

			}

			return compare;
		});
		while (n-- > 0) {
			int day = reader.nextInt();
			int month = reader.nextInt();
			int year = reader.nextInt();
			Birthday newBirthday = new Birthday(day, month, year);
			q.add(newBirthday);
		}

		String birthdayString = q.poll().toString();
		String birthdayString2 = "";
		int count = 1;
		while (q.size() > 0) {
			birthdayString2 = q.poll().toString();
			if (birthdayString.equalsIgnoreCase(birthdayString2)) {
				count++;
				birthdayString = birthdayString2;
			} else {
				sb.append(birthdayString + " " + count + "\n");
				count = 1;
				birthdayString = birthdayString2;
			}
		}
		if (q.size() == 0 && count > 0) {
			sb.append(birthdayString+" "+count);
		}
		System.out.println(sb);

	}

}

class Birthday {
	int day;
	int month;
	int year;

	public Birthday(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		String day1 = "";
		String month = "";
		if (this.day < 10) {
			day1 = "0" + this.getDay();
		} else {
			day1 = "" + this.getDay();
		}
		if (this.month < 10) {
			month = "0" + this.getMonth();
		} else {
			month = "" + this.getMonth();
		}
		return day1 + "/" + month + "/" + this.getYear();
	}

}

class MyInputReader12 {
	StringTokenizer tokenizer;
	BufferedReader reader;
	String token;
	String temp;

	public MyInputReader12(InputStream stream) {
		tokenizer = null;
		reader = new BufferedReader(new InputStreamReader(stream));
	}

	public MyInputReader12(FileInputStream stream) {
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
