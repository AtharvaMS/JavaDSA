package HashMapDS;

import java.util.HashMap;

public class ValidAnagram {


    public static void main(String[] args) { //O(n)
        // String s1 = "Knee";
        // String s2 = "Keen";
        String s1 = "tulip";
        String s2 = "lipid";

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        };

        for(int j=0; j<s2.length(); j++){
            char ch = s2.charAt(j);
            if(map.get(ch) != null){
                if(map.get(ch) ==1 ){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }
        }

        System.out.println(map.isEmpty());
    }
    
}
