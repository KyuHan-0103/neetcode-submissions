class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] steps = new int[cost.length];
        steps[cost.length - 1] = cost[cost.length - 1];
        steps[cost.length - 2] = cost[cost.length - 2];

        for(int i = cost.length - 3; i >= 0; i--){
            steps[i] = cost[i] + Math.min(steps[i + 1], steps[i + 2]);
        }
        return Math.min(steps[0], steps[1]);
    }
}
