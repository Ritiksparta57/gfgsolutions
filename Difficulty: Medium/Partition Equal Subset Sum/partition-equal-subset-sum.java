class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++)sum+=arr[i];
        if(sum%2!=0)return false;
        Boolean[][] dp=new Boolean[n][(sum/2)+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],null);
        }
        return dfs(n-1,dp,sum/2,arr);
    }
    public static boolean dfs(int i,Boolean[][] dp,int sum,int[] arr){
        if(i==0){
            if(sum==0)return dp[i][sum]=true;
            else if(sum==arr[0])return dp[i][sum]=true;
            else return false;
        }
        if(dp[i][sum]!=null)return dp[i][sum];
        boolean not=dfs(i-1,dp,sum,arr);
        boolean pick=false;
        if(sum>=arr[i]){
            pick=dfs(i-1,dp,sum-arr[i],arr);
        }
        return dp[i][sum]=(not||pick);
    }
}