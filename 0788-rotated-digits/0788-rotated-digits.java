class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int nums=i;
            boolean invalid=false;
            boolean changed=false;
            while(nums!=0){
                int num=nums%10;
                if(num==3 || num==4 || num==7){
                    invalid=true;
                    break;
                }
                if( num==2 || num==5||num==6||num==9)changed=true;
                nums=nums/10;
            }
            if(!invalid && changed)count++;
        }
        return count;
    }
}