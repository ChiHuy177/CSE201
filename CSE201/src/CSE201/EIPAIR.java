package CSE201;

import java.util.*;


public class EIPAIR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			int gifts = sc.nextInt();
			Map<Integer, Integer> mapOfGift = new HashMap<Integer, Integer>();
			for (int i = 0; i < gifts; i++) {
				var moneyOfGift = sc.nextInt();
				mapOfGift.put(moneyOfGift, mapOfGift.getOrDefault(moneyOfGift, 0) + 1);
			}
			int res = 0;
			Set<Map.Entry<Integer, Integer>> setOfOccur = mapOfGift.entrySet();
			
			for (Map.Entry<Integer, Integer> each: setOfOccur) {
				if (each.getValue() > 1) {
					for (int i = each.getValue() - 1; i>0; i--) {
						res += i;
					}
				}
				
			}
			sb.append(res + "\n");
			
		}
		System.out.println(sb);

	}

}
