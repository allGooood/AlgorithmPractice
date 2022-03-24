package kakao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
//    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);
//        Date d1 = f.parse("19:00");
//        Date d2 = f.parse("07:59");
//        long diff = d1.getTime() - d2.getTime(); //초 계산
//        long sec = diff / 60000; // (diff / 1000 / 60) --> 초를 분으로 transfer
//        System.out.println("diff: " + diff);
//        System.out.println("sec: " + sec);
//    }

    static Map<Integer, Long> carParkRecords = new HashMap<>(); // 주차장에 들어온 차량 체크용 map
    static Map<Integer, Long> useTimeRecords = new TreeMap<>(); // 차량별 누적 사용시간
    static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", Locale.KOREA);

    public static void main(String[] args) throws ParseException {
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN", "00:00 1235 IN"};

        int[] answer = solution(fees, records);
        for(int i=0; i< answer.length; i++){
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        int[] answer = {};

        for(int i=0; i<records.length; i++){
            // OUT 기록이 있는 차량의 총 이용시간 계산(in mapForFee)
            parseRecords(records[i]);
        }

        // 출차 기록이 없는 차량의 경우를 계산
        Iterator<Integer> keys = carParkRecords.keySet().iterator();
        while(keys.hasNext()){
            int carNum = keys.next();

            long timeIN = carParkRecords.get(carNum);
            long timeOUT = formatter.parse("23:59").getTime();
            long difference = (timeOUT - timeIN) / 60000;

            calculateTotalMinutes(carNum, difference);
            //carParkRecords.remove(carNum);
        }

        // 각 차량별 정산
        answer = getTotalFee(fees);
        return answer;
    }

    private static void calculateTotalMinutes(int carNum, long difference){
        if(useTimeRecords.containsKey(carNum)){
            useTimeRecords.put(carNum, useTimeRecords.get(carNum) + difference);
        } else{
            useTimeRecords.put(carNum, difference);
        }
    }

    // OUT 기록이 있는 차량의 총 이용시간 계산(in mapForFee)
    private static void parseRecords(String record) throws ParseException {
        String[] recordParsed = record.split(" ");
        long time = formatter.parse(recordParsed[0]).getTime();
        int carNum = Integer.parseInt(recordParsed[1]);

        if(!carParkRecords.containsKey(carNum)){
            carParkRecords.put(carNum, time);
        } else{
            long timeIN = carParkRecords.get(carNum);
            long difference = (time - timeIN) / 60000; // 60000 --> (밀리세컨 1000 * 분 60)
            calculateTotalMinutes(carNum, difference);
            carParkRecords.remove(carNum);
        }
    }

    // 각 차량별 정산
    private static int[] getTotalFee(int[] fees) {
        int[] answer = new int[useTimeRecords.size()];

        int basicTime = fees[0];    int basicFee = fees[1];
        double perMin = fees[2];    int perFee = fees[3];

        Object[] mapkey = useTimeRecords.keySet().toArray();
        Arrays.sort(mapkey);

        Iterator<Integer> keys = useTimeRecords.keySet().iterator();
        int index = 0;
        while(keys.hasNext()){
            int carNum = keys.next();
            long totalTime = useTimeRecords.get(carNum);

            if(totalTime < basicTime) {
                answer[index] = basicFee;
            } else{
                answer[index] = (int) (Math.ceil((totalTime - basicTime)/(perMin*1.0))*perFee) + basicFee;
            }
            index++;
        }
        return answer;
    }
}
