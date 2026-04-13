package Module4;
import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class MatchingGroup {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Using: java MatchingGroup");
            return;
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("The file cannot be found.");
            return;
        }

        Stack<Character> stack = new Stack<>();
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                for (char c : line.toCharArray()) {
                    if (c == '(' || c == '{' || c == '[') {
                        stack.push(c);
                    } else if (c == ')' || c == '}' || c == ']') {
                        if (stack.isEmpty()) {
                            System.out.println("Invalid: Unmatched " + c);
                            return;
                        }

                        char top = stack.pop();
                        if ((c == ')' && top != '(') || 
                            (c == '}' && top != '{') || 
                            (c == ']' && top != '[')) {
                            System.out.println("Invalid: Mismatched " + c);
                            return;
                        }
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("The file is grouped appropriately.");
        } else {
            System.out.println("Invalid: Unclosed groups (e.g., " + stack.peek() + ").");
        }
    }
}
    