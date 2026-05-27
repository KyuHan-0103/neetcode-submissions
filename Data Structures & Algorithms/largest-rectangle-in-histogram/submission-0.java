class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxA = 0;
        int start;
        for(int i = 0; i < heights.length; i++){
            start = i;
            //maxA = Math.max(maxA, heights[i]);
            while(!stack.isEmpty() && heights[i] < stack.peek()[1]){
                maxA = Math.max(maxA, stack.peek()[1] * (i - stack.peek()[0]));
                start = stack.peek()[0];
                stack.pop();
            }
            stack.push(new int[]{start, heights[i]});
        }
        for(int[] i : stack){
            maxA = Math.max(maxA, i[1] * (heights.length - i[0]));
        }
        return maxA;
    }
}
