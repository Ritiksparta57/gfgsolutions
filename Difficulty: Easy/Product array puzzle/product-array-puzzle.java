class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n=arr.length;
        int[] pre=new int[n];
        int[] suff=new int[n];
        pre[0]=arr[0];
        suff[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]*arr[i];
        }
        for(int i=n-2;i>=0;i--){
            suff[i]=suff[i+1]*arr[i];
        }
        int[] res=new int[n];
        res[0]=suff[1];
        res[n-1]=pre[n-2];
        for(int i=1;i<n-1;i++){
            res[i]=pre[i-1]*suff[i+1];
        }
        return res;
    }
}
