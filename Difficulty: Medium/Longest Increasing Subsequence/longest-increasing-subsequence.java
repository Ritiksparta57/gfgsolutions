class Solution {
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        List<Integer> l=new ArrayList<>();
        l.add(arr[0]);
        for(int i=0;i<n;i++){
            while(arr[i]>l.get(l.size()-1)){
                l.add(arr[i]);
            }
            int ind=index(arr[i],l);
            if(ind<0)ind=-(ind+1);
            l.set(ind,arr[i]);
        }
        return l.size();
    }
    public static int index(int a,List<Integer> l){
        int l1=0;
        int h=l.size()-1;
        int ans=-1;
        while(l1<=h){
            int mid=(l1+h)/2;
            if(l.get(mid)<a)l1=mid+1;//not taking mid as ans as what we will do after removing the smaller one;
            else {
                h=mid-1;
                ans=mid;
            }
        }
        return ans;
    }
}