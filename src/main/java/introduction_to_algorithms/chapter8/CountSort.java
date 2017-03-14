package introduction_to_algorithms.chapter8;

/**
 * Created by yuanzhuo on 2017/3/14.
 * 计数排序，用元素值作为下标，统计每一元素之前的元素个数，即为比该元素小的元素数，即为该元素在有序数组中的位置
 */
public class CountSort {

    public static void countingSort(int[] A,int[] B, int K){
        int c[] = new int[K];
        for (int i = 0; i < A.length; i++) {
            c[A[i]] += 1;
        }
        for (int i = 1; i < K; i++) {
            c[i] += c[i-1];
        }
        for (int i = 0; i < A.length; i++) {
            B[c[A[i]]-1] = A[i];
            c[A[i]] -= 1;
        }
    }

    public static void main(String[] args) {
        int A[] = {1,6,9,5,3,2,4};
        int B[] = new int[A.length];
        countingSort(A,B,10);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }
}
