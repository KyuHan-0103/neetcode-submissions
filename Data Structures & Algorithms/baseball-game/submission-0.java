class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int total = 0;
        for(int i = 0; i < operations.length; i++){
            if(operations[i].equals("C")){
                total -= stack.pop();
            } else if(operations[i].equals("D")){
                stack.push(stack.peek() * 2);
                total += stack.peek();
            } else if(operations[i].equals("+")){
                int n1 = stack.pop();
                int addedNum = stack.peek() + n1;
                stack.push(n1);
                stack.push(addedNum);
                total += addedNum;
            } else {
                int num = Integer.valueOf(operations[i]);
                total += num;
                stack.push(num);
            }
        }
        return total;
    }
}