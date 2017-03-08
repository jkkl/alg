package introduction_to_algorithms.chapter4;

/**
 * Created by yuanzhuo on 2017/3/8.
 */
public class MaxSubArray {

    /**
     * 返回跨越mid位置的最大子数组
     * @param A
     * @param low
     * @param mid
     * @param high
     */
    public static int findMaxCrossSubArr(int[] A, int low, int mid, int high){
        if (low == high){
            return A[mid];
        }
        int max_l = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=mid; i>=low; i--){
            sum += A[i];
            if (sum > max_l)
                max_l = sum;
        }
        int max_r = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid; i <= high ; i++) {
            sum += A[i];
            if (sum > max_r){
                max_r = sum;
            }
        }
        return  max_l+max_r-A[mid];

    }

    /**
     * 比较三个整数，输出最大值
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int compareMax(int a, int b, int c){
        int mid = 0;
        if (a > b)
            mid = a;
        else
            mid = b;
        if (mid > c)
            return mid;
        else
            return c;
    }

    /**
     * 计算最大子数组
     * @param A
     * @param low
     * @param high
     * @return
     */
    public static int maxSubArray(int[] A,int low, int high){
        if (high == low)
            return A[low];
        else {
            int mid = (low+high)/2;
            int l_sum = maxSubArray(A,low,mid);
            int r_sum = maxSubArray(A,mid+1,high);
            int m_sum = findMaxCrossSubArr(A,low,mid,high);
            return compareMax(l_sum,r_sum,m_sum);
        }

    }

    public static void main(String[] args) {
        int A[] = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        System.out.println(maxSubArray(A, 0, A.length - 1));
    }
}
