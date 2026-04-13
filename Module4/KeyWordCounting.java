package Module4;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KeyWordCounting {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Using: java KeyWordCounting");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (file.exists()) {
            System.out.println("The number of keywords in " + args[0] 
                + " is " + countKeywords(file));
        } else {
            System.out.println("File " + args[0] + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        StringBuilder sb = new StringBuilder();
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                sb.append(input.nextLine()).append("\n");
            }
        }
        String code = sb.toString();
        code = code.replaceAll("//.*|/\\*(?:.|[\\n\\r])*?\\*/|\"(?:\\\\.|[^\\\\\\\"])*\"", " ");

        String[] words = code.split("[^a-zA-Z0-9_]+");
        for (String word : words) {
            if (keywordSet.contains(word)) {
                count++;
            }
        }
        return count;
    }
}
