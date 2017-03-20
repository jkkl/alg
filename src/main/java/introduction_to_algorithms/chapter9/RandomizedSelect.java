package introduction_to_algorithms.chapter9;

/**
 * Created by yuanzhuo on 2017/3/20.
 * 利用快速排序选择，序列中的第i小元素
 */
public class RandomizedSelect {

    public static void swap(int A[], int a, int b){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    /**
     * 将数组按划分位置划分为两部分
     * @param A
     * @param p
     * @param r
     * @return 划分位置
     */
    public static int randomPartition(int[] A, int p, int r){
        if (p == r)
            return r;
        int tmp = A[r];
        int i = p - 1;
        int j = p;
        for (; j < r; j++) {
            if (A[j] < tmp){
                i++;
                swap(A,i,j);
            }
        }
        int mid = i + 1;
        swap(A,mid,r);
        System.out.println(mid);
        return mid;
    }

    /**
     * 选择数组中第i小的元素
     * @param A
     * @param p
     * @param r
     * @param i
     */
    public static int randomSelect(int A[],int p, int r, int i){
        if (p == r)
            return A[p];
        int q = randomPartition(A,p,r);
        int k = q - p + 1;
        if (k == i)
            return A[q];
        else if (k > i){
            return randomSelect(A,p,q-1,i);
        }else{
            return randomSelect(A,q+1,r,i-k);
        }

    }

    public static void main(String[] args) {
        int A[] = {6,7,9,3,2,8,5,10,30,20,1};
        //System.out.println(randomPartition(A,0,A.length-1));

        int a = randomSelect(A, 0, A.length-1 , 4);
        System.out.println(a);
    }


}
