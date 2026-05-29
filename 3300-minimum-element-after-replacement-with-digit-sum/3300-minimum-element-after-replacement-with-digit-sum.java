class Solution {
    public int minElement(int[] nums) {
        int mini=(int)1e9;
        for(int num:nums){
            if(mini==1)return mini;
            int sumofdigits=0;
            while(num!=0){
                sumofdigits+=num%10;
                num=num/10;
            }
            mini=Math.min(mini,sumofdigits);
        }
        return mini;
    }
}