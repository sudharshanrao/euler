package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
	public List<String> letterCombinations(String phoneNumber) {
        List<String> resultList = new ArrayList<>();
        if(phoneNumber == null || phoneNumber.length() == 0){
            return resultList;
        }
        Map<Character, char[]> map = new HashMap<>(10);

        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        char[] arr = new char[phoneNumber.length()];
        helper(arr, map, phoneNumber, resultList, 0);
        return resultList;
    }
    
    private void helper(char[] arr, Map<Character, char[]> map, String phoneNumber, List<String> resultList, int index){
        if(index == phoneNumber.length()){
            resultList.add(new String(arr));
            return;
        }
        char digit = phoneNumber.charAt(index);
        char[] letterArray = map.get(digit);
        for(int i = 0 ; i < letterArray.length; i++){
            arr[index] = letterArray[i];
            helper(arr, map, phoneNumber, resultList, index + 1);
        }
    }
    
    public static void main(String[] args) {
    	LetterCombinationsOfPhoneNumber obj = new LetterCombinationsOfPhoneNumber();
    	List<String> list = obj.letterCombinations("23");
    	for(String str: list) {
    		System.out.println(str);
    	}
    }
}
