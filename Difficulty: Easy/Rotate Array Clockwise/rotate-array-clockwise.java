class Solution {
    public void rotateclockwise(int[] arr, int k) {
        // code here
        int n=arr.length;
        k=k%n;
        rev(0,n-k-1,arr);
        rev(n-k,n-1,arr);
        rev(0,n-1,arr);
    }
    public void rev(int s,int e,int[] arr){
        while(s<=e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
}