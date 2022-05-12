package parsing;

import java.util.*;

public class Parsing1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toUpperCase();
        int[] alphabets = new int[26];

        for(int i=0; i< input.length(); i++){
            alphabets[input.charAt(i) - 65]++;
        }

//        for(int i=0; i< alphabets.length; i++){
//            System.out.println((char)(i+65) + ": "  + alphabets[i]);
//        }

        int max = -1;
        int result = -2;
        for(int i=0; i< alphabets.length; i++){
            if(alphabets[i] > max){
                max = alphabets[i];
                result = i;
            }else if(alphabets[i] == max){
                result = -2;
            }
        }
        System.out.println((char)(result+65));
    }

    //Map 사용할 경우
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String input = scanner.nextLine();
//        char[] alphabets = input.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//
//        String result = "";
//        for(int i=0; i< alphabets.length; i++){
//            char alphabet = alphabets[i];
//            if(alphabet >= 97 && alphabet <= 122){
//                alphabet -= 32;
//            }
//
//            map.put(alphabet, map.getOrDefault(alphabet, 0) + 1);
////            if(map.containsKey(alphabet)){
////                map.put(alphabet, map.get(alphabet) + 1);
////            }else{
////                map.put(alphabet, 1);
////            }
//        }
//
//        Comparator comparator = Map.Entry.comparingByValue(Comparator.reverseOrder());
////        map.entrySet().stream().sorted(comparator);
////        Object[] keys = map.entrySet().stream().sorted(comparator).toArray();
//
//        //System.out.println("---");
//        //Object[] keys = map.keySet().toArray();
////        for(Object o : keys){
////            System.out.println(o.toString());
////        }
//
////        Map.Entry newEntry = (Map.Entry) Collections.reverseOrder();
////        if(map.get(keys[0]) == map.get(keys[1])){
////            System.out.println("?");
////        }else{
//            Map.Entry maxEntry = Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue));
//            System.out.println(maxEntry.getKey());
//        //}
//    }
}
