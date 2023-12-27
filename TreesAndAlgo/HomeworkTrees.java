package TreesAndAlgo;



public class HomeworkTrees {

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

    public static void printTree(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static boolean univalent(Node root, int data){
        if(root == null){
            return true;
        }


        boolean left = univalent(root.left, data);
        boolean right = univalent(root.right, data);

        if(left == true  && right == true && root.data == data){
            return true;
        }

        return false;
    }

    public static Node mirrorTree(Node root){
        if( root == null){
            return root;
        }

        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    //Delete leaf nodes with values x
    static Node deleteLeaves(Node root, int x)
    {   if (root == null) return null;
        root.left = deleteLeaves(root.left, x);
        root.right = deleteLeaves(root.right, x);
        if (root.data == x && root.left == null && root.right == null) 
        {return null;}
        return root;
    }
    public static void main(String[] args) {

        // Node root = new Node(2);
        // root.left = new Node(2);
        // root.right = new Node(2);
        // root.left.right = new Node(5);
        // root.left.left = new Node(2);


        // System.out.println(univalent(root, 2));

        Node root = new Node(10);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(1);
        root.right.right = new Node(3);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(3);

        printTree(root);
        System.out.println();
        deleteLeaves(root, 3);
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

        //  Node root = new Node(1);
        //  root.left = new Node(2);
        //  root.right = new Node(3);
        //  root.left.left = new Node(4);
        //  root.left.right = new Node(5);
        //  root.right.left = new Node(6);
        //  root.right.right = new Node(7);
         
        //  mirrorTree(root);
         printTree(root);
        


        
    }
    
}
