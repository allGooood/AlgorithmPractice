package parsing;

import java.util.Scanner;

//8진수, 10진수, 16진수
public class Parsing11816 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNum = scanner.nextLine();

        if(inputNum.substring(1,2).equals("x")){
            System.out.println(Integer.parseInt(inputNum.substring(2),16));
        }else if(inputNum.length() >= 2 && inputNum.startsWith("0")){
            System.out.println(Integer.parseInt(inputNum, 8));
        } else{
            System.out.println(inputNum);
        }
    }
}

