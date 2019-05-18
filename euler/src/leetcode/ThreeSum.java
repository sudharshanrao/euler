package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        if(nums == null || nums.length < 3){
            return new ArrayList<>(resultSet);
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    resultSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                if(sum > 0){
                    k--;
                }
                if(sum < 0){
                    j++;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
    
    public static void main(String[] args) {
    	ThreeSum threeSum = new ThreeSum();
    	int[] nums = {-1, 0, 1, 2, -1, -4};
    	System.out.println(threeSum.threeSum(nums));
    }
}