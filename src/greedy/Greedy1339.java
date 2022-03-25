package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        int[] alphabet = new int[26];

        for(int i=0; i<N; i++){
            words[i] = br.readLine();
        }

        for(int i=0; i<words.length; i++){
            String target = words[i];

            int power = (int) Math.pow(10, (target.length()-1));
            for(int j=0; j< target.length(); j++){
                int indexByAscii = target.charAt(j) - 65;
                alphabet[indexByAscii] += power;
                power = power/10;
            }
        }

        Arrays.sort(alphabet);

        int mulNum = 9;
        int total = 0;
        for(int i=alphabet.length-1; i>=0; i--){
            if(alphabet[i] == 0) continue;
            total += (alphabet[i] * mulNum);
            mulNum--;
        }
        System.out.println(total);
    }
}

