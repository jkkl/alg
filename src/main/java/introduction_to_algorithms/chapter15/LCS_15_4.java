package introduction_to_algorithms.chapter15;

/**
 * Created by yuanzhuo on 2017/2/16.
 * 最长公共子序列 动态规划
 */
public class LCS_15_4 {
    public static int LCS(String A, String B){
        if (A.length() == 0 || B.length() == 0)
            return 0;
        int ALen = A.length();
        int BLen = B.length();
        int c[][] = new int[ALen+1][BLen+1];//记录LCS的长度，自底向上
        int path[][] = new int[ALen][BLen]; //记录LCSd的路径,值为标记来的方向，3：(i-1,j-1)+1; 2:(i-1,j)+1; 1:(i,j-1)+1

        for (int i = 0; i<ALen;i++){
            for (int j = 0; j<BLen;j++){
                c[i][j] = 0;
            }
        }

        int len = 0;
        int tag = 0;
        for (int i = 1; i <= ALen; i++){
            for (int j = 1; j <= BLen; j++){
                if (A.charAt(i-1) == B.charAt(j-1)){//最优子结构，自底向上构建
                    len = c[i-1][j-1]+1;
                    tag = 3;
                }else if (c[i-1][j] > c[i][j-1]){
                    len = c[i-1][j];
                    tag = 2;
                }else {
                    len = c[i][j-1];
                    tag = 1;
                }
                c[i][j] = len;
                path[i-1][j-1] = tag;
            }
        }

        for (int i=0; i<ALen; i++){
            for (int j=0; j<BLen; j++){
                System.out.print(path[i][j]);
            }
            System.out.print("\n");
        }

        printPath(path,A,ALen-1,BLen-1);

        return c[ALen][BLen];
    }

    //根据路径标记打印LCS
    public static void printPath(int[][] path, String a, int i, int j){
        if (i < 0 || j < 0)
            return;
        int tag = path[i][j];
        if (tag == 3){
            printPath(path,a,i-1,j-1);
            System.out.print(a.charAt(i));
        }else if (tag == 2){
            printPath(path,a,i-1,j);
        }else {
            printPath(path,a,i,j-1);
        }
    }

    public static void main(String args[]){
        String a = "abcdegp";
        String b = "bdep";
        System.out.println(LCS(a,b));
    }
}
