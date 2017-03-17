package introduction_to_algorithms.chapter9;

/**
 * Created by yuanzhuo on 2017/3/17.
 */
public class minmax {

    public static void getMinMax(int A[]){
        if (A.length < 2)
            return;
        int min;
        int max;
        int start = 1;

        if (A.length % 2 == 0){
            if (A[0] > A[1]){
                min = A[1];
                max = A[0];
            }else {
                min = A[0];
                max = A[1];
            }
            start = 2;
        }else{
            min = max = A[0];
        }


        for (int i = start; i < A.length; i+= 2) {
            int little,bigger;
            if (A[i] > A[i+1]){
                little = A[i+1];
                bigger = A[i];
            }else {
                little = A[i];
                bigger = A[i+1];
            }
            if (min > little)
                min = little;
            if (max < bigger)
                max = bigger;
        }
        System.out.println(min);
        System.out.println(max);

    }

    public static void main(String[] args) {
        int A[] = {6,9,1,3,7,2};
        getMinMax(A);
    }
}
