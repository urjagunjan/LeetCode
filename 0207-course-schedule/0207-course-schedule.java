class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=prerequisites.length;
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.offer(i);
        }

        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int temp:adj.get(curr)){
                indegree[temp]--;
                if(indegree[temp]==0)q.offer(temp);
            }
        }
        return (res.size()==numCourses)?true:false;
    }
}