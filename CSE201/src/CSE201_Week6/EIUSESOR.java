package CSE201_Week6;

import java.util.Scanner;

public class EIUSESOR {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		String dataType = sc.next();
		if (dataType.equals("double")) {
		  Double[] array = new Double[N];
		  for (int i = 0; i < array.length; i++) {
			  array[i] = sc.nextDouble();
		  }
		  selectionSort(array);
		  for (int i = 0; i< array.length; i++) {
			  sb.append(array[i] +" ");
		  }
		}
		else if (dataType.equals("int")) {
			Integer[] array = new Integer[N];
		    for (int i = 0; i < array.length; i++) {
		  	  array[i] = sc.nextInt();
		    }
		    selectionSort(array);
		    for (int i = 0; i< array.length; i++) {
		  	  sb.append(array[i] +" ");
		    }
		}
		else if (dataType.equals("long")) {
			Long[] array = new Long[N];
		    for (int i = 0; i < array.length; i++) {
		  	  array[i] = sc.nextLong();
		    }
		    selectionSort(array);
		    for (int i = 0; i< array.length; i++) {
		  	  sb.append(array[i] +" ");
		    }
		}
		else if (dataType.equals("float")) {
			Float[] array = new Float[N];
		    for (int i = 0; i < array.length; i++) {
		  	  array[i] = sc.nextFloat();
		    }
		    selectionSort(array);
		    for (int i = 0; i< array.length; i++) {
		  	  sb.append(array[i] +" ");
		    }
		}
		System.out.println(sb);
	}
    
  }

  static <T extends Number & Comparable<T>> void selectionSort(T[] array) {
	  for (int i = 0; i < array.length - 1; i++) {
		  T min = array[i];
		  int index = i;
		  for (int j = i + 1; j < array.length ; j++) {
			  if(array[j].compareTo(min) == -1) {
				  min = array[j];
				  index = j;
			  }
		  }
		  T temp = array[i];
		  array[i] = min;
		  array[index] = temp;
	  }
  }
}

