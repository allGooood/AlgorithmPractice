package string;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class String4949 {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while(!(line = br.readLine()).equals(".")){
            String result = "yes";
            Deque<Character> stack = new ArrayDeque<>();
//            Stack<Character> stack = new Stack<>();

            for(int i=0; i<line.length(); i++){
                char character = line.charAt(i);
                if(character == '(' || character == '['){
                    stack.push(character);
                }

                if(character == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        result = "no";
                        break;
                    }
                }

                if(character == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        result = "no";
                        break;
                    }
                }
            }

//            System.out.println(!stack.isEmpty() ?  "no" : result);
            bw.write(!stack.isEmpty() ?  "no" : result);
            bw.write("\n");
            bw.flush();
        }
    }

    /*public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String line;
        while(!(line = scanner.nextLine()).equals(".")){
            String result = "yes";
            Stack<Character> stack = new Stack<>();

            for(int i=0; i<line.length(); i++){
                char character = line.charAt(i);
                if(character == '(' || character == '['){
                    stack.push(character);
                }

                if(character == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        result = "no";
                        break;
                    }
                }

                if(character == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        result = "no";
                        break;
                    }
                }
            }
            System.out.println(!stack.isEmpty() ?  "no" : result);
        }
    }*/

    /*public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String line;
        while(!(line = scanner.nextLine()).equals(".")){
            String result = "yes";
            Stack<Character> stack = new Stack<>();

            for(int i=0; i<line.length(); i++){
                char character = line.charAt(i);
                if(character == '(' || character == '['){
                    stack.add(character);
                }

                if(character == ')'){
                    if(stack.isEmpty()){
                        result = "no";
                        break;
                    }
                    if(stack.pop() != '('){
                        result = "no";
                        break;
                    }
                }

                if(character == ']'){
                    if(stack.isEmpty()){
                        result = "no";
                        break;
                    }
                    if(stack.pop() != '['){
                        result = "no";
                        break;
                    }
                }
            }

            System.out.println(!stack.isEmpty() ?  "no" : result);
        }
    }*/

}
