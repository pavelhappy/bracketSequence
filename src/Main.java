import java.util.*;

public class Main {
    /**
     * Тестовые данные для демонстрации работы метода
     */
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

    /**
     * Проверяем каждую строку массива на правильность закрытия скобок
     * @param values массив строк со скобками
     * @return массив значений true/false с результатами проверки строк
     */
    private static boolean[] braces(String[] values) {
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
