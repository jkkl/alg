import java.util.Vector;

/**
 * Created by yuanzhuo on 2017/1/13.
 */



public class topk {
    /**
     *
     * @param a
     * @param b
     */
    public static void swap(Integer a, Integer b){
        int tmp = a;
        b = tmp;
        a = b;
    }

    /**
     * ά���ѵ�����
     * @param heap
     * @param pos
     */
    public static void modifyHeap(int[] heap,int heap_size, int pos){
        int len = heap_size;
        if (pos >= len || pos < 0) {
            System.out.println("pos out of rang");
            return;
        }
        int p = pos;
        while (pos*2 < len){
            int lchild = pos*2;
            int rchild = lchild+1;
            if (heap[pos] > heap[lchild])
                p = lchild;
            if (rchild<len && heap[p] > heap[rchild])
                p = rchild;
            if (p != pos){
                int tmp = heap[pos];
                heap[pos] = heap[p];
                heap[p] = tmp;
                pos = p;
            }else {
                break;
            }
        }
    }

    /**
     * ������
     * @param heap
     */
    public static void createHeap(int[] heap){
        int len = heap.length;
        if (len < 2)
            return;
        for (int i = len-1; i > 0; i--){
            modifyHeap(heap,len,i);
        }

    }

    /**
     * �������㷨��ͨ������С���ѣ���ԭ�����ɴ���С����
     * @param heap ��������
     * @return �ɴ�С�����ԭ����
     */
    public static int[] heap_sort(int[] heap){
        if (heap.length < 2)
            return heap;

        int len = heap.length;
        createHeap(heap);
        for (int i = len-1; i > 0; i--){
            int tmp = heap[1];
            heap[1] = heap[i];
            heap[i] = tmp;
            modifyHeap(heap,i,1);
        }
        return heap;
    }


    /**
     * ͨ������С���ѣ��������ǰk���Ԫ��
     * @param in_arr    ԭ����
     * @param k         ���Ԫ�ظ���
     * @return          ����topk������
     */
    public static int[] topk( int[] in_arr,int k){
        //Vector<Double> result = new Vector<Double>();
        int topk[] = new int[k+1];
        for (int i =0; i<k;i++){
            topk[i+1] = in_arr[i];
        }
        createHeap(topk);

        for (int i = k; i<in_arr.length;i++){
            if (in_arr[i] > topk[1]){
                topk[1] = in_arr[i];
                modifyHeap(topk,topk.length,1);
            }
        }
        return topk;
    }

    public static void main(String args[]){
        int a[] = {0,1,5,7,9,3,6,2,12};

        int topk[] = topk(a,3);
        for (int i : topk){
            System.out.print(i +"\n");
        }
        heap_sort(topk);
        for (int i : topk){
            System.out.print(i +"\n");
        }

    }


}


