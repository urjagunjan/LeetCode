class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap= new PriorityQueue();
        for(int i:nums){
            maxheap.add(i);
            if(maxheap.size()>k){
            maxheap.poll();
            }
        }
        return maxheap.peek();
        
    }
}