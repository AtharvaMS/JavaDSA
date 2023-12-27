package ArrayList;

import java.util.ArrayList;

public class Arrayliist {
    
    public static void main(String[] args) {

        //Declaration
        ArrayList<Integer> list = new ArrayList<>();

        //Adding element to list. Stores integers to list in the form of objects.
        //O(1)
        list.add(3);
        list.add(77);
        list.add(99);
        list.add(55);
        list.add(2);

        list.add(1,88); //O(n)

        //Printing Arraylist
        System.out.println(list);

        //GET operation. O(1)
        int element = list.get(3);
        System.out.println(element);

        //REMOVE operation O(n)
        list.remove(2);
        System.out.println(list);

        //SET operation. O(n)
        list.set(0, 99);
        System.out.println(list);

        //CONTAINS operaiton O(n)

        System.out.println(list.contains(2));
        System.out.println(list.contains(45));
        
    }
}
