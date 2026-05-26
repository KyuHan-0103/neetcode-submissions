class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //time to destination = (target - position)/speed
        double[][] sortedPs = new double[position.length][2];
        for(int i = 0; i < position.length; i++){
            sortedPs[i][0] = (double) position[i];
            sortedPs[i][1] = (double) (target - position[i])/speed[i];
        }

        Arrays.sort(sortedPs, (a, b) -> Double.compare(b[0], a[0]));

        Deque<Double> stack = new ArrayDeque<>();
        int res = 0;
        for(double[] arr : sortedPs){
            if(stack.isEmpty()){
                stack.push(arr[1]);
                res++;
            }else if(arr[1] > stack.peek()){
                stack.pop();
                res++;
                stack.push(arr[1]);
            } else {
                continue;
            }
        }
        return res;
    }
}
