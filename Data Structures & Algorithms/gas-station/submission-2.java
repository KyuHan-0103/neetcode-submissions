class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int res = 0;
        int tC = 0;
        for(int i = 0; i < cost.length; i++){
            tC += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if(total < 0){
                total = 0;
                res = i + 1;
            }
        }

        return (tC >= 0) ? res : -1;
    }
}
