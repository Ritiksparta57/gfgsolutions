class Solution {
    public int longestPalinSubseq(String s) {
        // code here
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        String s1=sb.reverse().toString();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return dfs(0,0,n,s,s1,dp);
    }
    public int dfs(int i,int j,int n,String s,String s1,int[][] dp){
        if(i==n||j==n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int l=0;
        char ch=s.charAt(i);
        char c=s1.charAt(j);
        if(ch==c){
            l=1+dfs(i+1,j+1,n,s,s1,dp);
        }
        else{
            l=Math.max(dfs(i+1,j,n,s,s1,dp),dfs(i,j+1,n,s,s1,dp));
        }
        return dp[i][j]=l;
    }
}