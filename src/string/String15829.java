package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int M = 1234567891;
        long result = 0;
        for(int i=0; i<word.length(); i++){
            int A = word.charAt(i) - 96;
            double B = Math.pow(31, i);

            double total = A * B;
            result += (long) total;
        }
        System.out.println(result % M);
    }
}
