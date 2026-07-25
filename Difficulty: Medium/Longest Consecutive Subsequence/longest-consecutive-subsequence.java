class Solution {
    public int longestConsecutive(int[] arr) {
        // code here
        int n=arr.length;
        Set<Integer> st=new HashSet<>();
        for(int num:arr){st.add(num);}
        int count=0;
        for(int i=0;i<n;i++){
          if(!st.contains(arr[i]-1)){
              //that is there is no starting point of sequence before this no.;
              int s=arr[i];
              int len=1;
              while(st.contains(s+1)){
                  s++;
                  len++;
              }
              count=Math.max(count,len);
          }
        }
        return count;
    }
}