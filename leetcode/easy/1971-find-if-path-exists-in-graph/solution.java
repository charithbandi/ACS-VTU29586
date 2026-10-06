class Solution {
    public void dfs(int i , int j , List<List<Integer>> adj , boolean[] vis){
        if(vis[j]) return;
        vis[i] = true;
        for(int ele : adj.get(i)){ 
            if(vis[j]) return; 
            if(!vis[ele]) dfs(ele , j , adj , vis);}
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int[] x : edges){
            int a = x[0] , b = x[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dfs(source , destination , adj , vis);
        return vis[destination];
    }
}