package LeeCode;

/**
 * @program: cloud0801
 * @description: 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * @author: 刘洋
 * @date: 2021-04-14 14:41
 **/
public class NumIslands {
    public void infect(char[][] grid,int i,int j){
        if (i < 0 || i >= grid.length
        || j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return;
        }
        grid[i][j] = 2;
        infect(grid,i-1 , j);
        infect(grid,i+1 , j);
        infect(grid,i , j-1);
        infect(grid,i , j+1);
    }
    public int numIslands(char[][] grid){
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    infect(grid,i,j);
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        char[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        int numIslands = new NumIslands().numIslands(grid);
        System.out.println(numIslands);
    }
}
