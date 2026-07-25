class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return dfs(arr,dp,n-1);
    }
    public int dfs(int[] arr,int[] dp,int i){
        if(i==0)return dp[i]=arr[i];
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        int pick=0;
        int not=0;
        not=dfs(arr,dp,i-1);
        pick=arr[i]+dfs(arr,dp,i-2);
        return dp[i]=Math.max(pick,not);
    }
}
