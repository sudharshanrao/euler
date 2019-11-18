package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.stream.IntStream;

public class FindCelebrity {
	
	private static Map<Integer, int[]> personGraph;
	
	public static void main(String[] args) {
		FindCelebrity obj = new FindCelebrity();
		initParty();
		System.out.println(obj.computeOptimized(personGraph.size()));
	}
	
	// O(n ^ 2)
	private int compute(int n) {
		Map<Integer, List<Integer>> mapOfKnownPersons = new HashMap<>(n);
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				List<Integer> list = mapOfKnownPersons.getOrDefault(i, new ArrayList<>());
				if(i != j && knows(i, j)) {
					list.add(j);
				}
				mapOfKnownPersons.put(i, list);
			}
		}
		for(Entry<Integer,List<Integer>> entry: mapOfKnownPersons.entrySet()) {
			List<Integer> list = entry.getValue();
			if(list.isEmpty()) {
				return entry.getKey();
			}
		}
		return -1;
	}

	private int computeOptimized(int n) {
		int celebrity = 1;
		for(int i = 1; i <= n; i++) {
			if(knows(celebrity, i)) {
				celebrity = i; 
			}
		}
		for(int i = 1; i <= n ;i++) {
			if(i != celebrity && (knows(celebrity, i) || !knows(i,celebrity))) {
				return -1;
			}
		}
		return celebrity;
	}
	
	private static boolean knows(int a, int b) {
		int[] personsKnown = personGraph.get(a);
		return IntStream.of(personsKnown).anyMatch(o -> o == b);
	}
	
	private static void initParty() {
		personGraph = new HashMap<>();
		int[] one = {2, 5, 8, 4};
		personGraph.put(1, one);
		int[] two = {6, 7, 4};
		personGraph.put(2, two);
		int[] three = {1, 4};
		personGraph.put(3, three);
		int[] four = {};
		personGraph.put(4, four);
		int[] five = {1, 2, 3, 4, 6, 7, 8};
		personGraph.put(5, five);
		int[] six = {3, 4, 8};
		personGraph.put(6, six);
		int[] seven = {2, 4};
		personGraph.put(7, seven);
		int[] eight = {3, 4, 6};
		personGraph.put(8, eight);
		
		//1, 2, 3, 4, 5, 6, 7, 8 
	}
}
