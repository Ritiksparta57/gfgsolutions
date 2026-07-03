class Solution {
    static boolean match(String wild, String pattern) {
        // code here
        int m=wild.length();
        int n=pattern.length();
        Boolean[][] dp=new Boolean[n][m];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],null);
        return dfs(wild,pattern,0,0,dp,n,m);
    }
    public static boolean dfs(String wild,String pattern,int i,int j,Boolean[][] dp,int n,int m){
        if(i==n&&j==m)return true;
        if(j==m)return false;
        //if j representing wild reaches end but still pattern has not reached end then both are not eequal;
        // the next line if pattern has reached its end and wild is still alive then all characters in wild must be *;        
        if(i==n){
            for(int k=j;k<m;k++){
                if(wild.charAt(k)!='*')return false;
            }
            return true;
        }
        if(dp[i][j]!=null)return dp[i][j];
        char ch=pattern.charAt(i);
        char c=wild.charAt(j);
        if(ch==c)return dp[i][j]=dfs(wild,pattern,i+1,j+1,dp,n,m);
        else{
            if(c=='*'){
                dp[i][j]=dfs(wild,pattern,i+1,j,dp,n,m)||dfs(wild,pattern,i,j+1,dp,n,m);
                //if we want a non empty string then wee keep on moving i i.e. pattern and look where i and j match;
                //else we fill it with empty string thus moving j to j+1 that is the wild string;
            }
            else if(c=='?'){
                dp[i][j]=dfs(wild,pattern,i+1,j+1,dp,n,m);
                //we need to replace only one character thus incrementing both i and j;
            }
            else{
                dp[i][j]=false;//both are not same then surely they are false;
            }
        }
        return dp[i][j];
    }
}