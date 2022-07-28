package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Random1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        int[] heights = new int[9];

        for(int i=0; i<9; i++){
            int height = Integer.parseInt(br.readLine());
            total += height;
            heights[i] = height;
        }
        Arrays.sort(heights);

        int fakeA = 0;
        int fakeB = 0;
        for(int a=0; a<8; a++){
            for(int b=(a+1); b<9; b++){
                if(total - (heights[a] + heights[b]) == 100){
                    fakeA = heights[a];
                    fakeB = heights[b];
                    break;
                }
            }
        }

        for(int i=0; i<heights.length; i++){
            if(heights[i] != fakeA && heights[i] != fakeB){
                System.out.println(heights[i]);
            }
        }
    }
}
