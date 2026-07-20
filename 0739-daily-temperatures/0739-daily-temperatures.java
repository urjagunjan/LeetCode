class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s=new Stack<>();
        int n =temperatures.length;
        int[] res=new int[n];
        s.push(0);
        for(int i=1;i<n;i++){
            int curr=temperatures[i];
            while(!s.isEmpty() && curr>temperatures[s.peek()]){
                int indx=s.peek();
                res[indx]=i-indx;
                s.pop();
            }
            s.push(i);
        }
        return res;
    }
}