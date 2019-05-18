package leetcode;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        final Stack<Character> stack = new Stack<>();
        for (final Character character : expression.toCharArray()) {
            switch (character) {
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (stack.empty() || stack.peek() != character) {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            final String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
