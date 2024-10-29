package CSE201;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class EIUONCE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int testCases = sc.nextInt();
		while (testCases > 0) {
			Map<Integer, Boolean> mapOf = new TreeMap<Integer, Boolean>();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				var key1 = sc.nextInt();
				if (mapOf.containsKey(key1)) {
					mapOf.replace(key1, false);
				} else {
					mapOf.put(key1, mapOf.getOrDefault(key1, true));
				}
			}
			Set<Map.Entry<Integer, Boolean>> res = mapOf.entrySet();
			for (Map.Entry<Integer, Boolean> each : res) {
				if (each.getValue()) {
					sb.append(each.getKey() + " ");
				}
			}
			testCases--;

			sb.append("\n");

		}
		System.out.println(sb);

	}
}
