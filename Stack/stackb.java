package Stack;

import java.util.ArrayList;

public class stackb {

    static class stack{

        static ArrayList<Integer> list = new ArrayList<>();
        public boolean isEmpty(){
            if(list.size() == 0){
                return true;
            }
            return false;
        }

        // O(1)
        public void push(int data){
            list.add(data);
        
        }

        // O(1)
        public int pop(){
            int data = list.get(list.size()-1);
            list.remove(list.size()-1);
            return data;
        }

        public int peek(){
            return list.get(list.size()-1);
        }




    }




    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek() + " ");
            s.pop();
        }
    }
    
}
