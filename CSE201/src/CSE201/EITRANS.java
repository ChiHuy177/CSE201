package CSE201;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EITRANS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyInputReader13 reader = new MyInputReader13(System.in);
		StringBuilder sb = new StringBuilder();
		HashMap<String, Language> mapOfLanguage = new HashMap<String, Language>();
		int needToTrans = reader.nextInt();
		int n = reader.nextInt();
		while (n-- > 0) {
			String input1 = reader.next();
			String input2 = reader.next();
			mapOfLanguage.put(input1, new Language(input1, input2));
		}
		while (needToTrans-- > 0) {
			String trans = reader.next();
			sb.append(mapOfLanguage.get(trans).getShorter()+" ");
		}
		System.out.println(sb);
		}

}
class Language{
	String input1;
	String input2;
	
	public Language(String input1, String input2) {
		super();
		this.input1 = input1;
		this.input2 = input2;
	}
	
	public String getShorter() {
		if (input1.length()<=input2.length()) {
			return input1;
		}
		return input2;
	}
	
}


class MyInputReader13 {
	StringTokenizer tokenizer;
	BufferedReader reader;
	String token;
	String temp;

	public MyInputReader13(InputStream stream) {
		tokenizer = null;
		reader = new BufferedReader(new InputStreamReader(stream));
	}

	public MyInputReader13(FileInputStream stream) {
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

