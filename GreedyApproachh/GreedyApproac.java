package GreedyApproachh;

import java.util.ArrayList;

public class GreedyApproac {


    // Question:
    // you are given n activities with their start and end time. Find the maximum number of activities 
    // that can be done by single person assuimg single persion can work on single activity at given time.
    
    // Activities are sorted according to end time of activities.

    public static void main(String[] args) {

        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        

        //sorting according to end  time(Already sorted)
        int maxAct = 1;
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(0);
        int lastEndTime = end[0];

        for(int i =1; i<end.length;i++){
            if(start[i] >= lastEndTime){
                maxAct++;
                lastEndTime = end[i];
                answer.add(i);
            }

        }

        System.out.println("Total max activites: " + maxAct);
        for(int i = 0; i<answer.size();i++){
            System.out.print( "A" +answer.get(i) + " ");

        }


        
    }
    
}
