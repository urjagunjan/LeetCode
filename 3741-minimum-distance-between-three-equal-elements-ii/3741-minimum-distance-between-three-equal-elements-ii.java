class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key=nums[i];
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(i);
        }
        int mini=(int)1e9;
        for(int key: map.keySet()){
            if(map.get(key).size()>=3){
                for(int loop=0;loop<=map.get(key).size()-3;loop++){
                    int i=map.get(key).get(loop);
                    int j=map.get(key).get(loop+1);
                    int k=map.get(key).get(loop+2);
                    int temp=Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                    mini=Math.min(mini,temp);
                }
            }
        }
        return mini==(int)1e9?-1:mini;
    }
}