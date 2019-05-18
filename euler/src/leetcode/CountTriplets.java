package leetcode;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class CountTriplets {

	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long count = 0L;
        Map<Long, Long> map2 = new HashMap<>();
        Map<Long, Long> map3 = new HashMap<>();

        for(long num : arr) {
            count += map3.getOrDefault(num, 0L);
            if (map2.containsKey(num)){
                map3.put(num * r, map3.getOrDefault(num * r, 0L) + map2.get(num));
            }
            map2.put(num * r, map2.getOrDefault(num * r, 0L) + 1L);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
    	
    	long[] arr = {1L,2L,2L,4L};
    	List<Long> list = new ArrayList<>(arr.length);
    	for(long num: arr) {
    		list.add(num);
    	}
    	long answer = countTriplets(list, 2L);
    	System.out.println(answer);
    }
}
