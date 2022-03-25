package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Graph1987 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int n;
    static int m;
    static String[][] board;
    static boolean[][] visited;
    static Map<String, Boolean> usedAlphabet = new HashMap<>();
    static Stack<Dot> stack = new Stack<>();

    //static int totalMove = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);

        board = new String[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<m; j++){
                board[i][j] = line[j];
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]){
                    dfs(i, j, false);
                }
            }
        }

        System.out.println(stack.size());
    }

    private static void dfs(int i, int j, boolean lastNode) {
        visited[i][j] = true;
        usedAlphabet.put(board[i][j], true);
        stack.push(new Dot(i, j));

        while(!stack.isEmpty()){
            Dot topNode = stack.peek();
            for(int around=0; around<dx.length; around++){
                //lastNode = true;
                int nextI = topNode.x + dx[around];
                int nextJ = topNode.y + dy[around];

                if(nextI<0 || nextJ<0 || nextI>=n || nextJ>=m) continue;

                if(!visited[nextI][nextJ]){
                    visited[nextI][nextJ] = true;
                    stack.push(new Dot(nextI, nextJ));

                    String target = board[nextI][nextJ];

                    if(!usedAlphabet.containsKey(target)){
                        usedAlphabet.put(target, true);
                        //lastNode = false;
                    } else{
                        stack.pop();
                    }
                }

//                if(lastNode){
//                    stack.pop();
//                }
            }
        }
    }

//    private static void dfs(int i, int j) {
//        visited[i][j] = true;
//        usedAlphabet.put(board[i][j], true);
//
//        for(int around=0; around<dx.length; around++){
//            int nextI = i + dx[around];
//            int nextJ = j + dy[around];
//
//            if(nextI<0 || nextJ<0 || nextI>=n || nextJ>=m) continue;
//
//            if(!visited[nextI][nextJ]){
//                visited[nextI][nextJ] = true;
//                String target = board[nextI][nextJ];
//                if(!usedAlphabet.containsKey(target)){
//                    usedAlphabet.put(target, true);
//                    //totalMove++;
//                    dfs(nextI, nextJ);
//                }
//            }
//        }
//    }


}

class Dot{
    int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}