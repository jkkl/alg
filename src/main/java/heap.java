import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yuanzhuo on 2017/1/13.
 */
public class heap<T extends Comparable<? super T>> {
    private Class<T> type;
    /**交换数组中的两个指定元素
     * @param arr
     * @param posA
     * @param posB
     */
    public void swap(ArrayList<T> arr, int posA, int posB){
        T tmp = arr.get(posA);
        arr.set(posA,arr.get(posB));
        arr.set(posB,tmp);
    }

    /**
     * 维护堆的性质
     * @param heap
     * @param pos
     */
    public void modifyHeap(ArrayList<T> heap,int heap_size, int pos){
        int len = heap_size;
        if (pos >= len || pos < 0) {
            System.out.println("pos out of rang");
            return;
        }
        int p = pos;
        while (pos*2 < len){
            int lchild = pos*2;
            int rchild = lchild+1;
            if (heap.get(pos).compareTo(heap.get(lchild)) > 0)
                p = lchild;
            if (rchild<len && heap.get(p).compareTo(heap.get(rchild)) > 0)
                p = rchild;
            if (p != pos){
                swap(heap,p,pos);
                pos = p;
            }else {
                break;
            }
        }
    }

    /**
     * 创建堆
     * @param heap
     */
    public void createHeap(ArrayList<T> heap){
        int len = heap.size();
        if (len < 2)
            return;
        for (int i = len-1; i > 0; i--){
            modifyHeap(heap,len,i);
        }
    }

    /**
     * 堆排序算法：通过构建小顶堆，将原数组由大至小排序
     * @param heap 待排数组
     * @return 由大到小排序的原数组
     */
    public ArrayList<T> heap_sort(ArrayList<T> heap){
        if (heap.size() < 2)
            return heap;
        int len = heap.size();
        createHeap(heap);
        for (int i = len-1; i > 0; i--){
            swap(heap,i,1);
            modifyHeap(heap, i, 1);
        }
        return heap;
    }

    /**
     * 通过构建小顶堆，输出数组前k大的元素
     * @param in_arr    原数组
     * @param k         输出元素个数
     * @return          返回topk新数组
     */

    public ArrayList<T> topk(ArrayList<T> in_arr,int k){
        //T topk[] = (T[])Array.newInstance(type,k);
        ArrayList<T> topk = new ArrayList<T>();
        topk.add(0,null);
        for (int i =0; i<k;i++){
            topk.add(in_arr.get(i));
        }
        createHeap(topk);
        for (int i = k; i<in_arr.size();i++){
            if (in_arr.get(i).compareTo(topk.get(1)) > 0){
                topk.set(1,in_arr.get(i));
                modifyHeap(topk,topk.size(),1);
            }
        }
        return topk;
    }

    public static void main(String args[]){
        Random rd = new Random();
        ArrayList<kv_compare> kv = new ArrayList<kv_compare>();
        for (int i = 0; i < 10; i++){
            kv.add(new kv_compare("a"+i, rd.nextDouble()));
            System.out.println(kv.get(i).getTag() + " " + kv.get(i).getWeight());
        }
        heap<kv_compare> kv_heap = new heap<kv_compare>();
        ArrayList<kv_compare> kv_top = kv_heap.topk(kv,3);
        kv_heap.heap_sort(kv_top);
        for (int i = 1; i< kv_top.size();i++){
            System.out.println(kv_top.get(i).getTag() + " " + kv_top.get(i).getWeight());
        }
    }

}


