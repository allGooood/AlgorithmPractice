package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int startNum = Integer.parseInt(line[0]);
        String finalNum = line[1];
        int total = 1;

        while(Integer.parseInt(finalNum) != startNum){
            if(Integer.parseInt(finalNum) < startNum){
                total = -1;
                break;
            }
            if (finalNum.split("")[finalNum.length() - 1].equals("1")) {
                finalNum = finalNum.substring(0, finalNum.length() - 1);
            } else {
                int finalNumInt = Integer.parseInt(finalNum);
                if(finalNumInt % 2 != 0){
                    total = -1;
                    break;
                }
                finalNum = String.valueOf(finalNumInt / 2);
            }
            total++;
        }
        System.out.println(total);
    }
}
