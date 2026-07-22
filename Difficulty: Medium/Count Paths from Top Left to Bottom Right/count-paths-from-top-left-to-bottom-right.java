class Solution {
    public int numberOfPaths(int m, int n) {
        // code here
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return dfs(m-1,n-1,dp,m,n);
    }
    public int dfs(int i,int j,int[][] dp,int m,int n){
        if(i==0&&j==0)return 1;
        if(i<0||j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int up=0;
        int left=0;
        up+=dfs(i-1,j,dp,m,n);
        left+=dfs(i,j-1,dp,m,n);
        return dp[i][j]=up+left;
    }
}