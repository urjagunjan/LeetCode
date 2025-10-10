class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int closure=Integer.MIN_VALUE;
        int asciitar=(int)target;
        char res=letters[0];
        int start=0;
        int end=letters.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(letters[mid]<=target){
                start=mid+1;
            }
            else if(letters[mid]>target){
                int ascii=(int)letters[mid];
                if(asciitar-ascii>closure){
                    closure=asciitar-ascii;
                    res=letters[mid];
                }
                end=mid-1;
            }
        }
        return res;
    }
}