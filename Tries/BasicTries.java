package Tries;

public class BasicTries {
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

    public static boolean searh(String key){
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

    

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their","any", "thee" };
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        System.out.println(searh("thee"));
    }
    
}
