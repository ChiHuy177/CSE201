package CSE201_Week6;

import java.io.*;
import java.util.*;

public class EIUBUSOR {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();
		int N = reader.nextInt();
		String dataType = reader.next();
		switch(dataType) {
		case "double":
			Double[] array = new Double[N];
			for (int i = 0; i < N; i++) {
				array[i] = reader.nextDouble();
			}
			bubbleSort(array);
			for (int i = 0; i < N; i++) {
				sb.append(array[i] + " ");
			}
			break;
		
		case "long":
			Long[] array1 = new Long[N];
			for (int i = 0; i < N; i++) {
				array1[i] = reader.nextLong();
			}
			bubbleSort(array1);
			for (int i = 0; i < N; i++) {
				sb.append(array1[i] + " ");
			}
			break;
		case "int":
			Integer[] array2 = new Integer[N];
			for (int i = 0; i < N; i++) {
				array2[i] = reader.nextInt();
			}
			bubbleSort(array2);
			for (int i = 0; i < N; i++) {
				sb.append(array2[i] + " ");
			}
			break;
		case "float":
			Float[] array3 = new Float[N];
			for (int i = 0; i < N; i++) {
				array3[i] = (float) reader.nextDouble();
			}
			bubbleSort(array3);
			for (int i = 0; i < N; i++) {
				sb.append(array3[i] + " ");
			}
			break;
		}

		System.out.println(sb);

	}

	static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
		
		 for (int i = 0; i < array.length-1; i++) {
	            for (int j = 0; j < array.length-i-1; j++) {
	                if (array[j].compareTo(array[j+1]) == 1) {
	                   
	                    T temp = array[j];
	                    array[j] = array[j+1];
	                    array[j+1] = temp;
	                }
	            }
	            
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
