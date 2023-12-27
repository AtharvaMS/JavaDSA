package TreesAndAlgo;



import java.util.*;






public class LowestCommonAnsistor {

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


    public static Node lowestCommonAnsistor(Node root, int n1, int n2){
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();

        getPath(root, n1, list1);
        getPath(root, n2, list2);
        
        int i =0;

        for( ; i<list1.size() && i < list2.size(); i++){
            if(list1.get(i) != list2.get(i)){
                break;
            }
        }
             
        Node lca = list1.get(i-1);
        return lca;
    }


    


    private static boolean getPath(Node root, int n, ArrayList<Node> path) {

        if(root == null){
            return false;
        }
        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean leftfound = getPath(root.left, n, path);
        boolean rightfound = getPath(root.right, n, path);

        if(leftfound || rightfound){
            return true;
        }
        

        path.remove(path.size() - 1);
        return false;


    }

    public static Node lcaApproach2(Node root, int n1, int n2){

        if(root == null || root.data == n1 || root.data == n2){
            return root;

        }

        Node leftBranch = lcaApproach2(root.left, n1, n2);
        Node rightBranch = lcaApproach2(root.right, n1, n2);

        if(leftBranch == null){
            return rightBranch;
        }

        if(rightBranch == null){
            return leftBranch;
        }

        return root;

    }

    public static int kAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftBranch = kAncestor(root.left, n, k);
        int rightBranch = kAncestor(root.right, n, k);

        int max = Math.max(leftBranch, rightBranch);
        if(max + 1 == k){
            System.out.println(root.data);
        }

        return max +1;


    }

    public static int distance(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int distanceLeft = distance(root.left, n);
        int rightDistance = distance(root.right, n);

        if(distanceLeft == -1 && rightDistance == -1){
            return -1;
        }else if(distanceLeft == -1){
            return rightDistance +1;
        }else{
            return distanceLeft + 1;
        }
    }

    public static int distanceBetweenNodes(Node root, int n1, int n2){
        //calculate lca
        Node lca = lcaApproach2(root, n1, n2);
        int dist1 = distance(lca, n1);
        int dist2 = distance(lca, n2);

        return dist1 + dist2;

    }

    public static int transformSumTree(Node root){
        if(root == null){
            return 0;
        }

        int left = transformSumTree(root.left);
        int right = transformSumTree(root.right);

        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = left + right + newLeft + newRight;

        return data;
    }

    public static void printTree(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
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

        // System.out.println(lowestCommonAnsistor(root, 4, 5).data);
        // System.out.println(lcaApproach2(root, 5,6).data);
        // System.out.println(distanceBetweenNodes(root, 4, 3));
        // kAncestor(root, 6, 2);
        printTree(root);
        System.out.println();
        transformSumTree(root);
        printTree(root);
        
        
    }
    
}
