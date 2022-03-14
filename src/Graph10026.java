import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph10026 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static Queue<Point> queue;
    static int areaTotal = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        String[][] colorBoard = new String[n][n];
        String[][] colorBoard2 = new String[n][n];
        boolean[][] visited = new boolean[n][n];
        boolean[][] visited2= new boolean[n][n];
        queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            String[] str = scanner.next().split("");
            for(int j=0; j<n; j++){
                colorBoard[i][j] = str[j];
                colorBoard2[i][j] = str[j];
                if(str[j].equals("G")){
                    colorBoard2[i][j] = "R";
                }
            }
        }

        bfs(colorBoard, visited);
        System.out.print(areaTotal);
        areaTotal = 0;

        bfs(colorBoard2, visited2);
        System.out.print(" " + areaTotal);
    }

    private static void bfs(String[][] colorBoard, boolean[][] visited) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    String colorPicked = colorBoard[i][j];
                    visited[i][j] = true;
                    queue.add(new Point(i, j, colorPicked));
                    checkQueue(colorBoard, visited);
                    bfs(colorBoard, visited);
                }
            }
        }
    }

    private static void checkQueue(String[][] colorBoard, boolean[][] visited) {
        while(!queue.isEmpty()){
            Point colorPicked = queue.poll();
            for(int i=0; i<dx.length; i++){
                int nextI = colorPicked.x + dx[i];
                int nextJ = colorPicked.y + dy[i];
                if(nextI<0 || nextJ<0 || nextI>=n || nextJ>=n){
                    continue;
                }
                if(colorBoard[nextI][nextJ].equals(colorPicked.color) && !visited[nextI][nextJ]){
                    queue.add(new Point(nextI,nextJ, colorBoard[nextI][nextJ]));
                    visited[nextI][nextJ] = true;
                }
            }
        }
        areaTotal++;
    }
}

class Point{
    int x;
    int y;
    String color;
    public Point(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
