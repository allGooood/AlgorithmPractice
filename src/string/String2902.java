package string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class String2902 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        result.append(line.charAt(0));

        for(int i=0; i<line.length(); i++){
            if(line.charAt(i) == '-'){
                result.append(line.charAt(i+1));
            }
        }
        System.out.println(result);
    }

    // ---------- Split ---------- //
    // 분리 된 문자열에 유연한 작업 필요 시
    // 분리 된 문자열을 배열에 저장
    // 정규식 사용
    // 단순한 구분자일 경우
    /*public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] words = line.split("-");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            result.append(word.charAt(0));
        }
        System.out.println(result);
    }*/

    // ---------- Tokenizer ---------- //
    // 배열 생성 X --> 메모리 효율 높음
    // 복잡한 구분자일 경우
    // hasMoreTokens(), nextToken()의 반복 사용 --> 길어지는 코드
    /*public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(line, "-");

        StringBuilder result = new StringBuilder();
        while(tokenizer.hasMoreTokens()){
            String eachWord = tokenizer.nextToken();
            result.append(eachWord.charAt(0));
        }
        System.out.println(result);
    }*/
}
