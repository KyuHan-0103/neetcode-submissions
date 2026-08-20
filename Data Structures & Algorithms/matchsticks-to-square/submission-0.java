class Solution {
    int[] res = new int[4];
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for(int n : matchsticks){
            total += n;
        }
        if(total % 4 != 0){
            return false;
        }
        int side = total/4;
        return backtrack(matchsticks, side, 0);
    }

    private boolean backtrack(int[] matchsticks, int side, int i){
        if(i == matchsticks.length) return true;
        
        for(int j = 0; j < 4; j++){
            if(res[j] + matchsticks[i] > side){
                continue;
            }
            res[j] += matchsticks[i];
            if(backtrack(matchsticks, side, i + 1)){
                return true;
            }
            res[j] -= matchsticks[i];
        }
        return false;
    }
}