package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSWithRecursion2468 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int n;
    static int[][] areaMap;
    static boolean[][] visited;

    static int maxLevel = 0;
    static int areaMax = 0;

    public static void main(String[] args) throws IOException {
        //-------------------------------그래프 입력부-------------------------------//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        areaMap = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                areaMap[i][j] = Integer.parseInt(str[j]);
                maxLevel = Math.max(areaMap[i][j], maxLevel);
            }
        }
        //!-------------------------------그래프 입력부 끝-------------------------------!//

        //-------------------------------BFS 도입부-------------------------------//
        for(int waterLevel=0; waterLevel<=maxLevel; waterLevel++){
            int totalArea = 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j]){
                        if(areaMap[i][j] > waterLevel){
                            dfs(waterLevel, i, j);
                            totalArea++;
                        }
                    }
                }
            }
            areaMax = Math.max(totalArea, areaMax);
            visited = new boolean[n][n];
        }
        //!-------------------------------BFS 도입부-------------------------------!//

        System.out.println(areaMax); //결과 출력
    }

    private static void dfs(int waterLevel, int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<dx.length; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX<0 || nextY<0 || nextX>=n || nextY>=n) {
                continue;
            }

            if(areaMap[nextX][nextY] > waterLevel && !visited[nextX][nextY]){
                dfs(waterLevel, nextX, nextY);
            }
        }
    }
}
