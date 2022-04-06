package parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Parsing9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int k=0; k<N; k++){
            String fullRecorded = br.readLine();
            Set<String> soundSet = new HashSet<>();

            String animal = "";
            while(!(animal = br.readLine()).equals("what does the fox say?")){
                String[] strArray = animal.split(" goes ");
                soundSet.add(strArray[1]);
            }

            String[] words = fullRecorded.split(" ");
            String result = "";
            for(int i=0; i<words.length; i++){
                if(!soundSet.contains(words[i])){
                    result += words[i] + " ";
                }
            }

            System.out.println(result.substring(0, result.length()-1));
        }
    }

    //먼저 배열만을 사용해서 풀었을때의 코드
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        for(int k=0; k<N; k++){
//            List<String> soundList = new ArrayList<>();
//            String fullRecorded = br.readLine();
//
//            String animal = "";
//            while(!(animal = br.readLine()).equals("what does the fox say?")){
//                String[] strArray = animal.split(" goes ");
//                soundList.add(strArray[1]);
//            }
//
//            String[] words = fullRecorded.split(" ");
//            for(int i=0; i< soundList.size(); i++){
//                String target = soundList.get(i);
//                for(int j=0; j< words.length; j++){
//                    if(words[j].equals(target)){
//                        words[j] = "";
//                    }
//                }
//            }
//
//            String result = "";
//            for(int i=0; i< words.length; i++){
//                if(!words[i].equals("")){
//                    result += words[i] + " ";
//                }
//            }
//            result = result.substring(0, result.length()-1);
//            System.out.println(result);
//        }
//    }



}
