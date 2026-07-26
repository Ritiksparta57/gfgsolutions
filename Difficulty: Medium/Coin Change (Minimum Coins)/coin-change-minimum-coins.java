class Solution {
	
	public int minCoins(int coins[], int sum) {
		// code here
		int n = coins.length;
		int[][] dp = new int[n][sum+1];//we use 2d dp as for same index there might be different sums that may alter result of others;
		for(int i=0;i<n;i++)Arrays.fill(dp[i], Integer.MAX_VALUE);
		int res = dfs(coins, dp, n-1, sum);
		return res ==(int)1e9?-1:res;
	}
	public int dfs(int[] coin, int[][] dp, int i, int sum) {
		if(i==0){
		    if(sum%coin[i]==0)return sum/coin[i];
		    else return (int)1e9;
		}
		if(dp[i][sum]!=Integer.MAX_VALUE)return dp[i][sum];
		int not=dfs(coin,dp,i-1,sum);//this covers both cases when we are not taking the index i;
		//also it covers when we have to move to the next element;
		int pick=(int)1e9;
		if(coin[i]<=sum){
		    pick=1+dfs(coin,dp,i,sum-coin[i]);//we are adding 1 as we are taking one coin 
		    //also we are not moving to other index instead we use the same index as above covers it all;
		}
		return dp[i][sum]=Math.min(pick,not);
	}
}
