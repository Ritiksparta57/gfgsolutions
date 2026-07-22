class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==1||grid[m-1][n-1]==1)return 0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return dfs(m-1,n-1,grid,m,n,dp);
    }
    public int dfs(int i,int j,int[][] grid,int m,int n,int[][] dp){
        if(i==0&&j==0)return 1;
        if(i<0||j<0||grid[i][j]==1)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int up=0;
        int left=0;
        up+=dfs(i-1,j,grid,m,n,dp);
        left+=dfs(i,j-1,grid,m,n,dp);
        return dp[i][j]=up+left;
    }
};