class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();

        st.push(s.charAt(0));
        for(int i=1;i<n;i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==st.peek()){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}