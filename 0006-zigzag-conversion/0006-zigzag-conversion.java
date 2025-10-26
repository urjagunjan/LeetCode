class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int gap=2*numRows-2;
        String New="";
        for(int i=0;i<numRows;i++){
            for(int j=i;j<s.length();j=j+gap){
                New=New+s.charAt(j);
                int diag = j + gap - 2 * i;
                if (i != 0 && i != numRows - 1 && diag < s.length()) {
                    New=New+s.charAt(diag);
                }
            }

        }
        return New;
        
    }
}