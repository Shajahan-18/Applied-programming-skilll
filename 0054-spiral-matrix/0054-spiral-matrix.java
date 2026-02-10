class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int strow=0;
        int stcol=0;
        int endrow=matrix.length-1;
        int endcol=matrix[0].length-1;

        while(stcol<=endcol && strow<=endrow  ){
            for(int i=stcol;i<=endcol;i++){
                result.add(matrix[strow][i]);
            }
            for(int j=strow+1;j<=endrow;j++){
                result.add(matrix[j][endcol]);
            }
            for(int k=endcol-1;k>=stcol;k--){
                if(strow==endrow){
                    break;
                }
                result.add(matrix[endrow][k]);

            }
            for(int l=endrow-1;l>=strow+1;l--){
                if (stcol==endcol){
                    break;
                }
                result.add(matrix[l][strow]);

            }
            strow++;
            stcol++;
            endrow--;
            endcol--;

        }
        return result;


    }
}