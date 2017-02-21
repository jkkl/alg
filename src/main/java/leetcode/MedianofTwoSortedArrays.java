package leetcode;

/**
 * Created by yuanzhuo on 2017/1/10.
 */
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum_len = nums1.length + nums2.length;
        int idxa = 0, idxb = 0,cnt = 0 , small = -1,pre_small = -1;
        int mid_cnt = sum_len/2+1;
        while (cnt < mid_cnt ){
            pre_small = small;
            if (idxa < nums1.length && idxb < nums2.length && nums1[idxa] < nums2[idxb]){
                small = nums1[idxa++];
            }else if (idxb < nums2.length){
                small = nums2[idxb++];
            }else if (idxa < nums1.length){
                small = nums1[idxa++];
            }
            cnt++;
        }
        return sum_len%2 == 0 ? 1.0*(small+pre_small)/2 : small ;
    }

    public static void main(String args[]){

        int n1[] = {};
        int n2[] = {};
        System.out.println(findMedianSortedArrays(n1, n2));
    }
}
