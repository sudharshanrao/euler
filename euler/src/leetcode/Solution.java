package leetcode;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	
    private static Set<Character> set = new HashSet<>();
	static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
	}
	
    public int solve(String A) {
        int count = 0;
        for(int i =0; i< A.length(); i++){
        	if(set.contains(A.charAt(i))) {
        		System.out.println("c="+A.charAt(i));
        		count += A.length() - i;
        		System.out.println("count = "+count);
        		if(count >= 10003) {
        			count = count % 10003;
        		}
        	}
        }
        return count;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.solve("pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn"));
    }
    
}