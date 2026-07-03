class Solution {
    public int editDistance(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return dfs(s1,s2,n-1,m-1,dp);
    }
    public int dfs(String s1,String s2,int i,int j,int[][] dp){
        if(i<0)return j+1;//that many characters to be added in s1 to make it s2;
        if(j<0)return i+1;//that many characters to be deleted in s1;
        if(dp[i][j]!=-1)return dp[i][j];
        char ch=s1.charAt(i);
        char c=s2.charAt(j);
        int insert=0;
        int delete=0;
        int replace=0;
        if(ch==c)return dp[i][j]=dfs(s1,s2,i-1,j-1,dp);
        else{
            insert=1+dfs(s1,s2,i,j-1,dp);
            //adding 1 as we use insert operation once;
            //we are inserting the element after i so the next time i reains same but j is being inserted so it goes down by 1;
            delete=1+dfs(s1,s2,i-1,j,dp);
            //again 1 as delete is used once and once we use delete ,we delete ith character
            //i.e. we if i and j do not match then i is removed and i-1 is compared to j;
            replace=1+dfs(s1,s2,i-1,j-1,dp);
            // when both does not match then we replace i with j thus making them equal
            // but we move both pointers down by 1 as there is nothing to comapre as both are equal now;
        }
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
}