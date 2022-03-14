import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalStairs = Integer.parseInt(br.readLine());

        int[] stairScore = new int[totalStairs];
        int[] maxScore = new int[totalStairs];

        for(int i=0; i<totalStairs; i++){
            stairScore[i] = Integer.parseInt(br.readLine());
        }

        maxScore[0] = stairScore[0];
        maxScore[1] = stairScore[0] + stairScore[1];
        maxScore[2] = Math.max(maxScore[0], maxScore[1]) + stairScore[2];

        for(int i=3; i<totalStairs; i++){
            maxScore[i] = Math.max(maxScore[i-2], maxScore[i-3] + stairScore[i-1]) + stairScore[i];
        }

        System.out.println(maxScore[totalStairs-1]);
    }
}
