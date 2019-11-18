package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LongestFibonacciSequence {
	public int lenLongestFibSubseq(int[] A) {
        int max = getGlobalMax(A);
        int i = 0;
        int j = 1;
        
        Set<Integer> setFib = new HashSet<>();
        List<Integer> result = new LinkedList<>();
        int k = j;
        while(k < max){
            k = i + j;
            setFib.add(k);
            i = j;
            j = k;
        }
        for(int num: A){
            if(setFib.contains(num)){
                result.add(num);
            }
        }
        return result.size();
    }
    
    private int getGlobalMax(int[] arr){
        int max = arr[0];
        for(int num: arr){
            max = Math.max(max, num);
        }
        return max;
    }
    
    public static void main(String[] args) {
    	LongestFibonacciSequence obj = new LongestFibonacciSequence();
    	int[] num = {1,3,7,11,12,14,18};
    	// [1, 2, 3, 5, 21, 8, 13]
    	System.out.println(obj.lenLongestFibSubseq(num));
    }
}
