package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Graph7576 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\ming8\\OneDrive\\바탕 화면\\graph.txt")));

        String[] str = br.readLine().split(" ");
        int width = Integer.parseInt(str[0]);
        int height = Integer.parseInt(str[1]);

        int[][] tomatoBox = new int[height][width];
        Queue<Location> queue = new LinkedList<>();

        for(int i=0; i<height; i++) {
            str = br.readLine().split(" ");
            for(int j=0; j<width; j++) {
                tomatoBox[i][j] = Integer.parseInt(str[j]);
                if(tomatoBox[i][j] == 1) queue.add(new Location(j, i));
            }
        }
//        Scanner scanner = new Scanner(System.in);
//        int width = scanner.nextInt();
//        int height = scanner.nextInt();
//        int[][] tomatoBox = new int[height][width];
//        Queue<graph.Location> queue = new LinkedList<>();
//
//        for(int i=0; i<height; i++){
//            for(int j=0; j<width; j++){
//                tomatoBox[i][j] = scanner.nextInt();
//                if(tomatoBox[i][j] == 1) queue.add(new graph.Location(j, i));
//            }
//        }


        while(!queue.isEmpty()) {
            day++;
            int round = queue.size();
            //for(int q=0; q<round; q++) {
            Location location = queue.poll();
//            int x = location.getX();
//            int y = location.getY();

            for (int i = 0; i < dx.length; i++) {
                int nextX = location.x + dx[i];
                int nextY = location.y + dy[i];

                if (nextX >= 0 && nextX < width && nextY >= 0 && nextY < height) {
                    if (tomatoBox[nextY][nextX] == 0) {
                        tomatoBox[nextY][nextX] = 1;
                        queue.offer(new Location(nextX, nextY));
                    }
                }
            }
            //}
        }

		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(tomatoBox[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
			}
		}
        System.out.println(day-1);
    }
}

class Location {
    int x;
    int y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}