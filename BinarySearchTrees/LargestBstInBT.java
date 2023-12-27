package BinarySearchTrees;

public class LargestBstInBT {
    
    public static class Node{
        int data;
        Node left;
        Node right;
        

        Node(int data){
            this.data = data;
        }
    }

    static class Info {

        boolean isBST;
        int size;
        int min;
        int max;
        
        Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
        
    }

    public static int maxBSt = 0;

    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftINfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftINfo.size + rightInfo.size + 1 ;
        int min = Math.min(root.data, Math.min(leftINfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftINfo.max, rightInfo.max));

        if(root.data <=leftINfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }

        if(leftINfo.isBST || rightInfo.isBST){
            maxBSt = Math.max(size, maxBSt);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        /*          50   ----> Level 1
         *         /   \
         *      30       60
         *     /  \       |   \
         *   5     20     45    70
         *                       |   \
         *                       65    80
         * 
         * 
         * 
         * 
         */




        Node root  = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);


         /*         
         *      
         *          60
         *         |   \
         *       45    70
         *              |   \
         *             65    80
         * 
         * Expected tree : Size = 5
         * 
         * 
         */


        largestBST(root);
        System.out.println(LargestBstInBT.maxBSt);
    }

}
