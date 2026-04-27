class Solution {
    class Pair{
        int val;
        int frequency;
        public Pair(int val,int frequency){
            this.val=val;
            this.frequency=frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(b.frequency,a.frequency));
        for(int key:map.keySet()){
            pq.offer(new Pair(key,map.get(key)));
        }
        int[] arr=new int[k];
        while(k!=0 && !pq.isEmpty()){
            Pair curr=pq.poll();
            arr[k-1]=curr.val;
            k--;
        }
        return arr;
    }
}