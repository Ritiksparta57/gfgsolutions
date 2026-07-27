class Solution {
    public int maximumPath(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int max=Integer.MIN_VALUE;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-(int)1e9);
        for(int j=0;j<m;j++){
            int l=dfs(n-1,j,n,m,mat,dp);
            max=Math.max(max,l);
        }
        return max;
    }
    public int dfs(int i,int j,int n,int m,int[][]mat,int[][]dp){
        if(i<0||j<0||i>=n||j>=m)return -(int)1e9;
        if(i==0){
            if(j>=0)return dp[i][j]=mat[i][j];
            return -(int)1e9;
        }
        if(dp[i][j]!=-(int)1e9)return dp[i][j];
        int up=0;
        int left=0;
        int right=0;
        up=mat[i][j]+dfs(i-1,j,n,m,mat,dp);
        left=mat[i][j]+dfs(i-1,j-1,n,m,mat,dp);
        right=mat[i][j]+dfs(i-1,j+1,n,m,mat,dp);
        int sum=Math.max(up,Math.max(left,right));
        if(sum==-(int)1e9)return dp[i][j]=-(int)1e9;
        return dp[i][j]=sum;
    }
}