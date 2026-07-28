class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] pre) {
        // code here
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(int[] edge:pre){
            int u=edge[0];
            int v=edge[1];
            l.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.offer(i);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int u=q.poll();
            ans.add(u);
            for(int neigh:l.get(u)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.offer(neigh);
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}