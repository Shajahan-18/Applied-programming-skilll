class Solution {

    int[][] dir = {
        {1,0},{-1,0},{0,1},{0,-1}
    };

    public int numIslands(char[][] grid) {

        int count = 0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {

                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(char[][] grid, int r, int c) {

        if(r<0 || c<0 ||
           r>=grid.length ||
           c>=grid[0].length ||
           grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        for(int[] d : dir)
            dfs(grid,
                r+d[0],
                c+d[1]);
    }
}