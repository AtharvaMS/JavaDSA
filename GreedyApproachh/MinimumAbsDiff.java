package GreedyApproachh;

import java.util.Arrays;

public class MinimumAbsDiff {


    // Given two arrays of equa length n. Pair each element of Array A to array b such that sum of absolute difference between pairs in minimum.

    public static void main(String[] args) {
        int A[] = {2,5,7,4,9,3};
        int B[] = {14,16,17,12,11,10};

        Arrays.sort(A);
        Arrays.sort(B);
        int sum =0;
        for( int i =0; i<A.length;i++){
            sum += Math.abs(A[i] - B[i]);
        }


        System.out.println(sum);
    }
    
}
