class pair{
    int v;
    int w;
    int dist;
    public pair(int v1,int w1,int d){
        this.v=v1;
        this.w=w1;
        this.dist=d;
    }
}
class Solution {
    public int findDelayTime(int V, int[][] edges, int src) {
        // code here
        List<List<pair>> l=new ArrayList<>();
        for(int i=0;i<V;i++){
            l.add(new ArrayList<>());
        }
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            l.get(u).add(new pair(v,w,Integer.MAX_VALUE));
        }
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->a.w-b.w);
        dist[src]=0;
        q.offer(new pair(src,0,0));
        while(!q.isEmpty()){
            pair p=q.poll();
            int u=p.v;
            int w=p.w;
            int d=p.dist;
            for(pair neigh:l.get(u)){
                int v=neigh.v;
                int w1=neigh.w;
                int d1=d+w1;
                if(dist[v]>d1){
                    dist[v]=d1;
                    q.offer(new pair(v,w1,dist[v]));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            else{
                if(dist[i]>max)max=dist[i];
            }
        }
        return max;
    }
}