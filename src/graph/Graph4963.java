package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Graph4963 {
    //<INPUT>
    //1 1
    //0
    //-----------------------
    //2 2
    //0 1
    //1 0
    //-----------------------
    //3 2
    //1 1 1
    //1 1 1
    //-----------------------
    //5 4
    //1 0 1 0 0
    //1 0 0 0 0
    //1 0 1 0 1
    //1 0 0 1 0
    //-----------------------
    //5 4
    //1 1 1 0 1
    //1 0 1 0 1
    //1 0 1 0 1
    //1 0 1 1 1
    //-----------------------
    //5 5
    //1 0 1 0 1
    //0 0 0 0 0
    //1 0 1 0 1
    //0 0 0 0 0
    //1 0 1 0 1
    //0 0

    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    static int islandTotal = 0;
    static int width;
    static int height;

    static int[][] map;
    static boolean[][] visited;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String line = br.readLine();
            if(line.equals("0 0")){
                break;
            }
            String[] lineSplit = line.split(" ");

            width = Integer.parseInt(lineSplit[0]);
            height = Integer.parseInt(lineSplit[1]);
            map = new int[height][width];
            visited = new boolean[height][width];

            for(int i=0; i<height; i++){
                String[] lineForMap = br.readLine().split(" ");
                for(int j=0; j<width; j++){
                    map[i][j] = Integer.parseInt(lineForMap[j]);
                }
            }

            islandTotal = 0;
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        if(map[i][j] == 1){
                            findIslands(i, j, false);
                        }
                    }
                }
            }

            System.out.println(islandTotal);
        }
    }

    private static void findIslands(int x, int y, boolean lastNode) {
        visited[x][y] = true;
        stack.push(map[x][y]);

//        while(!stack.isEmpty()){
//            int target = stack.peek();
//            for(int next=0; next<dx.length; next++){
//                int nextX = x + dx[next];
//                int nextY = y + dy[next];
//
//                if(nextX<0 || nextY<0 || nextX>=height || nextY>=width) continue;
//
//                if(!visited[nextX][nextY]){
//                    visited[nextX][nextY] = true;
//                    if(map[nextX][nextY] == 1){
//                        stack.push(map[])
//                    }
//                }
//            }
//        }
    }

}

