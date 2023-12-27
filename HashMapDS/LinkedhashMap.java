package HashMapDS;


import java.util.*;

public class LinkedhashMap {
    public static void main(String[] args) {
        

        //Linked Hash Map retains insertion order of data
        LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
        lMap.put("India", 50);
        lMap.put("China", 10);
        lMap.put("US", 3);
        
        System.out.println(lMap);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("India",  50);
        map.put("China", 10);
        map.put("US", 3);

        System.out.println(map);


        //Elements are Sorted using keys
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India",  50);
        tm.put("China", 10);
        tm.put("US", 3);

        System.out.println(tm);


    }
    
}
