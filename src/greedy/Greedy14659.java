package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy14659 {
    static int totalPeople;
    static int[] mountainHeight;
    static int maxValue = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalPeople = Integer.parseInt(br.readLine());
        mountainHeight = new int[totalPeople];

        String[] heightStr = br.readLine().split(" ");
        for(int i=0; i<totalPeople; i++){
            mountainHeight[i] = Integer.parseInt(heightStr[i]);
            Math.max(maxValue, mountainHeight[i]);
        }

        if(mountainHeight[0] == maxValue){
            result = totalPeople - 1;
        } else{
            countEnemyLost();
        }
        System.out.println(result);
    }

    public static void countEnemyLost(){
        for(int i=0; i<totalPeople; i++){ //비교기준이 되는 archer --> i
            int count = 0;
            for(int j=i+1; j<totalPeople; j++){ //상대방 archer --> j
                int biggerNum = Math.max(mountainHeight[i], mountainHeight[j]);
                if(biggerNum == mountainHeight[i]){
                    count++;
                } else{
                    System.out.println("i:"+i+", j:"+j+"break");
                    break;
                }

            }
            System.out.println("["+i+"]번째가 무찌른적: " + count);
            result = Math.max(result, count);
            System.out.println("["+i+"]번째 최대 수: " + result);
        }
    }
}
