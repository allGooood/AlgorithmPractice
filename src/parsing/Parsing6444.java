package parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parsing6444 {
    static int width;
    static int height;
    static int[][] excel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] secondLine = br.readLine().split(" ");

            width = Integer.parseInt(secondLine[0]);
            height = Integer.parseInt(secondLine[1]);
            excel = new int[height][width];

            for(int j=0; j<height; j++){
                String[] nextLine = br.readLine().split(" ");
                for(int k=0; k<width; k++){
                    String formula = "";
                    if(nextLine[k].contains("=")){
                        formula = nextLine[k];
                        return;
                    }
                    excel[j][k] = Integer.parseInt(nextLine[k]);
                }
            }

        }
    }

}







