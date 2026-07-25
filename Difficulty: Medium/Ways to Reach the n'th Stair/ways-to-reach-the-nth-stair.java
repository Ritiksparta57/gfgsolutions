class Solution {
    public int countWays(int n) {
        // code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(n,dp);
    }
    public int dfs(int n,int[] dp){
        if(n==0)return 1;
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        int one=0;
        int two=0;
        one+=dfs(n-1,dp);
        two+=dfs(n-2,dp);
        return dp[n]=one+two;
    }
}