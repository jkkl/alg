package introduction_to_algorithms.chapter6;

/**
 * Created by yuanzhuo on 2017/3/10.
 * 优先级队列
 */
public class PriorityQueue {

    public static int heap_size = 0;

    //维护节点i的堆性质
    public static void maxHeapify(int A[],int i){
        if (i < 1)
            return;
        while (2*i <= heap_size){
            int lchild = 2*i;
            int rchild = 2*i +1;
            int max_index = i;
            if (A[lchild] > A[i])
                max_index = lchild;
            if (rchild <= heap_size && A[rchild] > A[max_index])
                max_index = rchild;
            if (max_index == i)
                return;
            swap(A,max_index,i);
            i = max_index;
        }
    }

    //swap
    public static void swap(int A[], int a, int b){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    //返回最大元素
    public static int heapMaximum(int A[]){
        return A[1];
    }

    //返回并删除最大元素
    public static int heapExtractMax(int A[]){
        if (heap_size < 1)
            return 0;
        int max = A[1];
        swap(A,1,heap_size);
        heap_size -= 1;
        maxHeapify(A,1);
        return max;
    }
    //将节点i的关键字增加到key
    public static void heapIncreaseKey(int A[],int i, int key){
        if (i < 0 || i > heap_size || key < A[i])
            return;
        A[i] = key;
        int parent = i/2;
        while (parent > 0 && A[parent] < A[i]){
            swap(A,parent,i);
            i = parent;
            parent /= 2;
        }
    }

    //插入新元素
    public static void maxHeapInsert(int A[], int key){
        heap_size += 1;
        if (heap_size >= A.length)
            return;
        A[heap_size] =  Integer.MIN_VALUE;
        heapIncreaseKey(A,heap_size,key);
    }

    public static void createMaxHeap(int A[]){
        heap_size = A.length-1;
        if (heap_size < 1)
            return;
        for (int i = heap_size/2; i > 0; i--)
            maxHeapify(A,i);

    }

    public static void main(String[] args) {
        int A[] = {0,2,9,8,4,7};
        //heap_size = A.length-1;
        createMaxHeap(A);
        for (int i = 1; i <= heap_size; i++) {
            System.out.print(A[i]);
        }

        System.out.println("");
        heapExtractMax(A);
        for (int i = 1; i <= heap_size; i++) {
            System.out.print(A[i]);
        }
        System.out.println("");
        maxHeapInsert(A, 50);
        for (int i = 1; i <= heap_size; i++) {
            System.out.print(A[i]);
        }

    }
}
