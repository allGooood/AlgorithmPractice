import java.util.Scanner;

public class Graph9205 {
    static int a, b, c = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if(input % 10 != 0){
            System.out.println(-1);
        }else{
            doCount(input);
            System.out.print(a + " " + b + " " + c);
            a = 0;
            b = 0;
            c = 0;
        }
    }

    private static void doCount(int number) {
        if(number >= 300) {
            a = number / 300;
            int remainder = number % 300;
            if(remainder > 0) doCount(remainder);
        }else if(number >= 60 && number < 300){
            b = number / 60;
            int remainder = number % 60;
            if(remainder > 0) doCount(remainder);
        }else{
            c = number / 10;
            int remainder = number % 10;
            if(remainder > 0) doCount(remainder);
        }
    }
}
