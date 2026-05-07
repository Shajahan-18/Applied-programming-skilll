class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> q =
            new LinkedList<>();

        boolean[][] visited =
            new boolean[rows][cols];

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {

                if(mat[i][j] == 0) {
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dir = {
            {1,0},{-1,0},{0,1},{0,-1}
        };

        while(!q.isEmpty()) {

            int[] cur = q.poll();

            for(int[] d : dir) {

                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if(nr>=0 && nc>=0 &&
                   nr<rows && nc<cols &&
                   !visited[nr][nc]) {

                    mat[nr][nc] =
                        mat[cur[0]][cur[1]] + 1;

                    visited[nr][nc] = true;

                    q.offer(new int[]{nr,nc});
                }
            }
        }

        return mat;
    }
}