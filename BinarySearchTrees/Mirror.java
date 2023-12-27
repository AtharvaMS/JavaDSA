package BinarySearchTrees;



public class Mirror {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public static Node mirrorBST(Node root){
        if(root == null){
            return null;
        }

        Node leftMirror = mirrorBST(root.left);
        Node rightMirror = mirrorBST(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }
    
    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+ "->");
        inorder(root.right);

    }

    public static void main(String[] args) {

        /*          8   ----> Level 1
         * 
         *      5       10
         * 
         *   3     6         11
         * 
         * 
         * 
         * 
         */

        Node root = new Node(8);
        root.left = new Node(5);
        root.left.right = new Node(6);
        root.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);

        inorder(root);
        System.out.println();
        mirrorBST(root);

        inorder(root);

    }
    
}
