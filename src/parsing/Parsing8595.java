package parsing;

import java.io.*;

public class Parsing8595 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        long total = 0;
        String number = "0";
        for(int i=0; i<N; i++){
            char target = line.charAt(i);
            if(target >= 48 && target <= 57){
                number += String.valueOf(target);
            } else{
                total += Long.valueOf(number);
                number = "0";
            }
        }
        System.out.println(total + Long.valueOf(number));
    }
}
