package CSE201;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> mapOfSymbol = new HashMap<Integer, String>();
		mapOfSymbol.put(1, "I");
		mapOfSymbol.put(5, "V");
		mapOfSymbol.put(10, "X");
		mapOfSymbol.put(50, "L");
		mapOfSymbol.put(100, "C");
		mapOfSymbol.put(500, "D");
		mapOfSymbol.put(1000, "M");
	}

}
