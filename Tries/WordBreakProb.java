package Tries;

import Stack.reverseString;

public class WordBreakProb {
    static class Node{
        Node children[] = new Node[26];
        boolean endOfWord = false;

        Node(){
            for(int i = 0; i<26 ; i++){
                children[i] = null;
            }

        }
    }

    public static Node root = new Node(); // Empty by default

    public static void insert(String word){ //O(length of word)
        Node curr = root;
        for(int level = 0; level<word.length(); level++){
            int index = word.charAt(level) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }

    public static boolean search(String key){
        Node curr = root;
        for(int level = 0; level<key.length(); level++){
            int index = key.charAt(level) - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }
        return curr.endOfWord == true;

    }

    //Word Break problem.
    public static boolean wordBreak(String key){ //O(length of key)
        if(key.length() == 0){
            return true;
        }
        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0, i))  && wordBreak(key.substring(i, key.length()))){
                return true;
            }
            
        }

        return false;
    }

    public static void main(String[] args) {
        String words[] = { "i", "like", "samsung", "mobile", "ice" };;
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        // String key = "ilikesamsung";
        String key = "ilikesung";

        System.out.println(wordBreak(key));
    }
    
}

    