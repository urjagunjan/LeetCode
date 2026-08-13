class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new  Stack();
        int n=heights.length;
        
        int maximum=0;

        for(int i=0;i<=n;i++){
            int curr=(i==n)?0:heights[i];

            while(!s.isEmpty() && curr < heights[s.peek()]){
                int h=heights[s.pop()];
                int w=(s.isEmpty())?i:i-s.peek()-1;

                maximum=Math.max(maximum,h*w);
            }
            s.push(i);
        }
        return maximum;
    }
}