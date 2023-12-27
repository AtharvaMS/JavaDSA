package Tries;


public class PrefixProblem {
    static class Node{
        Node children[] = new Node[26];
        boolean endOfWord = false;
        int freq;
        Node(){
            for(int i = 0; i<26 ; i++){
                children[i] = null;
            }
            freq = 1;

        }
    }

    public static Node root = new Node(); // Empty by default

    public static void insert(String word){ //O(length of word)
        Node curr = root;
        for(int level = 0; level<word.length(); level++){
            int index = word.charAt(level) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }else{
                curr.children[index].freq++;
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

    public static void findPrefix(Node root, String ans){
        if(root == null){
            return;
        }

        if(root.freq == 1){
            System.out.println(ans);
            return; 
        }
        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    

    public static void main(String[] args) {
        String words[] = { "zebra", "dog", "duck", "dove" };
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        root.freq = -1;
        findPrefix(root, "");
    }
    
}
