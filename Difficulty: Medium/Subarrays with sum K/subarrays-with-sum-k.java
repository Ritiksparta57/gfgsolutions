class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        int n=arr.length;
        int count=0;
        int sum=0;
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int remove=sum-k;
            //basically if we remove k from sum then this removed or diff must be there in map 
            //as the sum might have already appeared;
            // thus the count+=m.get(remove) as the amount of timwe that sum has occured;
            if(m.containsKey(remove)){
                count+=m.get(remove);
            }
            m.put(sum,m.getOrDefault(sum,0)+1);
        }
        return count;
    }
}