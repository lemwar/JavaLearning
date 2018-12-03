package algorythms;

import java.util.Stack;

public class Brackets {

    public boolean check(String brackets) {
        char [] charArray = brackets.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char bracket : charArray) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                char openedBracket = stack.pop();
                if ((bracket != ')' || openedBracket != '(') && (bracket != ']' || openedBracket != '[') && (bracket != '}' || openedBracket != '{')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Brackets b = new Brackets();
        System.out.println(b.check("{()}[]"));
        System.out.println(b.check("{([)}[]"));
    }
}
