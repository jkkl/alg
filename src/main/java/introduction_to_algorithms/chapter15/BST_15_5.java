package introduction_to_algorithms.chapter15;

/**
 * Created by yuanzhuo on 2017/2/17.
 * 构造最优二叉查找树
 */
public class BST_15_5 {
    /**
     * 最优二叉查找树
     * @param p 关键字的权重
     * @param q 伪关键字的权重
     * @param n 关键字个数
     */
    public static void BestSearchTree(double[] p, double[] q, int n){
        double[][] e = new double[n+1][n+1];    //子树 i-j ,的最优查找代价
        double[][] w = new double[n+1][n+1];    //子树 i-j 的代价和
        double[][] root = new double[n][n];     //子树 i-j 的最优二叉查找树的根节点

        for (int i=1; i<n+1; i++){
            e[i][i-1] = q[i-1];
            w[i][i-1] = q[i-1];
        }

        for (int len = 1; len <= n ; len++){
            for (int i = 1; i < n-len+1; i++){
                int j = i+len-1;
                e[i][j] = Double.MAX_VALUE;
                w[i][j] = w[i][j-1]+p[j]+q[j];
                for (int r = i; r <= j; r++){
                    double e_tmp = e[i][r-1]+e[r+1][j]+w[i][j];
                    if (e_tmp < e[i][j]) {
                        e[i][j] = e_tmp;
                        root[i][j] = r;
                    }
                }
            }
        }
    }
}
