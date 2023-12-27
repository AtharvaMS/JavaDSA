package TreesAndAlgo;

import java.util.*;


public class ViewsOfTree {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }


    public static class Info{
        Node node;
        int horizontalDistance;

        Info(Node node, int hd){
            this.node = node;
            this.horizontalDistance = hd;
        }
    }


    public static void topView(Node root){
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();

        int min =0, max =0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{

                if(!map.containsKey(curr.horizontalDistance)){
                    map.put(curr.horizontalDistance, curr.node);
                }
    
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.horizontalDistance-1));
                    min = Math.min(min, curr.horizontalDistance-1);
                }
    
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.horizontalDistance+1));
                    max = Math.max(max, curr.horizontalDistance+1);
                }
            }


            
        }
        
        for(int i = min; i<= max; i++){
            System.out.print(map.get(i).data + " ");
        }
    }
    
    public static void main(String[] args) {

         /*
            *          1
            *        /    \
            *      2       3
            *   /   \      |  \ 
            *   4    5     6   7
            *  /           |   
            * 8            9                               
            *              |
            *              10 
            */
    
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(9);
        root.right.left.left.left = new Node(10); 


        topView(root);
    }














    
}
