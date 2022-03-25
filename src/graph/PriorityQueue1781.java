package graph;

import java.io.*;
import java.util.*;

public class PriorityQueue1781 {
    static int totalWork;
    static int[][] workInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalWork = Integer.parseInt(br.readLine());
        workInfo = new int[totalWork][2];

        for(int i=0; i<totalWork; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<2; j++){
                workInfo[i][j] = Integer.parseInt(str[j]);
            }
        }
        Arrays.sort(workInfo, Comparator.comparingInt(o1 -> o1[0]));
        System.out.println(findMaxValue());
    }

    private static int findMaxValue() {
        int totalNoodles = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<totalWork; i++){
            priorityQueue.add(workInfo[i][1]);
            while(!priorityQueue.isEmpty() && priorityQueue.size() > workInfo[i][0]){
                priorityQueue.poll();
            }
        }
        while(!priorityQueue.isEmpty()){
            totalNoodles += priorityQueue.poll();
        }
        return totalNoodles;
    }
}
