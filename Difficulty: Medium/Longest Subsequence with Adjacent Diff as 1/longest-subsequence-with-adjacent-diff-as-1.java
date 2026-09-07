class Solution {
	public int longestSubseq(int[] arr) {
		int n=arr.length;
		Map<Integer,Integer> m=new HashMap<>();
		int ans=0;
		//count the no. of elements in the subsequence till that element by checking the value of el+1 and el-1;
		//then put a count pointer on element and then check for maximum either from el-1 or el+1;
		for(int num:arr){
		    int c=1;
		    if(m.containsKey(num-1))c=Math.max(m.get(num-1)+1,c);
		    if(m.containsKey(num+1))c=Math.max(c,m.get(num+1)+1);
		    ans=Math.max(c,ans);
		    m.put(num,c);
		}
		return ans;
	}
}
