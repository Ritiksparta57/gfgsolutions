class Solution {
    public boolean makeChanges(int k, int target, int[] coins) {
        // code here
        int n=coins.length;
        Boolean[][][] dp=new Boolean[n][target+1][k+1];
        for(int i=0;i<n;i++){for(int j=0;j<target+1;j++)Arrays.fill(dp[i][j],null);}
        return dfs(n-1,target,k,dp,coins);
    }
    public boolean dfs(int i,int sum,int k,Boolean[][][] dp,int[] coin){
        if(k==0){
            if(sum==0)return true;
            else return false;
        }
        if(i==0){
            if(k==0&&sum==0)return dp[i][sum][k]=true;
            else if(k>0&&sum%coin[i]==0){
                if(sum/coin[i]==k)return true;
                else return false;
            }
            else return false;
        }
        if(dp[i][sum][k]!=null)return dp[i][sum][k];
        boolean not=dfs(i-1,sum,k,dp,coin);
        boolean pick=false;
        if(coin[i]<=sum){
            pick=dfs(i,sum-coin[i],k-1,dp,coin);
        }
        return dp[i][sum][k]=(pick||not);
    }
}