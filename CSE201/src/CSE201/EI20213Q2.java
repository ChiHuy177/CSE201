package CSE201;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class EI20213Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		TreeMap<Long, Integer> mapOfNumber = new TreeMap<Long, Integer>();
		for (int i = 0; i<n; i++) {
			long number = sc.nextLong();
			if (mapOfNumber.containsKey(number)) {
				mapOfNumber.replace(number, mapOfNumber.get(number) + 1);
			} else {
				mapOfNumber.put(number, 1);
			}
		}
		Set<Map.Entry<Long, Integer>> res = mapOfNumber.entrySet();
		for (Map.Entry<Long, Integer> each: res) {
			sb.append(each.getKey()+" ").append(each.getValue()).append("\n");
		}
		System.out.println(sb);
	}

}
