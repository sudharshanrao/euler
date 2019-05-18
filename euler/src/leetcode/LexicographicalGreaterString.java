package leetcode;

public class LexicographicalGreaterString {

	public static String rearrangeWord(String word) {
		char[] array = word.toCharArray();
		int i = array.length - 1;
	    while (i > 0 && array[i - 1] >= array[i]) {
	        i--;
	    }

	    if (i <= 0) {
	        return "no answer";
	    }

	    int j = array.length - 1;

	    while (array[j] <= array[i - 1]) {
	        j--;
	    }

	    char temp = array[i - 1];
	    array[i - 1] = array[j];
	    array[j] = temp;

	    j = array.length - 1;

	    while (i < j) {
	        temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	        i++;
	        j--;
	    }

	    return new String(array);
	}
	
	public static void main(String[] args) {
		System.out.println(rearrangeWord("abcgda"));
		String str = "abc";
		str.indexOf("bc");
	}
	
}
