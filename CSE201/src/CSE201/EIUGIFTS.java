package CSE201;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EIUGIFTS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int numberOfItem = sc.nextInt();
		int target = sc.nextInt();
		boolean targetFlag = false, flag = false, equalFlag = false;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		ArrayList<Integer> listOfItem = new ArrayList<Integer>();

		for (int i = 0; i < numberOfItem; i++) {
			listOfItem.add(sc.nextInt());
		}
		// target = listOfItem.get(listOfItem.size()-1) +
		// listOfItem.get(listOfItem.size()-2);

		Collections.sort(listOfItem);
		int rightSide = listOfItem.size() - 1;
		int leftSide = 0;
		int temp = 0;
		while (!targetFlag) {
			do {
				if (rightSide == leftSide && !flag) {
					targetFlag = true;
					
					break;
				}
				if (rightSide == leftSide && !targetFlag) {
					target = max;
					temp++;
					leftSide = temp;
					break;
				} else {
					if (listOfItem.get(leftSide) + listOfItem.get(rightSide) > target) {
						rightSide--;
					} else {
						flag = true;
						if (listOfItem.get(leftSide) + listOfItem.get(rightSide) == target) {
							targetFlag = true;
							if (Math.abs(listOfItem.get(rightSide) - listOfItem.get(leftSide)) < min) {
								min = Math.abs(listOfItem.get(rightSide) - listOfItem.get(leftSide));
							}
							rightSide--;
						} else {
							if (listOfItem.get(leftSide) + listOfItem.get(rightSide) > max)
								max = listOfItem.get(leftSide) + listOfItem.get(rightSide);
							leftSide++;
						}
					}
				}

			} while (rightSide > leftSide);
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1 + " " + -1);
		} else
			System.out.println(target + " " + min);

	}

}
