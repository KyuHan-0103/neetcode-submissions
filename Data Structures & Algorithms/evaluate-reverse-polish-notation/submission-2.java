class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int a;
        int b;
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b + a);
            }else if(tokens[i].equals("-")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b - a);
            }else if(tokens[i].equals("*")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b * a);
            }else if(tokens[i].equals("/")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.peek();
    }
}
