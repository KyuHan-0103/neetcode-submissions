public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for (int stone : stones) {
            stoneSum += stone;
        }
        int target = stoneSum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for(int s : stones){
            Set<Integer> newDp = new HashSet<>(dp);
            for(int n : dp){
                if(n + s == target){
                    return stoneSum - 2 * target;
                }
                if(n + s < target){
                    newDp.add(n + s);
                }
            }
            dp = newDp;
        }

        int maxVal = 0;

        for(int n : dp){
            maxVal = Math.max(n, maxVal);
        }
        return stoneSum - 2 * maxVal;
    }
}