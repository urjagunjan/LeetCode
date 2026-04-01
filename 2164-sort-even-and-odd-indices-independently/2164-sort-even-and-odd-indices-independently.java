class Solution {
    public int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer> odd=new ArrayList<>();
        ArrayList<Integer> even=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(i%2==0)odd.add(nums[i]);
            else even.add(nums[i]);
        }
        Collections.sort(even);
        Collections.sort(odd);
        Collections.reverse(even);

        int e=0;
        int o=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=odd.get(e);
                e++;
            }
            else{
                nums[i]=even.get(o);
                o++;
            }
        }
        return nums;
    }
}