package string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class String1152 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(input);
        System.out.println(tokenizer.countTokens());
    }
}
