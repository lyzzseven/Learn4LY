package LeeCode;

/**
 * 编写一个高效的算法来搜索m x n矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length-1;//列
        int row = 0;//行
        while (col >= 0 && row <= matrix.length-1){
            if (matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] > target){
                col --;
            }else if (matrix[row][col] < target){
                row ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 20;
        System.out.println(searchMatrix(matrix,target));
    }
}
