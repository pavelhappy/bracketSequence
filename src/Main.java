import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] testArray = new String[4];
        testArray[0] = "{([))}";
        testArray[1] = "[]";
        testArray[2] = "{()[]}";
        testArray[3] = "[{)[]]";

        boolean[] result = braces(testArray);
        for (boolean res:result) {
            System.out.println(res);
        }
    }

    private static boolean[] braces(String[] values) throws Exception {
        Stack<Character> stack = new Stack<Character>();
        boolean[] returnArray = new boolean[values.length];
        for (int i = 0; i < values.length; i++) {
            returnArray[i] = true;
            char[] valArray = values[i].toCharArray();
            if (valArray.length % 2 != 0) {
                returnArray[i] = false;
            } else {
                for (char bracket:valArray) {
                    if (bracket == '{' || bracket == '[' || bracket == '(') {
                        stack.push(bracket);
                    } else if(bracket == '}' || bracket == ']' || bracket == ')') {
                        if(stack.empty()) {
                            returnArray[i] = false;
                        }
                        char pairBracket = stack.peek();
                        if (bracket == '}' && pairBracket == '{' ||
                                bracket == ')' && pairBracket == '(' ||
                                bracket == ']' && pairBracket == '[') {
                            stack.pop();
                        } else {
                            returnArray[i] = false;
                        }
                    }
                }
            }
        }
        return returnArray;
    }
}
