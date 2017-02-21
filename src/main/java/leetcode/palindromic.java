package leetcode;

/**
 * Created by yuanzhuo on 2017/1/20.
 * ������Ӵ�
 * �� dp[i][j]��ʾ���Ӵ�ij�Ƿ��ǻ��ģ�
 */

public class palindromic {
    public static String longetestPalindromic(String s){
        if (s.length()<=1){
            return s;
        }
        int len = s.length();
        int dp[][] = new int[len][len];

        dp[0][0] = 1;
        for (int i = 1; i < len; i++){
            dp[i][i] = 1;
            dp[i][i-1] = 1; //�����Ӵ�����Ϊ2ʱ���жϵڶ�������ʱʹ�ã�
        }
        int max_len= 1; //���ַ������ȴ���1ʱ�������Ӵ��ĳ�������Ϊ1
        int start_index = 0;
        for (int sublen = 2; sublen <= len; sublen++){//�Ӵ����ȣ������ӽṹ���Ե����Ϲ���
            for (int i = 0; i < len-sublen+1; i++){//�Ӵ���ʼλ��
                if (s.charAt(i) == s.charAt(i+sublen-1) && dp[i+1][i+sublen-2] == 1){//�Ƚϻ��Ĵ������ˣ������ڲ�������������ӽṹ��
                    dp[i][i+sublen-1] = 1;
                    max_len = sublen;
                    start_index = i;
                }
            }
        }
        return s.substring(start_index,start_index+max_len);
    }

    public static void main(String args[]){
        String s = "waabwswfd";
        System.out.print(longetestPalindromic(s));
    }


}
