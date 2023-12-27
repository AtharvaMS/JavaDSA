package TreesAndAlgo;

import java.util.*;



public class Trees {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }

    }

    static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);

    }

    static void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");

    }

    public static void levelOrderTraversal(Node root){

        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currentNode = q.remove();
            if(currentNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else
                {
                    q.add(null);
                }
            }
            else{
                System.out.print(currentNode.data + " ");
                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
        }


    }

    public static int heightOfTree(Node root){

        if(root == null){
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int numberOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodesCount = numberOfNodes(root.left);
        int rightNodesCount = numberOfNodes(root.right);

        return leftNodesCount + rightNodesCount + 1;
    }


    public static int sumOfAllNodes(Node root){
        if(root == null){
            return 0;
        }

        int sumOfLeftNodes = sumOfAllNodes(root.left);
        int sumOfRightNodes = sumOfAllNodes(root.right);

        return sumOfLeftNodes + sumOfRightNodes+ root.data;
    }

    public static int diameter(Node root){//O(n^2)
        if(root == null){
            return 0;
        }

        int leftdim = diameter(root.left);
        int heightleft = heightOfTree(root.left);
        int rightdim = diameter(root.right);
        int rightHeight = heightOfTree(root.right);

        int selfDiameter = heightleft + rightHeight + 1;

        return Math.max(selfDiameter, Math.max(leftdim, rightdim));
    }

    public static class Info {
        int diam;
        int height;

        Info(int diam, int height){
            this.diam = diam;
            this.height = height; 
        }
    
        
    }


    // Linear Time Diameter of Tree  -> O(N)
     public static Info diameterUsingInfoObject(Node root){
        if(root == null){
            return new Info(0,0);
        }


        Info leftNodeInfo = diameterUsingInfoObject(root.left);
        Info rightNodeInfo = diameterUsingInfoObject(root.right);

        int diameter = Math.max(leftNodeInfo.diam, Math.max(rightNodeInfo.diam, leftNodeInfo.height + rightNodeInfo.height + 1));
        int height = Math.max(leftNodeInfo.height, rightNodeInfo.height) + 1;

        return new Info(diameter, height);

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


        System.out.println("Pre Order Traversal: ");
        preOrderTraversal(root);
        System.out.println("\nIn Order Traversal: ");
        inOrderTraversal(root);
        System.out.println("\nPost Order Traversal: ");
        postOrderTraversal(root);

        System.out.println("\nHeight of Tree: ");
        System.out.print(heightOfTree(root)); 

        levelOrderTraversal(root);

        System.out.println("Number of total Nodes in Tree: "+numberOfNodes(root));
        System.out.println(sumOfAllNodes(root));
        System.out.println(diameterUsingInfoObject(root).diam);
    }
    
}
