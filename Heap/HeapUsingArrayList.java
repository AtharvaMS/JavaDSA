package Heap;

import java.util.ArrayList;



public class HeapUsingArrayList {

    static class Heap{

        //Implementation of MIN-HEAP
        // to convert to max heap just change comparisons in add and remove -> heapify function


        ArrayList<Integer> list = new ArrayList<>();
        // parent child relation
        // parent index = i
        // child index = 2i+1 and 2i+2

        public void add(int data){

            list.add(data);
            int child = list.size() - 1; //new added node index
            int parent = (child - 1 )/2; //parent index

            while(list.get(parent) > list.get(child)){
                //swop
                int temp = list.get(child);
                list.set(child, list.get(parent));
                list.set(parent, temp);

                //Updating index
                child = parent;
                parent = (child - 1)/2;
            }

        }

        public int peek(){
            return list.get(0);
        }

        private void Heapify(int idx){
            int left = 2*idx+1;
            int right = 2*idx+2;
            int minIndex = idx;

            if(left < list.size() && list.get(minIndex) > list.get(left)){
                minIndex = left;
            }

            if(right < list.size() && list.get(minIndex)> list.get(right)){
                minIndex = right;

            }


            if(minIndex != idx){
                //swop
                int temp = list.get(idx);
                list.set(idx, list.get(minIndex));
                list.set(minIndex, temp);
                
                Heapify(minIndex);
            }

        }
    
        //use of heapify function to rebalance unbalanced nodes.
        public int remove(){
            int data = list.get(0);

            //step1 : swop first and last value
            int temp = list.get(0);
            list.set(0, list.get(list.size()-1));
            list.set(list.size()-1, temp);
            
            // delete last element
            list.remove(list.size()-1);

            //Heapify
            Heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }
    
    }



    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(6);
        h.add(3);
        h.add(10);
        h.add(2);
        h.add(4);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
            
        }
    }   
    
}
