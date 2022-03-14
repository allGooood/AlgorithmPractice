import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {
        //--자료구조 생성
        Word[] words = new Word[5];
        List<Word> list = new ArrayList<>();

        //--객체 비교를 위해 "comparator"생성
        Comparator<Word> comparator = new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o2.length - o1.length;
            }
        };

        //--정렬
        //자료구조-배열
        Arrays.sort(words, comparator); //"comparator"사용
        Arrays.sort(words, (o1, o2) -> o2.length - o1.length); //람다식사용
        //자료구조-리스트
        Collections.sort(list, comparator); //"comparator"사용
        Collections.sort(list, (o1, o2) -> o2.length - o1.length); //람다식사용
    }
}
class Word{
    int index;
    int length;
    String[] wordArray;

    public Word(int index, int length, String[] wordArray) {
        this.index = index;
        this.length = length;
        this.wordArray = wordArray;
    }
}