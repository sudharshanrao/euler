package leetcode;
import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int currentSum = nums[i] + nums[j] + nums[k];
                if(currentSum > target){
                    k--;
                }
                else {
                	j++;
                }
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
            }
        }
        return closestSum;
    }
    
    
    public static void main(String[] args) {
    	ThreeSumClosest obj = new ThreeSumClosest();
    	int[] nums = {0,2,1,-3};
    	System.out.println(obj.threeSumClosest(nums, 1));
    }
}
