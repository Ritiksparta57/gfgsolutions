class Solution {
    // Function to return list containing first n fibonacci numbers.
    public static int[] fibonacciNumbers(int n) {
        // Your code here
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=dfs(i,dp);
        }
        return ans;
    }
    public static int dfs(int n,int[] dp){
        if(n==0)return 0;
        if(n==1)return 1;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=dfs(n-1,dp)+dfs(n-2,dp);
    }
}