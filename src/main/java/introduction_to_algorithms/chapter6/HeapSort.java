package introduction_to_algorithms.chapter6;

/**
 * Created by yuanzhuo on 2017/3/9.
 * 1 注意数组的长度和堆的大小的区别
 * 2 若使用 lchild = 2*i; rchild = 2*i+1 则数组下标从1开始，0元素不参与排序
 */
public class HeapSort {

    public static void swap(int A[],int a, int b){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    /**
     * 用于维护最大堆中，某元素满足最大堆性质，假设i节点的左右子树都是最大堆
     * @param A 待维护的堆
     * @param i 待维护的堆元素
     */
     public static void maxHeapify(int[] A, int i, int heap_size){
         if (i <= 0)
             return;

         while (2*i < heap_size){
             int max_index = i;
             int l = 2*i;
             int r = 2*i+1;
             if (A[i] < A[l])
                 max_index = l;
             if (r < heap_size && A[max_index] < A[r])
                 max_index = r;
             if (max_index == i)
                 return;
             swap(A,i,max_index);
             i = max_index;
         }
     }

    /**
     * 创建一个最大堆：
     *  自低向上的调用maxHeapify()
     * @param A
     */
    public static void creatMaxHeap(int[] A){
        if (A.length < 2)
            return;
        for (int i = A.length-1; i > 0 ; i--) {
            maxHeapify(A,i,A.length);
        }
    }

    /**
     * 堆排序
     * 1、构建最大堆
     * 2、将堆顶元素与最后一个元素交换
     * 3、维护堆的性质
     * 4、重复 2、3 知道堆中的有效元素数为1
     * @param A
     */
    public static void heapSort(int[] A){
        creatMaxHeap(A);
        for (int i = A.length-1; i > 1; i--){
            swap(A,1,i);
            maxHeapify(A,1,i);
        }
    }

    public static void main(String[] args) {
        int A[] = {0,4,1,8,2,3,9};
        //creatMaxHeap(A);
        heapSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

}
