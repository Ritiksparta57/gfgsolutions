class Solution {
    public int maxValue(int[] arr) {
        // code here
        int n=arr.length;
        int[] dp=new int[n];
        int[] dp1=new int[n];
        Arrays.fill(dp,-1);
        Arrays.fill(dp1,-1);
        int max=Math.max(dfs(n-1,arr,1,dp),dfs(n-2,arr,0,dp1));
        return max;
    }
    public int dfs(int i,int[] arr,int max,int[] dp){
        if(i==max)return dp[i]=arr[i];
        if(i<max)return 0;
        if(dp[i]!=-1)return dp[i];
        return dp[i]=Math.max(dfs(i-1,arr,max,dp),arr[i]+dfs(i-2,arr,max,dp));
    }
}
