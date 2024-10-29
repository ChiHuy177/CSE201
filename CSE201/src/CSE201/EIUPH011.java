package CSE201;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EIUPH011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		Map<Integer, Boolean> mapOf = new HashMap<Integer, Boolean>() ;
		for (int i = 0; i<n; i++) {
			int m = sc.nextInt();
			if (mapOf.isEmpty()) {
				mapOf.put(m, true);
			}
			else {
				if (!mapOf.containsKey(m)) {
					mapOf.put(m, true);
					
				}
				else {
					mapOf.put(m, false);
				}
			}
			if (mapOf.get(m)) {
				sb.append(m+" ");
			}
		}

		System.out.println(sb);
		
	}

}
