package a_shuzu;

/**
 * 旋螺矩阵：
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 1    2  3  4
 * 12  13 14  5
 * 11  16 15  6
 * 10   9  8  7
 */
public class xuanluo_matrix {
    public static void main(String[] args) {
        int n = 5;
        int newnums[][] = nums(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(newnums[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }

    }

    public static int[][] nums(int n){
        int k = 0; //代表行
        int m = n-1; //代表列
        int shu = 1;
        int[][] nums = new int[n][n];
        while (k<=(n/2)){
             {  //都遵循左闭右开
                for (int i = k; i < n - k - 1; i++, shu++) {//顶部圈
                    nums[k][i] = shu;
                }
                for (int j = k; j < n - k - 1; j++, shu++) {//右边圈
                    nums[j][m] = shu;
                }
                for (int i = n - k - 1; i > k; i--, shu++) {//底部圈
                    nums[n - k - 1][i] = shu;
                }
                for (int j = n - k - 1; j > k; j--, shu++) {//左边圈
                    nums[j][n - m - 1] = shu;
                }
                k++;
                m--;
            }
        }
        if(n%2 == 1){
            nums[n/2][n/2] = shu;
        }
        return nums;
    }
//    public static int[][] nums2(int n){
//        int loop = 1;//第几圈
//        int startx = 0, starty = 0;//从哪个索引开始
//        int offset = 1;
//        int count = 1;//要填的数
//        int i = 0, j = 0;//行、列
//
//    }
    //答案
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;  // 每一圈的起始点
        int offset = 1;
        int count = 1;  // 矩阵中需要填写的数字
        int loop = 1; // 记录当前的圈数
        int i, j; // j 代表列, i 代表行;

        while (loop <= n / 2) {

            // 顶部
            // 左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            // 右列
            // 左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            // 左列
            // 左闭右开，所以判断循环结束时， i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            nums[startX][startY] = count;
        }
        return nums;
    }

}
