class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] answer=new int[n];
        Stack<Integer> s=new Stack<>();
        s.push(0);

        for(int i=1;i<n;i++){
            int currtemp=temperatures[i];
            while(!s.isEmpty()){
                int indx=s.peek();
                int toptemp=temperatures[indx];
                if(toptemp<currtemp){
                    answer[indx]=i-indx;
                    s.pop();
                }
                else{
                    break;
                }
            }
            s.push(i);
        }
        return answer;

    }
}