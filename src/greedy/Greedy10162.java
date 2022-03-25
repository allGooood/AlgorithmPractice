package greedy;

import java.io.*;

public class Greedy10162 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int n;
    static int[][] areaMap;
    static boolean[][] visited;

    static int maxLevel = 0;
    static int areaMax = 0;

    public static void main(String[] args) throws IOException {
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

        for(int waterLevel=0; waterLevel<=maxLevel; waterLevel++){
            int totalArea = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j]){
                        if(areaMap[i][j] > waterLevel){
                            dfs(waterLevel, i, j);
                            totalArea++;
                        } else{
                            visited[i][j] = true;
                        }
                    }
                }
            }
            areaMax = Math.max(totalArea, areaMax);
            visited = new boolean[n][n];
        }
        System.out.println(areaMax);
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
            visited[nextX][nextY] = true;
        }
    }

}
