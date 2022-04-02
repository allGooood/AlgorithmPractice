package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class String5052 {
    static String[] phoneBook;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int numberAmount = Integer.parseInt(br.readLine());

            // phoneBook(List)에 전화번호 넣기
            phoneBook = new String[numberAmount];
            for(int j=0; j<numberAmount; j++){
                String number = br.readLine();
                phoneBook[j] = number;
            }
            Arrays.sort(phoneBook);

            String result = judgePhoneBook();
            System.out.println(result);
        }

    }

    private static String judgePhoneBook() {
        for(int i=0; i<phoneBook.length-1; i++){
            if(phoneBook[i+1].startsWith(phoneBook[i])){
                return "NO";
            }
        }
        return "YES";
    }
}
