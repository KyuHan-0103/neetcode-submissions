class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //time to destination = (target - position)/speed
        List<List<Double>> sortedPs = new ArrayList<>();
        for(int i = 0; i < position.length; i++){
            sortedPs.add(new ArrayList(List.of((double) position[i], (double)(target-position[i])/speed[i])));
        }

        sortedPs.sort((a, b) -> Double.compare(b.get(0), a.get(0)));

        Deque<Double> stack = new ArrayDeque<>();
        int res = 0;
        for(List<Double> arr : sortedPs){
            if(stack.isEmpty()){
                stack.push(arr.get(1));
                res++;
            }else if(arr.get(1) > stack.peek()){
                stack.pop();
                res++;
                stack.push(arr.get(1));
            } else {
                continue;
            }
        }
        return res;
    }
}
