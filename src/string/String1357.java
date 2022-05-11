package string;

import java.util.Scanner;

public class String1357 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] numbers = scanner.nextLine().split(" ");
//
//        int[] numRevArray = new int[numbers.length];
//        for(int i=0; i<numbers.length; i++){
//            String[] number = numbers[i].split("");
//
//            String numRevStr = "";
//            for(int j=number.length-1; j>=0; j--){
//                numRevStr += number[j];
//            }
//            numRevArray[i] = Integer.parseInt(numRevStr);
//        }
//
//        int total = 0;
//        for(int i : numRevArray){
//            total += i;
//        }
//
//        String[] totalStrArray = String.valueOf(total).split("");
//        String totalStr = "";
//        for(int i=totalStrArray.length-1; i>=0; i--){
//            totalStr += totalStrArray[i];
//        }
//        System.out.println(Integer.parseInt(totalStr));
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        scanner.close();

        int x = Rev(X);
        int y = Rev(Y);
        int result = Rev(x + y);

        System.out.println(result);
    }

    //숫자 뒤집기 : 숫자를 10으로 나눈 나머지를 차례로 열거하면 된다!
    private static int Rev(int N) {
        String str = "";
        while(N > 0){
            str += N % 10;
            N /= 10;
        }
        return Integer.parseInt(str);
    }
}
