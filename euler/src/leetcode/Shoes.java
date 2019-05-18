package leetcode;
import java.util.Stack;

public class Shoes {

	public static void main(String[] args) {
		Shoes shoes = new Shoes();
		int num = shoes.solutionStack("RLRRLLRLRRLL");
		System.out.println(num);
		num = shoes.solutionStack("LLLLRRRR");
		System.out.println(num);
	}

	public int solutionStack(String S) {
    	int pairCount = 0;
    	Stack<Character> stack = new Stack<>();
    	for(Character character: S.toCharArray()) {
    		if(!stack.isEmpty() && stack.peek()!=character) {
    			stack.pop();
    		}
    		else {
    			stack.push(character);
    		}
    		if(stack.isEmpty()) {
    			pairCount++;
    		}
    	}
		return pairCount;
	}
}