package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RearrangeBinary {

	public static List<Integer> rearrange(List<Integer> elements){
		if(elements == null) {
			return null;
		}
		Collections.sort(elements, new sortByBinaryRep());
		Set<Integer> set = new LinkedHashSet<>(elements);
		return new LinkedList<>(set);
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(5);
		list.add(3);
		list.add(7);
		list.add(10);
		list.add(14);
		System.out.println(rearrange(list));
		List<Integer> list1 = new ArrayList<>();
		list1.add(3);
		list1.add(3);
		list1.add(1);
		list1.add(2);
		System.out.println(rearrange(list1));
	}
}
