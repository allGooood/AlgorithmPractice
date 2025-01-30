package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuffer sb = new StringBuffer(input);
        String reversed = sb.reverse().toString();

        System.out.println(reversed.equals(input) ? 1 : 0);

        br.close();
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String input = bf.readLine();
//
//        StringBuffer reversed = new StringBuffer();
//        for(int i=input.length()-1; i>=0; i--){
//            reversed.append(input.charAt(i));
//        }
//
//        System.out.println(reversed.toString().equals(input) ? 1 : 0);
//        bf.close();
//    }
}
