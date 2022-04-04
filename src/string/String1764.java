package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class String1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] line = br.readLine().split(" ");
//        int N = Integer.parseInt(line[0]); //듣
//        int M = Integer.parseInt(line[1]); //듣보
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken()); //듣
        int M = Integer.parseInt(stringTokenizer.nextToken()); //듣보

        Set<String> noHeard = new HashSet<>();
        Set<String> neither = new TreeSet<>();

        for(int i=0; i<N; i++){
            String name = br.readLine();
            noHeard.add(name);
        }

        for(int i=0; i<M; i++){
            String name = br.readLine();
            if(noHeard.contains(name)){
                neither.add(name);
            }
        }

        System.out.println(neither.size());
        neither.stream().forEach(System.out::println);
    }

    // Map 사용 - Memory 비교
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] line = br.readLine().split(" ");
//        int N = Integer.parseInt(line[0]); //듣
//        int M = Integer.parseInt(line[1]); //보
//
//        Map<String, Character> noHeard = new HashMap<>();
//        Map<String, Character> neither = new TreeMap<>();
//
//        for(int i=0; i<N; i++){
//            String name = br.readLine();
//            noHeard.put(name, name.charAt(0));
//        }
//
//        for(int i=0; i<M; i++){
//            String name = br.readLine();
//            if(noHeard.containsKey(name)){
//                neither.put(name, name.charAt(0));
//            }
//        }
//
//        System.out.println(neither.size());
//        neither.keySet().stream().forEach(System.out::println);
//    }
}
