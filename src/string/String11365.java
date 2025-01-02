package string;

import java.util.Scanner;

public class String11365 {
    /*public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String line;
        while(!(line = scanner.nextLine()).equals("END")){
            for(int i=line.length()-1; i>=0; i--){
                System.out.print(line.charAt(i));
            }
            System.out.println();
        }
        scanner.close();
    }*/

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String line;
        while(!(line = scanner.nextLine()).equals("END")){
            System.out.println(new StringBuilder(line).reverse());
        }
        scanner.close();
    }

    /*public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            if(line.equals("END")){
                break;
            }
            System.out.println(new StringBuilder(line).reverse().toString());
        }
    }*/

}
