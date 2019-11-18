package leetcode;

public class ReverseWordsInDictionary {
	
	public char[] reverse(char[] inputArray) {
		if(inputArray == null || inputArray.length == 0) {
			return inputArray;
		}
		char[] resultArray = new char[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {  
            if (inputArray[i] == ' ') {  
            	resultArray[i] = ' ';  
            }  
        }  
        // Traverse input string from beginning 
        // and put characters in result from end 
        int j = resultArray.length - 1;  
        for (int i = 0; i < inputArray.length; i++) {  
            // Ignore spaces in input string 
            if (inputArray[i] != ' ') {  
                // ignore spaces in result. 
                if (resultArray[j] == ' ') {  
                    j--;  
                }     
                resultArray[j] = inputArray[i];  
                j--;  
            }  
        }  
        return resultArray;
	}
	
	public static void main(String[] args) {
		ReverseWordsInDictionary obj = new ReverseWordsInDictionary();
		String dictionary = "This is a test";
		System.out.println(obj.reverse(dictionary.toCharArray()));
	}
}
