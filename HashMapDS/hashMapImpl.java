package HashMapDS;

import java.util.*;



public class hashMapImpl {

    static class HashMap<K, V>
    {
        private class Node{
            K key;
            V value;
    
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }

        }

        private int n; // total nodes = n
        private int N; // size of parent LL
        private LinkedList<Node> buckets[]; // N = Bucket Length

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i < 4; i++){
                this.buckets[i] = new LinkedList();
            }
        }

        // all methods should be implemented in O(1) time complexity
        public void put(K key, V value){ //O(lambda) -> O(1)
            int bi = hashfunction(key); // 0 -3
            int di = SearchInLL(key, bi);// valid or -1
            
            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            //check for rehashing
            double lambda = (double)n/N;
            if (lambda>2.0) {
                rehash();
                
            }
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;

            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>(); // initialize LL
            }

            // nodes -> add in bucket
            for(int i = 0; i<oldBucket.length;i++){
                LinkedList<Node> ll =  oldBucket[i];
                for(int j =0; j<ll.size();j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int dataIdx = 0;

            for(int i=0; i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return dataIdx;
                }
                dataIdx++;
            }
            return -1;
        }

        private int hashfunction(K key) {
            int hc = key.hashCode(); // return -1234567890 to 1234567890. but we need value between 0 to 4(Size of LL)
            return Math.abs(hc) % N;
        }


        public boolean containsKey(K key){
            int bi = hashfunction(key); // 0 - 3
            int di = SearchInLL(key, bi);// valid or -1
            
            if(di != -1){ // valid value
                return true;
                
            }else{
                return false;
            }
        }


        public V get(K key){ //O(lambda) -> O(1)
            int bi = hashfunction(key); // 0 - 3
            int di = SearchInLL(key, bi);// valid or -1
            
            if(di != -1){ // valid value
                Node node = buckets[bi].get(di);
                return node.value;
                
            }else{
                return null;
            }
        }

        public V remove(K key){ //O(lambda) -> O(1)
            int bi = hashfunction(key); // 0 - 3
            int di = SearchInLL(key, bi);// valid or -1
            
            if(di != -1){ // valid value -> remove
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
                
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }

    }   


    public static void main(String[] args) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 500);
        hm.put("China", 45);
        hm.put("Nepal", 100);
        hm.put("US", 200);

        ArrayList<String> keys = hm.keySet();
        hm.remove("US");

        for(String key : keys){
            System.out.println(key + "->" + hm.get(key));

        }
    }
    





}
