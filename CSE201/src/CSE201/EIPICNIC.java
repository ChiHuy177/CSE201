package CSE201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class EIPICNIC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeMap<Integer, Integer> mapOf = new TreeMap<Integer, Integer>();
		for (int i = 1; i < 5; i++) {
			mapOf.put(i, 0);
		}
		for (int i = 0; i < n; i++) {
			int number = sc.nextInt();

			mapOf.replace(number, mapOf.get(number) + 1);

		}
		int cars = mapOf.get(3);
		if (mapOf.get(3) < mapOf.get(1)) {

			mapOf.replace(1, mapOf.get(1) - mapOf.get(3));

		} else {
			mapOf.replace(1, 0);
		}

		if (mapOf.get(2) > 0) {
			if (mapOf.get(2) % 2 == 0) {
				cars += mapOf.get(2) / 2;
				mapOf.replace(2, 0);
			} else {
				cars += mapOf.get(2) / 2;
				mapOf.replace(2, 1);

			}
		}
		
		if (mapOf.get(2)>0) {
			cars += 1;
			mapOf.replace(1, mapOf.get(1) - 2);
		}
		if (mapOf.get(1) > 0) {
			if (mapOf.get(1) % 4 == 0) {
				cars += mapOf.get(1) / 4;
			}
			else {
				cars +=  mapOf.get(1) / 4 + 1;
			}
		}

		System.out.println(cars + mapOf.get(4));
	}

}
