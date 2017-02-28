package other;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by yuanzhuo on 2017/2/27.
 * 斐波那契数列，
 */
public class Fibonacci {

    /**
     * fibonacci 尾递归
     *  1、尾递归：是指递归函数的结尾，直接返回
     * @param n
     * @param pre
     * @param next
     * @return
     */
    public static int fibonacciTailRecursion(int n, int pre, int next){

        if (n == 0)
            return pre;
        else {
            if (pre != 0){
                System.out.print(pre);
            }
            return fibonacciTailRecursion(n - 1, next, pre + next);
        }
    }

    public static int fibonacciRecursion(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fibonacciRecursion(n-1)+ fibonacciRecursion(n-2);
    }

    public static int fibonacciIteration(int n ){
        if (n < 2)
            return n;
        int  pre = 0;
        int  next = 1;
        int result = 1;
        System.out.println(result);
        for (int i = 2; i <= n; i++) {
            result = pre + next;
            System.out.println(result);
            pre = next;
            next = result;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        //System.out.println(fibonacciTailRecursion(n,0,1));
        System.out.println(fibonacciIteration(n));
        //System.out.println(fibonacciRecursion(n));
    }
}
