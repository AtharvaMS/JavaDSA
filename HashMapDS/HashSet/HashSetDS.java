package HashMapDS.HashSet;




import java.util.*;

public class HashSetDS {
    //NO DUPLICATES
    // Unordered
    // NULL not allowed
    

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(5);
        set.add(2);
        set.add(6);
        set.add(5);

        // System.out.println(set);

        // System.out.println(set.contains(5));
        // System.out.println(set.size());
        // // set.clear();
        // System.out.println(set.size());



        //Iterations on HashSet
        // 1. Using Iterator(Interface)-> returns iterator for set
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());            
        }

        // 2. Advanced Loops
        for(Integer i : set){
            System.out.print(i);
        }

        //LinkedHashset
        // Maintains insertion order
        LinkedHashSet<Integer> lset = new LinkedHashSet<>();
        lset.add(6);
        lset.add(4);
        lset.add(34);
        lset.add(2);
        lset.add(6);

        System.out.println(lset);


        // TreeSet
        // Ordered: ascending
        // Does comparisions : not allowd NULL value.
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(6);
        ts.add(4);
        ts.add(34);
        ts.add(2);
        ts.add(6);
        System.out.println(ts);
    }
}
