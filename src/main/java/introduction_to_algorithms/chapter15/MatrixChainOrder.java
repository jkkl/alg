package introduction_to_algorithms.chapter15;

/**
 * Created by yuanzhuo on 2017/3/2.
 * 矩阵连最优括号化方案
 *
 */
public class MatrixChainOrder {

    /**
     *
     * @param p 矩阵下标数组，由于相容的矩阵链的前一矩阵的列等于后一矩阵的行，所以 矩阵Ai的规模为： p[i-1]*p[i]
     *          初始化：m[i,i] = 0 ,m[i,j]:表示矩阵连Ai...Aj，标量乘法的最小的计算代价
     *          最优子结构 m[i,j] = m[i,k]+m[k+1,j]+p[i-1]*p[k]*p[j]
     */
    public static void matrixChainOrder(int[] p){
        int len = p.length;
        int m[][] = new int[len][len];
        int path[][] = new int[len][len];

        for (int i = 0; i < len; i++) {
            m[i][i] = 0;
        }

        for (int chainLen = 2; chainLen < len; chainLen++) {
            for (int i = 1; i < len - chainLen + 1; i++) {
                int j = i + chainLen - 1;
                int cos = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cos_k = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (cos > cos_k){
                        cos = cos_k;
                        path[i][j] = k;
                    }
                }
                m[i][j] = cos;
            }
        }
        System.out.println(m[1][len-1]);

        //回溯路径
        printOrder(path,1,len-1);



    }


    public static void printOrder(int[][] path,int i,int j){
        if (i == j){
            System.out.print("A" + i);
        }else{
            System.out.print("(");
            printOrder(path, i, path[i][j]);
            printOrder(path, path[i][j] + 1, j);
            System.out.print(")");
        }

    }

    public static void main(String[] args) {
        int[] p = {30,35,15,5,10,20,25};

        matrixChainOrder(p);


    }



}
