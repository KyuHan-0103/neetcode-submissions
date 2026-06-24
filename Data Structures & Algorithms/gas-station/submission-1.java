class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int val = 0;
        int tC = 0;
        for(int i = 0; i < cost.length; i++){
            tC += gas[i] - cost[i];
            if(val == -1 && gas[i] - cost[i] > 0){
                start = i;
                val = gas[i] - cost[i];
            } else if(val + gas[i] - cost[i] < 0) {
                start = -1;
                val = -1;
            } else {
                val += gas[i] - cost[i];
            }
        }

        return (tC >= 0) ? start : -1;
    }
}
