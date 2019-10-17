package Big_O.Big_O_2_faster;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr1 = {13, 56, 32, 4, 6, 9, 111};
        mergeSort(arr1);
        //merge(result, arr1, arr2);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(" " + arr1[i]);
        }
    }

    //divide
    public static void mergeSort(int[] a) {
        if (a.length > 1) {
            int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);
            mergeSort(left);  // kommer ikke videre herfra, før end left.length >= 1
            mergeSort(right);
            merge(a, left, right);

        }
    }

    //conquer
    public static void merge(int[] result, int[] left, int[] right) {
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (c2 >= right.length || (c1 < left.length && left[c1] <= right[c2])) { //take from left
                result[i] = left[c1];
                c1++;
            } else {
                result[i] = right[c2];  //take from right
                c2++;
            }
        }
    }
}