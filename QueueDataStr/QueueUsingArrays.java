package QueueDataStr;

public class QueueUsingArrays {

    static class Queue{
        static int arr[];
        static int rear;
        static int front;
        static int size;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = front = -1;
        }


        // Is empty
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        // full in circular Queue
        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        //Add O(1)
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //first time add
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1 ) % size;
            arr[rear] = data;
        }

        //Remove O
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = arr[front]; 
            if(front == rear){
                front = rear = -1;
            }else{
                front = (front + 1) % size;
            }
            return result;
        }


        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

    }


    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove()); 
        q.add(4);
        System.out.println(q.remove()); 
        System.out.println(q.remove()); 
        System.out.println(q.remove()); 
    }
    
}
