package greedy;

import java.util.*;

public class Greedy10610 {
    static Integer[] numberArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberStr = scanner.nextLine();
        if(numberStr.contains("0")){
            String[] strArray = numberStr.split("");

            int total = 0;
            numberArray = new Integer[strArray.length];
            for(int i=0; i< strArray.length; i++){
                numberArray[i] = Integer.parseInt(strArray[i]);
                total += numberArray[i];
            }
            if(total % 3 == 0){
                Arrays.sort(numberArray, Collections.reverseOrder());
                for(int i=0; i< numberArray.length; i++){
                    System.out.print(numberArray[i]);
                }
            } else{
                System.out.println(-1);
            }
            total = 0;
        }else{
            System.out.println(-1);
        }
    }

}
