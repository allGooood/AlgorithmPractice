package Line;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int num_teams = 3;
        String[] remote_tasks = {"development","marketing","hometask"};
        String[] office_tasks = {"recruitment","education","officetask"};
        String[] employees = {"1 development hometask","1 recruitment marketing"
                                ,"2 hometask","2 development marketing hometask"
                                ,"3 marketing","3 officetask","3 development"};

        int[] answer =  solution(num_teams, remote_tasks, office_tasks, employees);

        for(int i=0; i<answer.length; i++){
            System.out.println(answer);
        }

    }

    //String[] employees = {"1 development hometask","1 recruitment marketing"
    //                                ,"2 hometask","2 development marketing hometask"
    //                                ,"3 marketing","3 officetask","3 development"};
    public static int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        int[] answer = {};

        //String[] remoteEmployees = new String[employees.length];
        Map<Integer, String> remoteEmployees = new TreeMap<>();
        String[] employeeAsTeam = new String[num_teams + 1];

        for(int i=0; i< employees.length; i++){

        }

        for(int i=0; i< employees.length; i++){
            for(int j=0; j< remote_tasks.length; j++){
                if(employees[i].contains(remote_tasks[j])){
                    //remoteEmployees.put()
                }
            }
        }

//        int index = 0;
//        for(int i=0; i<remoteEmployees.length; i++){
//            //if(remoteEmployees[i] != null){
//            if()
//            //}
//        }

        for(int i=0; i<employees.length; i++){
            String targetEmployee = employees[i];
            String[] employeeInfo = targetEmployee.split(" ");

        }

//        Arrays.sort(employees);
//        for(int i=0; i<remoteEmployees.length; i++){
//            System.out.println(remoteEmployees[i]);
//        }


        return answer;
    }

    private static void parseEmployees(String[] employees) {

    }
}

class EmployeeInfo{
    int teamNum;
    String workList;
    int employeeNum;

    public EmployeeInfo(int teamNum, String workList, int employeeNum) {
        this.teamNum = teamNum;
        this.workList = workList;
        this.employeeNum = employeeNum;
    }
}