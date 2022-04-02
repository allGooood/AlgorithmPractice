package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        while((line = br.readLine()) != null){
            int smallLetters = 0, upperLetters = 0, numbers = 0, space = 0;

            for(int i=0; i<line.length(); i++){
                char target = line.charAt(i);
                if(target == 32){
                    space++;
                }else if(target >= 48 && target <= 57){
                    numbers++;
                }else if(target >= 97 && target <= 122){
                    smallLetters++;
                }else{
                    upperLetters++;
                }
            }

            System.out.printf("%d %d %d %d", smallLetters, upperLetters, numbers, space);
            System.out.println();
        }
    }
}
