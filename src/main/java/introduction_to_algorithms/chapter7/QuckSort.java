package introduction_to_algorithms.chapter7;

/**
 * Created by yuanzhuo on 2017/2/22.
 */
public class QuckSort {

    /**
     * 快速排序算法
     * @param a 待排数组
     * @param p 待排数组的起始下标
     * @param q 待排数组的终止下标
     */
    public static void quckSort(int[] a,int p, int q){
        if (p >= q)
            return;
        int mid = partition(a,p,q);
        quckSort(a,p,mid-1);
        quckSort(a,mid+1,q);
    }
    /**
     * 快速排序的一次划分
     * @param a
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] a, int p, int r){
        int mid = a[r];
        int i = p-1, j=p;
        for (; j < r; j++) {
            if (a[j] < mid){
                swap(a,i+1,j);
                i++;
            }
        }
        swap(a, i + 1, r);
        return i+1;
    }

    /**
     * 交换数组中的两个元素
     * @param a
     * @param pa
     * @param pb
     */
    public static void swap(int[] a, int pa,int pb){
        int tmp = a[pa];
        a[pa] = a[pb];
        a[pb] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {3,5,9,1,4};
        quckSort(a, 0, 4);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
