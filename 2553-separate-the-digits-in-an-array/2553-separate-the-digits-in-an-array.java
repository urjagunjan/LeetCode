class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i:nums){
            int num=i;
            ArrayList<Integer> temp=new ArrayList<>();
            while(num!=0){
                temp.add(num%10);
                num/=10;
            }
            Collections.reverse(temp);
            for(int j:temp){
                arr.add(j);
            }
        }
        int[] res=new int[arr.size()];
        int i=0;
        for(int n:arr){
            res[i]=n;
            i++;
        }
        return res;
        
    }
}