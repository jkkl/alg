package leetcode;

/**
 * Created by yuanzhuo on 2017/2/23.
 *
 * Example1: x = 123, return 321
 Example2: x = -123, return -321

 注意：
 1、数据溢出
 2、原数以0结尾
 */
public class ReverseInteger {

    public static int reverseInt(int src){
        long result = 0 ;
        int tag = 1;
        if (src < 0) {
            src *= -1;
            tag *= -1;
        }
        while (src > 0){
            result = result*10  + src%10;
            src /= 10;
        }
        if (result > Integer.MAX_VALUE){
            result = 0;
        }
        return (int)result*tag;
    }

    public static void main(String[] args) {
        System.out.println(reverseInt(1534236469));
        System.out.println(964632435*10+1);
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MAX_VALUE+1);

    }
}
