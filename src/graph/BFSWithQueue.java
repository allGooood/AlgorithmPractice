package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFSWithQueue {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static String[][] colorBoard;
    static String[][] colorBoard2;
    static boolean[][] visited;
    static Queue<String> queue;

    static int areaCount = 0;

    public static void main(String[] args) throws IOException {
        //-------------------------------그래프 입력부-------------------------------//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        colorBoard = new String[N][N];
        colorBoard2 = new String[N][N];
        visited = new boolean[N][N];
        queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            String[] colorString = br.readLine().split("");
            for(int j=0; j<N; j++){
                colorBoard[i][j] = colorString[j];
                colorBoard2[i][j] = colorString[j];
                if(colorString[j].equals("R")){
                    colorBoard2[i][j] = "G";
                }
            }
        }
        //!-------------------------------그래프 입력부 끝-------------------------------!//

        //-------------------------------BFS 도입부-------------------------------//
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                String target = colorBoard[i][j];
                if(!visited[i][j]){
                    // 제일 첫 번째 Node로 BFS탐색 시작
                    bfs(target, i, j);
                    // 구역 카운트 증가
                    areaCount++;
                }
            }
        }
        //!------------ -------------------BFS 도입부-------------------------------!//

        System.out.println(areaCount); //결과 출력

//        visited = new boolean[N][N];
//        colorBoard = colorBoard2;
//        areaCount = 0;
//
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                String target = colorBoard[i][j];
//                if(!visited[i][j]){
//                    bfs(target, i, j);
//                    areaCount++;
//                }
//            }
//        }
//        System.out.println(areaCount);
    }

    // 방문여부 체크 --> Queue에 입력 --> Queue의 Node체크(+BFS 재귀)
    private static void bfs(String colorOfNodeOnCheck, int x, int y) {
        visited[x][y] = true;
        queue.add(colorOfNodeOnCheck);

        while(!queue.isEmpty()){
            String color = queue.poll();
            for(int i=0; i<dx.length; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX<0 || nextY<0 || nextX>=N || nextY>=N){
                    continue;
                }

                if(colorBoard[nextX][nextY].equals(color) && !visited[nextX][nextY]){
                    bfs(colorBoard[nextX][nextY], nextX, nextY);
                }
            }
        }
    }

}












