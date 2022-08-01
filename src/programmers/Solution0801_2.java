package programmers;

import java.util.*;

public class Solution0801_2 {
    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        int[] answer = solution(id_list, report, k);
        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> total = new HashMap<>();
        Map<String, Set<String>> history = new HashMap<>();

        for(String r : new HashSet<>(Arrays.asList(report))){ //동일한 내용의 report를 하나로 만들기 위해 Set사용
            String A = r.split(" ")[0];
            String B = r.split(" ")[1];

            history.putIfAbsent(A, new HashSet<>(){{ add(B); }});
            history.get(A).add(B);

            total.put(B, total.getOrDefault(B, 0) + 1);
        }

        for(String B : total.keySet()){
            if(total.get(B) >= k){
                for(int j=0; j< id_list.length; j++){
                    if(history.containsKey(id_list[j]) && history.get(id_list[j]).contains(B)){
                        answer[j]++;
                    }
                }
            }
        }
        return answer;
    }
}
