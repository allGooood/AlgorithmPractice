package string;

import java.util.Scanner;

public class String7567 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int total = 0;
        int preChar = 0;
        for(int i=0; i<line.length(); i++){
            char target = line.charAt(i);
            if(i != 0 && target == preChar){
                total += 5;
            } else{
                total += 10;
            }
            preChar = target;
        }

        System.out.println(total);
    }

}
