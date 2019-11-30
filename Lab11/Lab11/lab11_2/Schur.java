package lab11_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Schur {
	boolean checkForSum(List<Integer> list, Integer z) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for(Integer i: list) {
			hm.put(i, i);
		}
		
		for(Entry<Integer, Integer> t: hm.entrySet()) {
			int x = t.getValue();
			int y = z-x;
			if(hm.containsKey(y) && y!=x) return true;
			
		}
		return false;
	}

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(5);
		l.add(4);
		l.add(-2);
		l.add(8);
		l.add(7);
		l.add(-10);
		
		Schur sc = new Schur();
		System.out.println(sc.checkForSum(l, 100));

	}

}
