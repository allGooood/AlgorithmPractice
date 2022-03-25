package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int change = Integer.parseInt(br.readLine());

            //25
            int quarter = change / 25;
            System.out.print(quarter + " ");
            change = change - (quarter * 25);

            //10
            int dime = change / 10;
            System.out.print(dime + " ");
            change = change - (dime * 10);

            //5
            int nickel = change / 5;
            System.out.print(nickel + " ");
            change = change - (nickel * 5);

            //1
            System.out.println(change);
        }

    }
}
