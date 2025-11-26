class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] isvisited=new boolean[nums.length];
        helper(nums,ans,new ArrayList<>(),isvisited);
        return ans;
            
    }
    public static void helper(int[] nums,List<List<Integer>> ans,ArrayList<Integer> temp,boolean[] isvisited){
        int n=nums.length;
        if(temp.size()==n){
            ArrayList<Integer> result=new ArrayList<>(temp);
            ans.add(result);
            return;
        }
        for(int i=0;i<n;i++){
            if(isvisited[i]==true){
                continue;
            }
            isvisited[i]=true;
            temp.add(nums[i]);
            helper(nums,ans,temp,isvisited);
            isvisited[i]=false;
            temp.remove(temp.size()-1);

        }
    }
    
}