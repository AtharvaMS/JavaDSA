package BinarySearchTrees;

import java.util.ArrayList;



public class BST {
    
    public static class Node{
        int data;
        Node left;
        Node right;
        

        Node(int data){
            this.data = data;
        }
    }
    
    public static Node insert(Node root, int val){
        if(root == null){
            return root = new Node(val);
        }


        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean searchBST(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data<key){
            return searchBST(root.right, key);
        }else{
            return searchBST(root.left, key);
        }

    }

    

    public static Node deleteNode(Node root, int val){
        if(root.data < val){
            root.right = deleteNode(root.right, val);
        }else if(root.data> val){
            root.left = deleteNode(root.left, val);

        }else{
            //case1: no node(leaf nodes)
            if(root.left == null && root.right == null){
                return null;
            }

            // case 2: nodes with single node at end
            if(root.left == null){
                return root.right;
            }else if(root.right == null)
            {
                return root.left;
            }

            //case 3: nodes having 2 nodes.
            Node inorderSuccessor = findInorderSuccessor(root.right);
            root.data =  inorderSuccessor.data;
            root.right = deleteNode(root.right, inorderSuccessor.data);


        }

        return root;
        
    }

    public static Node findInorderSuccessor(Node root) {
        while(root.left != null){
            root = root.left;
        }
        return root;
    }


    public static void printInRange(Node root, int val1, int val2) {
        if(root == null){
            return;
        }
        if(root.data >= val1 && root.data <= val2){
            printInRange(root.left, val1, val2);
            System.out.print(root.data +" ");
            printInRange(root.right, val1, val2);
        }else if(root.data < val1 ){
            printInRange(root.right, val1, val2);
        }else{
            printInRange(root.left, val1, val2);
        }
    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.data);
        if(root.left == null && root.right == null){
            printArrayList(list);
        }
        printRootToLeaf(root.left, list);
        printRootToLeaf(root.right, list);
        list.remove(list.size()-1);

    }

    // One more appraoch: Check for inorder traversal. If it is strictly increasing then it is a valid BST.
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        else if( max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }


    public static Node mirrorImage(Node root){
        if(root == null){
            return null;
        }

        root.right = mirrorImage(root.left);
        root.left = mirrorImage(root.right);

        return root;

    }
    private static void printArrayList(ArrayList<Integer> list) {
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");

        }
        System.out.println();
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

        // int arr1[] = {5,1,3,4,2,7};
        // int arr[] = {6,1,2,7,8,9,3,10,4,5};
        int arr2[] = {1,1,1};
        Node root = null;
        for(int i=0;i<arr2.length;i++){
            root = insert(root, arr2[i]);
        }

        // inorder(root);

        // System.err.println(searchBST(root, 11));
        // deleteNode(root, 8);
        inorder(root);
        
        // printInRange(root, 2, 6);
        // printRootToLeaf(root, new ArrayList<>());
        System.out.println(isValidBST(root, null, null));


    }
    
}
