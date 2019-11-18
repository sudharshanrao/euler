package leetcode;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ReverseStringInPlace {

	    public static void reverse(char[] arrayOfChars) {

	        // reverse input array of characters in place
	        if(arrayOfChars.length <= 1){
	            return;
	        }
	        int left = 0;
	        int right = arrayOfChars.length -1;
	        while(left < right){
	            char temp = arrayOfChars[left];
	            arrayOfChars[left] = arrayOfChars[right];
	            arrayOfChars[right] = temp; 
	            left++;
	            right--;
	        }
	    }
	    
	    // tests
	    @Test
	    public void emptyStringTest() {
	        final char[] actual = "".toCharArray();
	        reverse(actual);
	        final char[] expected = "".toCharArray();
	        assertArrayEquals(expected, actual);
	    }

	    @Test
	    public void singleCharacterStringTest() {
	        final char[] actual = "A".toCharArray();
	        reverse(actual);
	        final char[] expected = "A".toCharArray();
	        assertArrayEquals(expected, actual);
	    }

	    @Test
	    public void longerStringTest() {
	        final char[] actual = "ABCDE".toCharArray();
	        reverse(actual);
	        final char[] expected = "EDCBA".toCharArray();
	        assertArrayEquals(expected, actual);
	    }

	    public static void main(String[] args) {
	        Result result = JUnitCore.runClasses(Solution.class);
	        for (Failure failure : result.getFailures()) {
	            System.out.println(failure.toString());
	        }
	        if (result.wasSuccessful()) {
	            System.out.println("All tests passed.");
	        }
	    }
	}
