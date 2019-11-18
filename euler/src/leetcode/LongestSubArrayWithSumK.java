package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {

	public int compute(int[] nums,int k) {
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		int maxLen = 0; 
		  
        // traverse the given array 
        for (int i = 0; i < nums.length; i++) { 
             // accumulate sum 
             sum += nums[i]; 
             // when subarray starts from index '0' 
             if (sum == k) {
                 maxLen = i + 1; 
             }
             // make an entry for 'sum' if it is 
             // not present in 'map' 
             if (!map.containsKey(sum)) { 
                 map.put(sum, i); 
             }
             // check if 'sum-k' is present in 'map' 
             // or not 
             if (map.containsKey(sum - k)) { 
                 // update maxLength 
                 if (maxLen < (i - map.get(sum - k))) 
                     maxLen = i - map.get(sum - k); 
             } 
        } 
        return maxLen; 
	}
	
	public static void main(String[] args) {
		LongestSubArrayWithSumK obj = new LongestSubArrayWithSumK();
		int[] nums = { 10, 5, 2, 7, 1, 9 };
		int k = 15;
		System.out.println(obj.compute(nums, k));
	}
}
