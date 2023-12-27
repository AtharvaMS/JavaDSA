package TreesAndAlgo;

import java.util.LinkedList;
import java.util.Queue;

import Stack.pusAtBottom;

public class KthLevelNodes {

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


    public static void KthLevel(Node root, int level, int targetLevel){

        if(root == null){
            return;
        }

        if(level == targetLevel){
            System.out.print(root.data + " ");
        }

        KthLevel(root.left, level+1, targetLevel);
        KthLevel(root.right, level+1, targetLevel);


    }

    public static void iterativeKthLevel(Node root, int k){

        Queue<Node> q = new LinkedList<>();
        int level = 1;

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node current = q.remove();
            if(current == null){
                if(q.isEmpty()){
                    break;
                }else{
                    level++;
                    q.add(null);
                }
            }else{
                if( level == k){
                    System.out.print(current.data + " ");
                }
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }

            }
            
        }

    }


    




    

    public static void main(String[] args) {
        //Print Kth level of tree.


        /*          1   ----> Level 1
         * 
         *      2       3
         * 
         *   4    5   6    7
         * 
         * 
         * 
         * 
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        

        // KthLevel(root, 1, 3);
        iterativeKthLevel(root, 3);
        
    }
    
}
