class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int n=coins.length;
        int[][] dp=new int[n][sum+1];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],Integer.MAX_VALUE);
        return dfs(n-1,coins,dp,sum);
    }
    public int dfs(int i,int[] coin,int[][] dp,int sum){
        if(sum==0)return 1;
        if(i==0){
            if(sum%coin[i]==0)return 1;
            else return 0;
        }
        if(sum<0)return 0;
        if(dp[i][sum]!=Integer.MAX_VALUE)return dp[i][sum];
        int not=0;
        int pick=0;
        not+=dfs(i-1,coin,dp,sum);
        if(sum>=coin[i]){
            pick+=dfs(i,coin,dp,sum-coin[i]);
        }
        return dp[i][sum]=pick+not;
    }
}