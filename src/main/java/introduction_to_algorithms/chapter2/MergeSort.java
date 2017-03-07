package introduction_to_algorithms.chapter2;

/**
 * Created by yuanzhuo on 2017/3/7.
 * 归并排序:
 * 难点：注意下标的传递、赋值操作。
 */
public class MergeSort {
    public static void merge(int[] A, int p, int q, int r){
        if (p==r)
            return;
        int l_len = q-p+1;
        int r_len = r-q;

        int l_arr[] = new int[l_len+1];
        int r_arr[] = new int[r_len+1];

        l_arr[l_len] = Integer.MAX_VALUE;
        r_arr[r_len] = Integer.MAX_VALUE;
        for (int i = 0; i < l_len; i++)
            l_arr[i] = A[p+i];
        for (int i = 0; i < r_len; i++)
            r_arr[i] = A[q+i+1];

        int a  = 0, b = 0;
        for (int i = p; i <= r; i++) {
            if (l_arr[a] < r_arr[b]){
                A[i] = l_arr[a];
                a++;
            }else {
                A[i] = r_arr[b];
                b++;
            }
        }
    }

    public static void mergeSort(int A[],int p, int r){
        if (p == r)
            return;
        else {
            int q = (p+r)/2;
            mergeSort(A,p,q);
            mergeSort(A,q+1,r);
            merge(A,p,q,r);
        }
    }

    public static void main(String[] args) {
        int A[] = {6,3};
        mergeSort(A,0,1);

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

}
