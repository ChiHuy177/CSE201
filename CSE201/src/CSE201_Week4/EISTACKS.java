package CSE201_Week4;

import java.io.*;
import java.util.*;

class EISTACKS {
	public static void main(String[] args) {
		MyInputReader reader = new MyInputReader(System.in);
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int testCase = reader.nextInt();
		ArrayStack<Integer> stack = new ArrayStack<Integer>(n);
		for (int i = 0; i < m; i++) {
			stack.push(reader.nextInt());
		}
		while (testCase-- > 0) {
			String command = reader.next();
			if (command.equalsIgnoreCase("peek")) {
				sb.append(stack.peek() + "\n");
			} else if (command.equalsIgnoreCase("sum")) {
				sb.append(stack.sum() + "\n");
			} else if (command.equalsIgnoreCase("average")) {
				sb.append(stack.average() + "\n");
			} else if (command.equalsIgnoreCase("pop")) {
				sb.append(stack.pop() + "\n");
			} else if (command.equals("push")) {
				int number = reader.nextInt();
				stack.push(number);
			}
		}
		System.out.println(sb);

	}

}

class ArrayStack<T extends Number> {

	// Your code here
	Object[] data;
	int lastIndex = 0;
	long sum = 0 ;
	public ArrayStack(int capacity) {
		data = new Object[capacity];
	}


	public int count() {
		return lastIndex;
	}

	public double sum() {
		return (double) sum;
	}

	public double average() {

		return this.sum()*1.0 / this.count();
	}

	/**
	 * @description: add item when stack is not full
	 */
	public void push(T item) {
//		if (lastIndex<data.length) {
			data[lastIndex++] = item;
			sum += (int)item;
//		}

	}

	/**
	 * @return: return and remove top item, or null when stack is empty
	 */

	@SuppressWarnings("unchecked")
	public T pop() {
		if (lastIndex!=0) {
			sum -= (int)data[lastIndex-1];
			return (T) data[lastIndex-- - 1];
		}
		return null;
	}

	/**
	 * @return: return top item, or null when stack is empty
	 */
	@SuppressWarnings("unchecked")
	public T peek() {
		if (lastIndex==0) {
			return null;
		} else {
			return (T) data[lastIndex - 1];
		}
	}
}

class MyInputReader {
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
