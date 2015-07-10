package junutil;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TMapSort {

	public static void main(String[] args) {
		Map<Integer, Integer> amount_level_map=new TreeMap<Integer, Integer>(
				
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o2-o1;
					}
				}
				
				);
		 
			amount_level_map.put(500000, 1);
			amount_level_map.put(100000, 2);
			amount_level_map.put(10000, 3);
			amount_level_map.put(0, 4);
			
		
		Set<Map.Entry<Integer, Integer>> set = amount_level_map.entrySet();
		int level=0;
		for (Iterator<Map.Entry<Integer, Integer>> it = set.iterator(); it.hasNext();) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
			int key=entry.getKey();
			System.out.println(key);
		}
	
	}
}
