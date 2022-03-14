import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy18310 {
    static int totalHouse;
    static int[] houseArray;

    static int minDifference = Integer.MAX_VALUE;
    static int minHouse = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalHouse = Integer.parseInt(br.readLine());
        houseArray = new int[totalHouse];

        String[] arrayStr = br.readLine().split(" ");
        for(int i=0; i<arrayStr.length; i++){
            houseArray[i] = Integer.parseInt(arrayStr[i]);
        }
        Arrays.sort(houseArray);

        int halfIndex = houseArray.length / 2;
        if(houseArray.length % 2 == 0){
            //왼쪽check
            for(int i=0; i<2; i++){
                int indexOnCheck = halfIndex - i;
                cutHalfNSearch(indexOnCheck);
            }
        } else{
            //양옆check
            for(int i=0; i<3; i++){
                int indexOnCheck = (halfIndex+1) - i;
                cutHalfNSearch(indexOnCheck);
            }
        }
        System.out.println(minHouse);
    }
    private static void cutHalfNSearch(int index) {
        Integer difference = 0;
        for(int i=0; i<houseArray.length; i++){
            if(i == index) continue;
            difference += Math.abs(houseArray[index] - houseArray[i]);
        }
        if(difference.compareTo(minDifference) <= 0){
            minDifference = difference;
            minHouse = Math.min(minHouse, houseArray[index]);
        }
    }
}
