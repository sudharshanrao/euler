package leetcode;
import java.util.Arrays;
import java.util.List;

public class RotationPoint {

	int findRotationPoint(List<String> wordList){
		int num = 0;
		int prevNum = 0;
		int i = 0;
		for(i = 0; i < wordList.size(); i++){
			Character ch = wordList.get(i).charAt(0);
			num = ch - 'a';
			int diff = num - prevNum;
			if(diff < 0){
				break;
			}
			prevNum = num;
		}
		return i;
	}
	
	int findRotationPointOptimized(List<String> wordList){
		int num = 0;
		int prevNum = 0;
		int i = 0;
		for(i = 0; i < wordList.size(); i++){
			Character ch = wordList.get(i).charAt(0);
			num = ch - 'a';
			int diff = num - prevNum;
			if(diff < 0){
				break;
			}
			prevNum = num;
		}
		return i;
	}
	
	public static void main(String[] args) {
		RotationPoint obj = new RotationPoint();
		String[] wordArray = { "ptolemaic",
                               "retrograde",
                               "supplant",
                               "undulate",
                               "xenoepist",
                               "asymptote",  
                               "babka",
                               "banoffee",
                               "engender",
                               "karpatka",
                               "othellolagkage"
		};
		System.out.println(obj.findRotationPoint(Arrays.asList(wordArray)));
	}
}
