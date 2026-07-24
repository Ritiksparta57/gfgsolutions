class Solution {
    public int startStation(int[] gas, int[] cost) {
        // code here
        int totg=0;
        int totc=0;
        int n=gas.length;
        for(int i=0;i<n;i++){
            totg+=gas[i];
            totc+=cost[i];
        }
        if(totg<totc)return -1;// jab utna fuel hi nhi hai to kaha se cost ko meet karega;
        int tank=0;
        int start=0;
        for(int i=0;i<n;i++){
            tank+=gas[i]-cost[i];
            if(tank<0){
                tank=0;
                start=i+1;
            }
        }
        return start;
    }
}