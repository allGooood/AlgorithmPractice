import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Greedy1946 {
    static int totalPeople;
    static int[][] rankBoard;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int caseTotal = Integer.parseInt(br.readLine());
//
//        for(int caseNum=0; caseNum<caseTotal; caseNum++){
//            System.out.println(caseNum);
//
//            totalPeople = Integer.parseInt(br.readLine());
//            System.out.println("totalPeople: " + totalPeople);
//
//            rankBoard = new int[totalPeople][2];
//            for(int i = 0; i< totalPeople; i++){
//                String[] line = br.readLine().split(" ");
//                System.out.println("lineLength["+i+"]: " + line.length);
//                for(int j=0; j<line.length; j++){
//                    //System.out.println("rankBoard[i][j]: " + rankBoard[i][j]);
//                    rankBoard[i][j] = Integer.parseInt(line[j]);
//                    System.out.println("rankBoard[i][j]--2: " + rankBoard[i][j]);
//                }
//            }
//
//            int total = 0;
//            for(int i = 0; i<totalPeople; i++){
//                boolean passed = checkIfPassed(rankBoard[i][0], rankBoard[i][1], i);
//                if(passed) total++;
//            }
//            System.out.println(total);
//        }

        Scanner scanner = new Scanner(System.in);
        int caseTotal = scanner.nextInt();

        for(int caseNum=0; caseNum<caseTotal; caseNum++){
            totalPeople = scanner.nextInt();
            rankBoard = new int[totalPeople][2];
            for(int i = 0; i< totalPeople; i++){
                for(int j=0; j<2; j++){
                    rankBoard[i][j] = scanner.nextInt();
                }
            }

            int total = 0;
            for(int i = 0; i<totalPeople; i++){
                boolean passed = checkIfPassed(rankBoard[i][0], rankBoard[i][1], i);
                if(passed) total++;
            }
            System.out.println(total);
        }

    }

    private static boolean checkIfPassed(int docRank, int interviewRank, int self) {
        boolean passed = true;
        for(int i = 0; i< totalPeople; i++){
            if(i == self) continue;
            int othersDocRank = rankBoard[i][0];
            int othersInterviewRank = rankBoard[i][1];
            if(othersDocRank < docRank && interviewRank > othersInterviewRank){
                passed = false;
                break;
            }
        }
        return passed;
    }
}
