package parsing;

import java.util.Scanner;

public class Parsing3613 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        char[] inputCharArry = inputStr.toCharArray();

        boolean neither = true;
        boolean underbarRightBefore = false;
        String type = "";
        String variant = "";

        if(inputCharArry[0] >= 97 && inputCharArry[0] <= 122){
            for(int i=0; i<inputCharArry.length; i++){
                if(inputCharArry[i] == 95){
                    if(type.equals("JAVA")){
                        System.out.println("Error!");
                        System.exit(0);
                    }
                    if(i == inputCharArry.length-1){ //맨끝이 _일때
                        System.out.println("Error!");
                        System.exit(0);
                    }

                    type = "CPP";
                    neither = false;
                    if(inputCharArry[i+1] != 95 && inputCharArry[i+1] >= 97 && inputCharArry[i+1] <= 122 ){
                        variant += String.valueOf((char)(inputCharArry[i+1] - 32));
                        i++;
                    }else{
                        System.out.println("Error!");
                        System.exit(0);
                    }
                }else if(inputCharArry[i] >= 65 && inputCharArry[i] <= 90){
                    if(type.equals("CPP")){
                        System.out.println("Error!");
                        System.exit(0);
                    }

                    type = "JAVA";
                    neither = false;
                    variant += "_" + (char)(inputCharArry[i] + 32);
                }else{
                    if(inputCharArry[i] >= 97 && inputCharArry[i] <=122){
                        neither = false;
                    }
                    variant += String.valueOf(inputCharArry[i]);
                }
            }
        }

        if(neither){
            System.out.println("Error!");
        } else{
            System.out.println(variant);
        }
    }

}
