class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String c : tokens){
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int a=stack.pop();
                int b=stack.pop();
                switch(c){
                    case "+":stack.push(b+a);break;
                    case "-":stack.push(b-a);break;
                    case "*":stack.push(b*a);break;
                    case "/":stack.push(b/a);break;
                }
                
            }
            else{
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
        
    }
}