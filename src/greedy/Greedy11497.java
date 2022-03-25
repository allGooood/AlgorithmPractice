package greedy;

import java.io.*;
import java.util.Arrays;

public class Greedy11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int r=0; r<N; r++){
            int inputTotal = Integer.parseInt(br.readLine());
            String[] numbersString = br.readLine().split(" ");
            int[] numbers = new int[inputTotal];
            for(int i=0; i<numbers.length; i++){
                numbers[i] = Integer.parseInt(numbersString[i]);
            }
            Arrays.sort(numbers);

            int maxDiff = 0;

            int[] logs = new int[inputTotal]; // log = 통나무
            int left = 0;
            int right = numbers.length - 1;

            for(int i=0; i<numbers.length; i++){
                if(i % 2 == 0){
                    logs[left] = numbers[i];
                    if(i > 0){
                        maxDiff = Math.max(Math.abs(logs[left] - logs[left-1]), maxDiff);
                    }
                    left++;
                } else{
                    logs[right] = numbers[i];
                    if(i > 1){
                        maxDiff = Math.max(Math.abs(logs[right+1] - logs[right]), maxDiff);
                    }
                    right--;
                }
            }
            maxDiff = Math.max(Math.abs(logs[logs.length-1] - logs[0]), maxDiff);
            System.out.println(maxDiff);
        }

    }

}
