class Solution {
    public int totalWaviness(int num1, int num2) {
        int waviness=0;
        for(int n=num1;n<=num2;n++){
            String nums=Integer.toString(n);
            if(nums.length()<3)
                continue;
            else{
                for(int i=1;i<nums.length()-1;i++){
                    int before=nums.charAt(i-1)-'0';
                    int middle=nums.charAt(i)-'0';
                    int later=nums.charAt(i+1)-'0';


                    if(middle>before && middle>later){
                        waviness++;
                    }
                    else if(middle<before && middle<later){
                        waviness++;
                    }
                }
            }
            
        }
        return waviness;
        
    }
}