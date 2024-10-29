package CSE201;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class EIUPH010 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer, Integer> mapOfNumber = new TreeMap<Integer, Integer>();
		int n = sc.nextInt();
		int occurence = 1;
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			if (mapOfNumber.containsKey(number)) {
				mapOfNumber.replace(number, mapOfNumber.get(number)+1);
				if (mapOfNumber.get(number)>occurence) {
					occurence = mapOfNumber.get(number);
				}
			} else {
				mapOfNumber.put(number, 1);
			}
		
		}
		Set<Map.Entry<Integer, Integer>> mapOf = mapOfNumber.entrySet();
		for (Map.Entry<Integer, Integer> each: mapOf) {
			if (each.getValue() == occurence) {
				System.out.println(each.getKey()+" "+each.getValue());
				break;
			}
		}
		
	
	}
}
