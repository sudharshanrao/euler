package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctPairsWithDiffK {

	//find all distinct pairs with diff K
	public int findAllDistinctPairs(int[] arr, int k) {
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<>();
		Set<Pair> pairSet = new HashSet<>();
		for(int num: arr) {
			if(set.contains(num)){
				pairSet.add(new Pair(num, num + k));
			}
			set.add(num + k);
		}
		return pairSet.size();
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 4, 2};
		int k = 3;
		DistinctPairsWithDiffK obj = new DistinctPairsWithDiffK();
		//System.out.println(obj.findAllDistinctPairs(arr, k));
		
		int[] arr2 = {1,1,1,1,1};
		int k2 = 0;
		System.out.println(obj.findAllDistinctPairs(arr2, k2));
	}
}
