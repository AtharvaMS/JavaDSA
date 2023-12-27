package LinkedList;



public class LinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    
    public static Node head;
    public static Node tail;
    int size;

    public void addFirst(int data){
        // step1 : Create a new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        // Step2 : referencing to next node;
        newNode.next = head;

        //step3 : current node is head.
        head = newNode;


    }

    public void addLast(int data){
        //Creating node
        Node newNode = new Node(data);
        size++;
        //Corner Case
        if(head ==  null){
            head = tail = newNode;
        }
        // linking to last node
        tail.next = newNode;

        //Reassigning last node
        tail = newNode;

    }


    public void printLL(){

        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public void add(int idx, int data){
        //corner case
        if(idx == 0){
            addFirst(data);
        }

        //Create intrative variable and new node;

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        //itrate to given index
        while(i<idx-1){
            temp = temp.next;
            i++;
        }

        //Adding new node and making link
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst(){
        if(size == 0){
            System.out.print("LL is empty!");
            return Integer.MAX_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.print("LL is empty!");
            return Integer.MAX_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        //itrate to second last node;
        Node temp = head;
        for(int i=0; i<size-2;i++){
            temp = temp.next;
        }

        int val =temp.next.data; // tail data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }


    public static int interativeSearch(LinkedList list, int key){

        if(list.size < 2 && head == tail && head.data == key ){
            return head.data;
        }

        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.data == key){
                return index;
            }

            temp = temp.next;
            index++;
        }

        return -1;

    }


    public static int recSearch(int key){
        return helpRecSearch(head, key);

    }

    private static int helpRecSearch(Node head, int key) {
        
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int index = helpRecSearch(head.next, key);
        if(index == -1){
            return -1;
        }
        

        return index+1;
        
    }


    public static void reverseLinkedList(LinkedList list){

        Node previous = null;
        Node current = tail = head;
        Node next;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current =next;
            
        }
        head = previous;
    }


    public void removeFormLast(int n){
        // calculate size
        Node temp = head;
        int length=0;
        while(temp != null){
            temp = temp.next;
            length++;
        }

        if( length == n){
            head =head.next;
            return;
        }

        int i = 1;
        Node prev = head;
        while( i < length - n ){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;



    }


    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }

        // Find mid
        Node mid = findMid(head);
        //reverse linked list
        Node previous = null;
        Node current = mid;
        Node next;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }

        Node rightHead = previous;
        Node leftHead = head;

        //check from both ends

        while(rightHead != null){
            if(rightHead.data != leftHead.data){
                return false;
            }
            rightHead = rightHead.next;
            leftHead = leftHead.next;
        } 

        return true;
    }


    private Node findMid(Node head) {

        Node slow = head;
        Node fast = head;

         while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
         }

        return slow;
    }


    public static boolean isCycleExist(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }

        return false;

    }


    public static void reomveCycle(){

        // Corner case: Linked list should not be joined at head or else code will not work. As previous will be null only. Value of previous will not change.
       
        Node slow = head;
        Node fast = head;
        boolean exist = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                exist = true;
                break;
            }
        }

        if(exist == false){
            return;
        }

        slow = head;
        Node previous = null;

        while(slow != fast){
            previous = fast;
            slow = slow.next;
            fast = fast.next;
        }

        previous.next = null;

    }

    public Node mergeSort(Node head){
        //base case
        if(head == null || head.next == null){
            return head;
        }


        // find mid
        Node mid = findMidForMergeSort(head);
        //left and right mergesort calls

        Node rightHead = mid.next;
        mid.next = null;
        Node lefthead = head;

        Node newleft = mergeSort(lefthead);
        Node newRight = mergeSort(rightHead);


        //merge
        return merge(newleft, newRight);
    }



    private Node merge(Node head1, Node head2) {
        Node mergerdLL = new Node(-1);
        Node temp = mergerdLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }

        }

        while(head1 != null){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
        }

        while(head2 != null){
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
        }


        return mergerdLL.next;
    }

    private Node findMidForMergeSort(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.printLL();
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.printLL();
        // ll.addFirst(0);
        // ll.addLast(6);
        // ll.addLast(5);
        // ll.printLL();

        // ll.removeFirst();
        // ll.printLL();
        // ll.removeLast();
        // ll.printLL();

        // System.out.println(interativeSearch(ll, 6));
        // System.out.println(recSearch( 6));
        // reverseLinkedList(ll);
        // ll.printLL();
        
        // ll.removeFormLast(3);
        // ll.printLL();
        

        ll.addLast(7);
        ll.addLast(6);
        ll.addLast(3);
        ll.addLast(1);
        ll.addLast(5);
        ll.addLast(2);
        ll.addLast(4);

        ll.printLL();
     

        // ll.addLast(2);
        // ll.addLast(1);
       
        // System.out.println(head.data);
        // System.out.println(head.next.data);
        // ll.printLL();
        // System.out.println(ll.isPalindrome());
        
        // head.next.next.next.next.next.next.next = head.next.next.next;
        // // ll.printLL();
        // System.out.println(isCycleExist()); 
        // reomveCycle();

        
        head =  ll.mergeSort(head);
 
        ll.printLL();
        


        

       


    }
 }
