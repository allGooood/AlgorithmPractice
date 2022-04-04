package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int guitarString = Integer.parseInt(line[0]);
        int brands = Integer.parseInt(line[1]);

        int minEach = 1000;
        int minBundle = 1000;
        for(int i=0; i<brands; i++){
            String[] priceLine = br.readLine().split(" ");
            minBundle = Math.min(minBundle, Integer.parseInt(priceLine[0]));
            minEach = Math.min(minEach, Integer.parseInt(priceLine[1]));
        }

        int onlyUsingEach = guitarString * minEach;
        int onlyUsingBundle = (guitarString % 6) != 0 ? ((guitarString/6)+1)*minBundle : (guitarString/6)*minBundle;
        int both = ((guitarString/6) * minBundle) + ((guitarString%6) * minEach);

        int totalPayment = 0;
        totalPayment = Math.min(both, (Math.min(onlyUsingBundle, onlyUsingEach)));

        System.out.println(totalPayment);
    }
}
