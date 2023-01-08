package greedy;

import java.util.Scanner;

public class Greedy15904 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String output = "I hate UCPC";
        String word = "UCPC";
        int index = 0;
        for(char ch : input.toCharArray()){
            if(ch == word.charAt(index)){
                index++;
                if(index == 4){
                    output = "I love UCPC";
                    break;
                }
            }
        }
        System.out.println(output);
    }
}