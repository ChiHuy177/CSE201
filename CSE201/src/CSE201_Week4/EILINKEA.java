package CSE201_Week4;

import java.util.Scanner;

class EILINKEA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		sc.next();
		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			String command = sc.next();
			if (command.equalsIgnoreCase("insertAt")) {
				int index = sc.nextInt();
				int value = sc.nextInt();
				linkedList.insertAt(index, value);
			} else if (command.equalsIgnoreCase("getAt")) {
				int value = sc.nextInt();
				sb.append(linkedList.getAt(value) + "\n");

			}
		}
		System.out.println(sb);
	}
}

class LinkedList<T extends Number> {

	static private class LinkedNode<U extends Number> {
		U number;
		LinkedNode<U> next;

		public LinkedNode(U number) {
			this.number = number;
		}
	}

	LinkedNode<T> head = null;

	public void insertAt(int index, T number) {
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
			

//			 newNode.next = current.next;
			current.next = newNode;
		}

	}

	
	public T getAt(int index) {
		LinkedNode<T> current = head;
		if (current == null) {
			return null;
		}
		if (index == 0) {
			return current.number;
		}

		for (int i = 0; i < index; i++) {
			if (current.next==null)
				return null;
			else
				current = current.next;
		}
		
		return current.number;
	}
}
