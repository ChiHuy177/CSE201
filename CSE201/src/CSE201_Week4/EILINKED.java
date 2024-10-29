package CSE201_Week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;



public class EILINKED {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		InputReader reader = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();
		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
		int n = reader.nextInt();
		int testCase = reader.nextInt();
		for (int i = 0; i < n; i++) {
			linkedList.add(reader.nextInt());
		}
		while (testCase-- > 0) {
			String command = reader.next();
			if (command.equalsIgnoreCase("add")) {
				linkedList.add(reader.nextInt());
			} else if (command.equalsIgnoreCase("firstIndexOf")) {
				int value = reader.nextInt();
				sb.append(linkedList.firstIndexOf(value) + "\n");
			} else if (command.equalsIgnoreCase("lastIndexOf")) {
				int value = reader.nextInt();
				sb.append(linkedList.lastIndexOf(value) + "\n");
			} else if (command.equalsIgnoreCase("insertAt")) {
				int index = reader.nextInt();
				int number = reader.nextInt();
				linkedList.insertAt(index, number);
			} else if (command.equalsIgnoreCase("getAt")) {
				int index = reader.nextInt();
				sb.append(linkedList.getAt(index) + "\n");
			} else if (command.equalsIgnoreCase("sum")) {
				sb.append(linkedList.sum() + "\n");
			} else if (command.equalsIgnoreCase("average")) {
				sb.append(linkedList.average() + "\n");
			} else if (command.equalsIgnoreCase("size")) {
				sb.append(linkedList.size() + "\n");
			} else if (command.equalsIgnoreCase("removeFirst")) {
				int number = reader.nextInt();
				linkedList.removeFirst(number);
			} else if (command.equalsIgnoreCase("removeAt")) {
				int index = reader.nextInt();
				linkedList.removeAt(index);
			}
		}
		System.out.println(sb);

	}
}

class MyLinkedList<T extends Number> {

	static private class LinkedNode<U extends Number> {
		U number;
		LinkedNode<U> next;
		
		
		public LinkedNode(U number) {
			this.number = number;
		}
	}

	LinkedNode<T> head = null;
	LinkedNode<T> tail = null;
	
	private int compare(T n1, T n2) {
		long l1 = n1.longValue();
		long l2 = n2.longValue();
		if (l1 != l2) {
			return (l1 < l2 ? -1 : 1);
		}
		return Double.compare(n1.doubleValue(), n2.doubleValue());
	}

	public int size() {
		LinkedNode<T> node = head;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}


	public void add(T number) {
		LinkedNode<T> newNode = new LinkedNode<T>(number);
		if (head == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}

	}

	/**
	 * @return -1 if number is not in list
	 */
	public int firstIndexOf(T number) {
		int index = 0;
		LinkedNode<T> current = head;
		if (current == null) {
			return -1;
		} else {
			while (current != null) {
				if (current.number.equals(number)) {
					return index;
				} else {
					index++;
					current = current.next;
				}
			}
		}
		return -1;
	}

	/**
	 * @return -1 if number is not in list
	 */
	public int lastIndexOf(T number) {
		int index = 0;
		int lastIndex = -1;
		LinkedNode<T> current = head;
		if (current == null) {
			return -1;
		} else {
			while (current != null) {
				if (current.number.equals(number)) {
					lastIndex = index;
					current = current.next;
					index++;

				} else {
					index++;
					current = current.next;
				}
			}
		}
		return lastIndex;
	}

	/**
	 * Remove first occurence of number
	 */
	public void removeFirst(T number) {
		LinkedNode<T> current = head;
		LinkedNode<T> prev = head;
		if (current.number.equals(number) ) {
			head = current.next;
			return;
		}
		while (current != null) {
			if (current.number.equals(number)) {
				prev.next = current.next;
				current = prev;
				return ;
			} else {
				prev = current;
				current = current.next;
			}
		}

	}

	public void removeAt(long index) {
		int count = 0;
		if (index < 0 || index >= size()) {
			return;
		} else if (index == 0) {
			head = head.next;
			return;
		} else {
			LinkedNode<T> current = head.next;
			LinkedNode<T> prev = head;
			int checkIndex = 1;
			while (current != null) {
				if (checkIndex == index) {
					prev.next = current.next;
					return;
				} else {
					prev = current;
					current = current.next;
					checkIndex++;
				}

			}
		}

	}

	public void insertAt(long index, T number) {
		if (index < 0) {
			return;
		}

		LinkedNode<T> newNode = new LinkedNode<T>(number);

		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			LinkedNode<T> current = head;

			for (int i = 0; i < index - 1 && current != null; i++) {
				current = current.next;
			}

			if (current == null) {

				return;
			}

			newNode.next = current.next;
			current.next = newNode;
		}
	}

	/**
	 * @return null if index is out of range
	 */
	public T getAt(long index) {
		LinkedNode<T> current = head;
		if (current == null || index < 0) {
			return null;
		}
		if (index == 0) {
			return head.number;
		}

		for (int i = 0; i < index; i++) {
			if (current.next == null)
				return null;
			else
				current = current.next;
		}

		return current.number;
	}

	public double sum() {
		double sum = 0;
		LinkedNode<T> current = head;
		while (current != null) {
			sum += current.number.doubleValue();
			current = current.next;
		}

		return sum;
	}

	public double average() {
		if (size() == 0)
			return 0;
		return this.sum() / this.size();
	}
}

class InputReader {
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
