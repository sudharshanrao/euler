package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoSum {

	private List<List<Integer>> findTwoSum(int[] nums){
		if(nums == null || nums.length < 2) {
			return new ArrayList<List<Integer>>();
		}
		Arrays.sort(nums);
		Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
		for(int i = 0; i< nums.length; i++) {
			int j = nums.length - 1;
			while(i < j) {
				int sum = nums[i] + nums[j];
				if(sum == 0) {
					resultSet.add(Arrays.asList(nums[i], nums[j]));
					i++;
					j--;
				}
				else if(sum > 0) {
					j--;
				}
				else {
					i++;
				}
			}
		}
		return new ArrayList<>(resultSet);
	}
	
	private List<List<Integer>> findTwoSumWithHashmap(int[] nums){
		if(nums == null || nums.length < 2) {
			return new ArrayList<List<Integer>>();
		}
		Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for(int num: nums) {
			if(map.containsKey(num)) {
				resultSet.add(Arrays.asList(num, map.get(num)));
			}
			else {
				map.put(0 - num, num);
			}
		}
		return new ArrayList<>(resultSet);
	}
 	
	public static void main(String[] args) {
		TwoSum obj = new TwoSum();
		int[] nums = {-1, 0, 1, 2, -2, -4};
		System.out.println(obj.findTwoSum(nums));
		System.out.println(obj.findTwoSumWithHashmap(nums));
	}
}
